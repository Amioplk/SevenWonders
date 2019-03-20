import java.util.*;

// Type de jeu ? Chacun son tour ? En réseau ?



class Game {
  //On met ici l'etat du jeu en general

 // Comptage des points

  // Ere
  int era;
  // Defausse (Collection)
  Collection<Action> defausse;
  // Extentions
  List<String> ext;
  // Placement des joueurs
  LinkedList<Player> players; // Attention !  HashMap ne garantit pas d'ordre alors que TreeMap oui

  static void exchangeHands(Iterator it, LinkedList<String> hand) { //Sous-optimal !!!
    //Echange les mains de deux joueurs --> mettre limite si Iterator.next() pas un Player
    Player player = (Player)it.next();
    LinkedList<String> tmp = new LinkedList<>();
    tmp.addAll(player.hand);
    player.hand.clear();
    player.hand.addAll(player.hand);
    hand.clear();
    hand.addAll(tmp);

  }

  void draft() { // A tester

    Iterator<Player> it; //Expression ternaire !
    if(era%2 == 1)
      it = this.players.iterator();
    else
      it = this.players.descendingIterator();

    LinkedList<String> hand = this.players.getFirst().hand;
    while(it.hasNext()) {

      exchangeHands(it, hand);

    }

    players.getFirst().hand.clear();
    players.getFirst().hand.addAll(hand);
  }

  boolean endEra() { // A tester
    Player player = this.players.getFirst();
    if( player.hand.size() <= 1 ){
      return true;
    }
    else {
      return false;
    }
  }

}
