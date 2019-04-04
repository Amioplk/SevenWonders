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
  LinkedList<Player> players;
  // Référentiel
  Frame frame;

  static void swapHands(Player x, Player y) { // A tester
	  
	  ArrayList<Card> xCards = x.getHand();
	  x.setHand(y.getHand());
	  y.setHand(xCards);
  }
  
  static Player swapHands(Iterator<Player> it, Player player) { // A tester
    //Echange les mains de deux joueurs --> mettre limite si Iterator.next() pas un Player

	  if(!it.hasNext()) {
		  return player;
	  }
	  
	  Player newPlayer = it.next();
	  swapHands(player, newPlayer);
	  
	  return swapHands(it, newPlayer);
	  
  }

  void draft() { // A tester

    Iterator<Player> it = (era % 2 == 1) ? this.players.iterator() : this.players.descendingIterator();

    Player player = this.players.getFirst();
    Player lastPlayer = new Player();
    while(it.hasNext()) {

      lastPlayer = swapHands(it, player);

    }

    swapHands(player, lastPlayer);
    
  }

  boolean endEra() { // A tester

    return( players.getFirst().getHand().size() <= 1 );
    
  }

  void beginEra() {
	  this.allocateCards();
  }
  
  void setGame() {
	  
  }
  
  void allocateCards() {
	  // Distribuer les cartes
  }
  
  int countPoints(Player player) {
	  return 0;
  }
}
