import java.util.*;



class Player {
  //La classe Player doit lancer des Actions !!

  String name;
  // Les cartes deja  posees
  Set<Card> cards;
  // Nom de la merveilles
  Wonder wonder;
  // Les cartes en main (ne pas faire de LinkedList !)
  ArrayList<Card> hand; // Les cartes sont des Strings

  public Player(String name){
    this.name = name;
  }


  Action use(){return new ThrownAction();}
  
  @SuppressWarnings("unused")
private boolean checkNeighbours(){return true;};
  
  // Pas deux cartes de mÃªme nom
  boolean checkSameCard(Card newCard) {
	  for(Card card : cards) {
		  if(card.equals(newCard)) return true;
	  }
	  
	  return false;
  }

  }
