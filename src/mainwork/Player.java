package mainwork;
import java.util.*;



class Player {
  //La classe Player doit lancer des Actions !!

  String name;
  // Les cartes deja  posees
  Set<Card> cards;
  // Merveille dont le joueur dispose
  Wonder wonder;
  // Les cartes en main
  ArrayList<Card> hand;
  // Les actions permanentes dont le joueur dispose

  public Player(String name){
    this.name = name;
  }


  Action use(){return new ThrownAction();}
  
  @SuppressWarnings("unused")
private boolean checkNeighbours(){return false;}
 
  boolean checkRessources() {return false;}
  
  // Pas deux cartes de meme nom
  boolean checkSameCard(Card newCard) {
	  for(Card card : cards) {
		  if(card.equals(newCard)) return true;
	  }
	  
	  return false;
  }

  }
