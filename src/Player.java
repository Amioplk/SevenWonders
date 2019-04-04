import java.util.*;



class Player {
  //La classe Player doit lancer des Actions !!

  String name;
  // Les cartes de ressources(+military) + les cartes déjà posées
  Set<Card> cards;
  // Etat des merveilles
  int full; // On fait un max qu'on décrémente
  // Nom de la merveilles
  String wonder;
  // Les cartes en main (ne pas faire de LinkedList !)
  LinkedList<String> hand; // Les cartes sont des Strings et on crée des actions dans les règles

  public Player(String name){
    this.name = name;
  }

  boolean fullWonder() {
    if(this.full == 0){
      return true;
    }
    else{
      return false;
    }
  }

  Action use(){return new ThrownAction();} //return Action ?
  
  @SuppressWarnings("unused")
private boolean checkNeighbours(){return true;};
  
  // Pas deux cartes de même nom
  boolean checkSameCard(Card newCard) {
	  for(Card card : cards) {
		  if(card.equals(newCard)) return true;
	  }
	  
	  return false;
  } // Dans Player ?

  }
