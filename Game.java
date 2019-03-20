import java.util.*;

// Type de jeu ? Chacun son tour ? En réseau ?



class Game {
  //On met ici l'etat du jeu en general

  // Ere
  int era;
  // Defausse (Collection)
  Collection<Action> defausse;
  // Extentions
  List<String> ext;
  // Placement des joueurs
  LinkedList<Player> players; // Attention !  HashMap ne garantit pas d'ordre alors que TreeMap oui

  void draft() { // A tester

    Iterator<Player> it; //Expression ternaire !
    if(era == 1 || era == 3)
      it = this.players.iterator();
    else
      it = this.players.descendingIterator();

    LinkedList<String> hand = this.players.getFirst().hand;
    while(it.hasNext()){

      player = it.next();
      LinkedList<String> tmp = player.hand.clone();
      player.hand = hand.clone();
      hand = tmp.clone();

    }

    players.getFirst().hand = hand.clone();
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
