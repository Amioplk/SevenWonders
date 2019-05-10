package main.java.io.github.Amioplk.mainwork;
import java.util.*;
import java.util.stream.Collectors;

public class Player {
  //La classe Player doit lancer des Actions !!

  public String name;
  // Les cartes deja posees
  public Set<Card> cards; // Probleme de doublons ??
  // Merveille dont le joueur dispose
  Wonder wonder;
  // Les cartes en main
  private ArrayList<Card> hand;
  // Argent
  private int money;
  // Tarifs pour le voisin de gauche
  int priceLeft;
  // Tarifs pour le voisin de droite
  int priceRight;
  
  public Player(String name){
    this.name = name;
    this.money = 3;
    this.cards = new HashSet<>();
    this.wonder = new Wonder();
    this.hand = new ArrayList<>();
  }


  public Player() {
	this("Anonymous");
  }
 
  boolean checkRessources(Cost cost) {
	  
	  for(Ressource r: cost.dist.keySet()) {
		  if(this.getTotalRessources(r) < cost.dist.get(r)) {
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
  
  public int getTotalRessources(Ressource r) {
	  Set<Card> matchedCards = new HashSet<Card>();
	  matchedCards.addAll(this.cards.stream().filter(c -> (c.getType() == CardType.RAW || c.getType() == CardType.MANUF || c.getType() == CardType.WAR))
			  								 .filter(c -> ((PermAction) c.getAction()).ressource == r)
			  								 .collect(Collectors.toSet()));
	  
	  return getRessources(matchedCards);
  }
  
  public static int getRessources(Set<Card> cards) {
	  int sum = 0;
	  
	  for(Card card: cards) {
		  sum += ((PermAction)card.getAction()).many;
	  }
	  
	  return sum;
  }
  
  public int getForce() {
	  
	  return getTotalRessources(Ressource.SHIELD);
  }
  
  public int countPoints() {
	  return 0;
  }

  public int getMoney() {
	return money;
  }

  public void setMoney(int money) {
	this.money = money;
  }

  public void addMoney(int money) {
	this.setMoney(this.getMoney() + money);
  }
  
}