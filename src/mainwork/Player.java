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
  private ArrayList<Card> hand;
  // Argent
  private int money;

  public Player(String name){
    this.name = name;
    this.money = 3;
  }


  public Player() {
	this("Anonymous");
  }
  
  @SuppressWarnings("unused")
  private boolean checkNeighbours(){return false;}
 
  boolean checkRessources(Game game, Cost cost) {
	  
	  for(Ressource r: cost.dist.keySet()) {
		  if(this.getTotalRessources(game, r) < cost.dist.get(r)) {
			  return false;
		  }
	  }
	  
	  return true;
  }
  
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
  
  public int getTotalRessources(Game game, Ressource r) {
	Card [] matchedCards = (Card[]) this.cards.stream().filter(c -> (c.getType() == CardType.RAW || c.getType() == CardType.MANUF || c.getType() == CardType.WAR))
											   .filter(c -> (Frame.toRessource(game.frame.effect.get(c).get(1)).equals(r))) //equals fonctionne ?
											   .toArray();	
	
	return getRessources(game, matchedCards);
  }
  
  private static int getRessources(Game game, Card[] cards) {
	  int sum = 0;
	  
	  for(Card c: cards) {
		  sum += Integer.parseInt(game.frame.effect.get(c).get(0));
	  }
	  
	  return sum;
  }
  
  public int getForce(Game game) {
	  
	  return getTotalRessources(game, Ressource.SHIELD);
  }

  public int getMoney() {
	return money;
}

  public void setMoney(int money) {
	this.money = money;
}

}