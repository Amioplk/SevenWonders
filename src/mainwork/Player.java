package mainwork;
import java.util.*;
import java.util.stream.Stream;



class Player {
  //La classe Player doit lancer des Actions !!

  String name;
  // Les cartes deja  posees
  Set<Card> cards;
  // Merveille dont le joueur dispose
  Wonder wonder;
  // Les cartes en main
  private ArrayList<Card> hand;
  // Argent
  int money;

  public Player(String name){
    this.name = name;
  }


  public Player() {
	this("Anonymous");
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


  public ArrayList<Card> getHand() {
	return hand;
  }


  public void setHand(ArrayList<Card> hand) {
	this.hand = hand;
  }
  
  @SuppressWarnings("unused")
  public int getRessources(Ressource r) {
	Stream<Card> reStream = this.cards.stream().filter(c -> (c.getType() == CardType.RAW || c.getType() == CardType.MANUF));
	  
	  
	  return 0;
  }

 }