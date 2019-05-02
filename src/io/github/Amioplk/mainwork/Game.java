package io.github.Amioplk.mainwork;
import java.util.*;
import java.util.stream.Collectors;

// Type de jeu ? Chacun son tour ? En reseau ?



public class Game {
  //On met ici l'etat du jeu en general

  // Ere
  int era;
  // Defausse (Collection)
  Collection<Card> defausse;
  // Extentions (https://gusandco.net/2012/06/14/7-wonders-compile-de-toutes-nos-extensions/)
  List<String> ext;
  // Placement des joueurs
  public ArrayList<Player> players;
  // Référentiel
  Frame frame;

  static void swapHands(Player x, Player y) { // A tester
	  
	  ArrayList<Card> xCards = x.getHand();
	  x.setHand(y.getHand());
	  y.setHand(xCards);
  }
  
  static void swapHands(Iterator<Player> it, Player player) { // A tester
    //Echange les mains de deux joueurs --> mettre limite si Iterator.next() pas un Player

	  if(!it.hasNext()) {
		  return;
	  }
	  
	  Player newPlayer = it.next();
	  swapHands(player, newPlayer);
	  
	  swapHands(it, newPlayer);
	  
  }

  void draft() { // A tester
	  
	ArrayList<Player> properPlayers = new ArrayList<>();
	properPlayers.addAll(this.players);
    if(era % 2 == 1) Collections.reverse(properPlayers);
    Iterator<Player> it = properPlayers.iterator();
     
    while(it.hasNext()) {

      swapHands(it, properPlayers.get(0));

    }
   
  }

  /**
 * Verifier que les joueurs ne sont pas vide
 */
  boolean endEra() { // A tester

    return( players.get(0).getHand().size() <= 1 );
    
  }

  void beginEra() {

	  this.allocateCards();
  }
  
  /**
 * Les players doivent etre donnes dans l'ordre des aiguilles d'une montre
 */
  void setGame() {
	  
  }
  
  /**
 * Verifier que les cartes sont bien distribuées équitablement
 */
  void allocateCards() { // A tester
	  // Distribuer les cartes
	
	Set<Card> eraCards = frame.cards.get(this.era);
	
	int i = 1;
	for(Card card : eraCards) {
		players.get(i%players.size()).getHand().add(card);
		++i;
	}
  }
  
  void allocateWonders() {
	  
  }
  
  boolean dealAction(Player user) {
	  Card card = choseCard(user);
	  if(!user.checkRessources(card.cost)) {return false;}
	  
	  boolean ok = dealBorrowing(user, card);
	  if(!ok) return false;
	  
		switch(choseMode()) {
	  		case("Thrown") : {
	  			if(card.getAction() instanceof ThrownAction) ok = ((ThrownAction) card.getAction()).apply();
	  		}
	  		case("Wonder") : {
	  			ok = (new WonderAction(this, user)).apply();
	  		}
	  		case("Discard") : this.discardCard(card, user);
	  		default : this.discardCard(card, user);
	  	}
	  
	  if(ok) user.cards.remove(card);
  
	  return ok;
  }

  private boolean dealBorrowing(Player player, Card card) {
	
	Cost toBorrow = missingAmount(player, card.cost);
	if(player.getMoney() < toBorrow.dist.values().stream().mapToInt(i -> i.intValue()).sum()) return false;
	
	for(Ressource r : toBorrow.dist.keySet()) {
		
		int many = toBorrow.dist.get(r);
		
		Player lNeighbour = this.getNeighbour(player, true);
		Player rNeighbour = this.getNeighbour(player, false);
		
		boolean left = lNeighbour.getTotalRessources(r) >= 0;
		boolean right = rNeighbour.getTotalRessources(r) >= 0;
	
		if(left && right) {
			// Choose player
		}
		else if(left) {
			if(lNeighbour.getTotalRessources(r) < many) return false;
			else {
				lNeighbour.addMoney(many*player.priceLeft);
				player.addMoney(-many*player.priceLeft);
			}
		}
		else if(right) {
			if(rNeighbour.getTotalRessources(r) < many) return false;
			else {
				rNeighbour.addMoney(many*player.priceRight);
				player.addMoney(-many*player.priceRight);
			}
		}
	}
	
	return true;
  }

/**
  * Must be private after testing
  * @param player
  * @param right true if we want the right Neighbour, false otherwise
  * @return
  */
  public Player getNeighbour(Player player, boolean right) {
	  
	  int index = this.players.indexOf(player); // Uses Player.equals()
	  
	  int i = right ? 0 : this.players.size() - 1;
	  int realIndex = right ? index + 1 : index - 1;
	  
	  if(realIndex >= this.players.size() || realIndex < 0) {
		  return this.players.get(i);
	  }
	  else {
		  return this.players.get(realIndex);		  
	  }
  }
  
  private Cost missingAmount(Player player, Cost cost) { // Que se passe t'il si il n'y a aucune resssource manquante ?
	return Cost.instanciateCost(cost,
					cost.dist.keySet().stream().filter(r -> (player.getTotalRessources(r) >= cost.dist.get(r)))
											   								   .collect(Collectors.toSet()));
  }

  private void discardCard(Card card, Player user) {
	  this.defausse.add(card);
	  user.setMoney(user.getMoney() + 3);
  }

  private Card choseCard(Player player) {
	  return new Card("Discard", CardType.OTHER);
  }
  
  private String choseMode() {
	  return "Discard"; 
  }
  
}
