package main.java.io.github.Amioplk.mainwork;
import java.util.*;
import java.util.stream.Collectors;

// Type de jeu ? Chacun son tour ? En reseau ?



/**
 * @author Amioplk
 * Represente l'etat du jeu en general
 */
public class Game {

  // Ere
  int era;
  /**
 * Defausse des cartes
 */
Collection<Card> defausse;
  /**
 * Extentions (https://gusandco.net/2012/06/14/7-wonders-compile-de-toutes-nos-extensions/)
 */
List<String> ext;
  /**
 * Placement des joueurs
 */
public ArrayList<Player> players;
  /**
 * Référentiel du jeu
 */
  Frame frame;

  static void swapHands(Player x, Player y) { // A tester
	  
	  ArrayList<Card> xCards = x.getHand();
	  x.setHand(y.getHand());
	  y.setHand(xCards);
  }
  
/**
 * @param it
 * @param player
 * Fonction reccursive qui echange les mains de deux joueurs
 */
static void swapHands(Iterator<Player> it, Player player) { // A tester

	  if(!it.hasNext()) {
		  return;
	  }
	  
	  Player newPlayer = it.next();
	  swapHands(player, newPlayer);
	  
	  swapHands(it, newPlayer);
	  
  }

  /**
 * Phase de draft
 */
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
 * Verifier que les joueurs ne sont pas vides
 * @throws IllegalAccessException 
 */
  boolean endEra() throws IllegalAccessException { // A tester

	if(players.size() == 0) {
		throw new IllegalStateException();
	}
	if(players.get(0).getHand() == null) {
		throw new IllegalStateException();
	}
	  
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
   * Distribuer les cartes
  */
  void allocateCards() { // A tester
	  // Verifier que les cartes sont bien distribuees equitablement
	
	Set<Card> eraCards = frame.cards.get(this.era);
	
	int i = 1;
	for(Card card : eraCards) {
		players.get(i%players.size()).getHand().add(card);
		++i;
	}
  }
  
  void allocateWonders() {
	  
  }
  
  void dealAction(Player user) {
	 
	 Card card = choseCard(user);
	 if(!user.checkRessources(card.cost)) {dealBorrowing(user, card);}
	  
	 if(choseMode().equals("Thrown")) {
		if(card.getAction() instanceof ThrownAction) ((ThrownAction) card.getAction()).apply();
	 }
	 else if(choseMode().equals("Wonder")) {
		(new WonderAction(user)).apply();
	 }
	 else this.discardCard(card, user);
	  
	 user.cards.remove(card);

  }

  private void dealBorrowing(Player player, Card card) {
	
	//Choose to borrow or not
	  
	Cost toBorrow = missingAmount(player, card.cost);
	if(player.getMoney() < toBorrow.dist.values().stream().mapToInt(i -> i.intValue()).sum()) return;
	
	for(Ressource r : toBorrow.dist.keySet()) {
		
		(new BorrowAction(r, toBorrow.dist.get(r))).apply();
		
	}

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
