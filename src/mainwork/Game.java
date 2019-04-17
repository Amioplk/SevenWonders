package mainwork;
import java.util.*;

// Type de jeu ? Chacun son tour ? En reseau ?



class Game {
  //On met ici l'etat du jeu en general

  // Ere
  int era;
  // Defausse (Collection)
  Collection<Card> defausse;
  // Extentions
  List<String> ext;
  // Placement des joueurs
  ArrayList<Player> players;
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
  
  int countPoints(Player player) {
	  return 0;
  }
  
  boolean dealAction(Player user) {
	  Card card = choseCard(user);
	  if(!user.checkRessources(this, card.cost)) {return false;}
	  
	  Applyable ta;
	  switch(choseMode()) {
	  	case("Thrown") : ta = new ThrownAction(this, user, card);
	  	case("Wonder") : ta = new WonderAction();
	  	case("Discard") : this.discardCard(card, user);
	  	default : this.discardCard(card, user);
	  }
	  
	  return ta.apply();
  }

  private void discardCard(Card card, Player user) {
	  this.defausse.add(card);
	  user.setMoney(user.getMoney() + 3) ;
  }

  private Card choseCard(Player player) {
	  return new Card("Manufacture" ,CardType.RAW);
  }
  
  private String choseMode() {
	  return "Discard"; 
  }
  
}
