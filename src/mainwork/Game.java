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

  static void exchangeHands(Iterator<Player> it, ArrayList<Card> hand) { //Sous-optimal !!!
    //Echange les mains de deux joueurs --> mettre limite si Iterator.next() pas un Player
    Player player = (Player)it.next();
    ArrayList<Card> tmp = new ArrayList<>();
    tmp.addAll(player.hand);
    player.hand.clear();
    player.hand.addAll(player.hand);
    hand.clear();
    hand.addAll(tmp);

  }

  void draft() { // A tester

    Iterator<Player> it = (era%1==0) ? this.players.iterator() : this.players.descendingIterator();

    ArrayList<Card> hand = this.players.getFirst().hand;
    while(it.hasNext()) {

      exchangeHands(it, hand);

    }

    players.getFirst().hand.clear();
    players.getFirst().hand.addAll(hand);
  }

  boolean endEra() { // A tester

    return( players.getFirst().hand.size() <= 1 );
    
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
