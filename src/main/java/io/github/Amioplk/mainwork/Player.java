package main.java.io.github.Amioplk.mainwork;

import java.math.BigInteger;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * @author Amioplk
 *
 */
/**
 * @author Amioplk
 *
 */
public class Player {

	/**
	 * Un nom de joueur unique dans cette partie
	 */
	public String name;
	/**
	 * Les cartes deja posees (dont les étapes de merveille)
	 */
	public Set<Card> cards;
	/**
	 * Les cartes de ressource déjà posées
	 */
	public Set<RessourceCard> ressourceCards;
	/**
	 * Merveille dont le joueur dispose
	 */
	Wonder wonder;
	/**
	 * Les cartes en main
	 */
	private ArrayList<Card> hand;
	/**
	 * Amount of money
	 */
	private int money;
	/**
	 * Number of points
	 */
	private int points;
	
	/**
	 * The game he's playing in
	 */
	public Game game;
	
	/**
	 * Penser à un fonctionnement plus propre pour cela -> Dans une autre classe
	 */
	private Map<Set<BorrowAction>, Integer> borrowActionPortfolio;
	
	/**
	 * Le montant minimmum d'argent que le joueur peut payer pour emprunter des ressources données 
	 * -> Dans une autre classe qui peut être utilisée pour le problème des prix des cartes
	 */
	int minBorrowingPrice;

	public Player(String name) {
		this.name = name;
		this.money = 3;
		this.cards = new HashSet<>();
		this.wonder = new Wonder();
		this.hand = new ArrayList<>();
	}

	public Player() {
		this("Anonymous");
	}

	/**
	 * @param newCard
	 * @return true if this card is already played by player
	 */
	boolean checkSameCard(Card newCard) {
		for (Card card : cards) {
			if (card.equals(newCard))
				return true;
		}

		return false;
	}
	
	boolean checkChain(Card newCard) {
		return false;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	public void play(Card card) {
		card.apply(this);
		cards.remove(card);
	}

	public boolean checkPlayable(Card card) {
		/**
		 * 0. S'assurer que les pièces ont été payées et deal avant d'utiliser cette méthode ou bien le faire au sein de cette méthode
		 * 1. Réévaluer les cartes qui ne servent à rien : méthode private void evaluate(Set<RessourceCard> cards)
		 * 		-> Virer les cartes qui ne servent strictement à rien OK
		 * 		-> Transformer les cartes en nouvelles cartes custom  OK
		 * 2. Payer les ressources avec les cartes "sans choix" : méthode private void pay(Set<RessourceCard> cards, Cost cost)
		 * 		-> Virer les cartes utilisées OK
		 * 		-> Virer les ressources payées du cout OK
		 * 3. Recommencer l'étape 1 OK
		 * 4. Essayer de déterminer une réponse : méthode private boolean oneType(Cost cost) + méthode pay
		 * 		-> Si un seul type : facile OK
		 * 		-> Si plusieurs types mais nombre de cartes trop petit : facile
		 * 5. Dans le cas où aucune réponse n'a pu être formulée avec certitude, 
		 * 	mettre en place une interface où le joueur doit choisir : méthode private boolean choiceUI(Set<RessourceCard> cards, Cost cost)
		 * 		-> Proposer un lien pour revenir au  moment où on choisit la carte
		 * 6. Vérifier qu'il était possible de 
		 */
		
		if(checkSameCard(card)) {
			// Log
			return false;
		}
		
		Cost currentCost = card.cost;
		if(checkChain(card)) currentCost.dist.clear();
		Set<RessourceCard> currentRessourceCards = ressourceCards.stream().collect(Collectors.toSet());
		
		if(currentCost.isEmpty()) return true;
		
		evaluate(currentRessourceCards, currentCost);
		if(currentCost.isEmpty()) return true;
		
		pay(currentRessourceCards, currentCost);
		if(currentCost.isEmpty()) return true;
		
		evaluate(currentRessourceCards, currentCost);
		if(currentCost.isEmpty()) return true;
		
		if(oneType(currentCost)) pay(currentRessourceCards, currentCost);
		if(currentCost.isEmpty()) return true;
		
		if(currentRessourceCards.size() < currentCost.dist.size()) return false;

		// Choix des ressources à garder
		
		return false;
	}
	
	/**
	 * @param cards les cartes 
	 * @param cost
	 */
	private void evaluate(Set<RessourceCard> cards, Cost cost) { // A tester
		
		Set<Ressource> uselessRessources = Ressource.getLackingRessources(cost.dist.keySet());
		
		for(RessourceCard card : cards) {
			for(Ressource ressource : uselessRessources) {
				if(card.containsRessource(ressource)) {
					cards.remove(card);
					Map<Ressource, Integer> oldComposition = card.getFullComposition();
					oldComposition.remove(ressource);
					
					if(!oldComposition.isEmpty())
						cards.add(new RessourceCard(oldComposition));
				}
			}
		}
	}
	
	/**
	 * @param cards
	 * @param cost
	 */
	private void pay(Set<RessourceCard> cards, Cost cost) {
		
		for(RessourceCard card : cards) {
			if(!card.offersChoice()) {
				cards.remove(card);
				for(Ressource r: card.getFullComposition().keySet()) {
					cost.dist.compute(r, (Ressource re , Integer v) -> 
										{return cost.dist.get(re) - card.getFullComposition().get(r);}
										);
					
					if(cost.dist.get(r) <= 0) cost.dist.remove(r);
				}
			}
		}
		
	}

	/**
	 * Pour chaque ressource, vérifier que le joueur peut emprunter
	 * Il est important de regarder cela avant que le joueur reçoive de l'argent des adversaires !
	 * Cela risque de fausser le calcul.
	 * @param cost
	 * @return
	 */
	public boolean canBorrow(Card card) {
		
		Player leftNeighbour = game.getNeighbour(this, false);
		Player rightNeighbour = game.getNeighbour(this, true);
		
		BigInteger currentMoney = BigInteger.valueOf(money);
		for(Entry<Ressource, Integer> costEntry : card.cost.dist.entrySet()) {
			
			if(!canBorrow(costEntry.getKey(), costEntry.getValue(), leftNeighbour, rightNeighbour, currentMoney)) {
				return false;
			}
			
		}
		
		purgeBorrowActions();
		game.borrowActionsToCome.put(card, borrowActionPortfolio.keySet());
		return true;
	}
	
	/**
	 * Permet de se débarasser des actions d'emprunt qui ne sont plus intéressantes désormais
	 */
	private void purgeBorrowActions() {
		for(Entry<Set<BorrowAction>, Integer> entry : borrowActionPortfolio.entrySet()) {
			if(entry.getValue() > minBorrowingPrice) borrowActionPortfolio.remove(entry.getKey());
		}
	}

	/**
	 * @return true si le joueur peut emprunter amount de r à ses voisins
	 */
	private boolean canBorrow(Ressource r, int amount, Player leftNeighbour, Player rightNeighbour, BigInteger currentMoney) {
		
		int toBorrowLeft = amount;
		int toBorrowRight = 0;
		while(toBorrowRight <= amount) {
			
			if(canBorrow(r, toBorrowLeft, leftNeighbour) && canBorrow(r, toBorrowRight, rightNeighbour)) {
				
				boolean interessant;
				int leftFlow = toBorrowLeft * getLeftPrice(r);
				int rightFlow = toBorrowRight * getRightPrice(r);
				interessant = (minBorrowingPrice < leftFlow + rightFlow) ? false : true;
				
				if(interessant) {
					minBorrowingPrice = leftFlow + rightFlow;
					Set<BorrowAction> baSet = new HashSet<>();
					baSet.add(new BorrowAction(r, toBorrowLeft, leftNeighbour));
					baSet.add(new BorrowAction(r, toBorrowRight, rightNeighbour));
					borrowActionPortfolio.put(baSet, minBorrowingPrice);
				}
			}
			
			toBorrowRight++;
			toBorrowLeft--;
		}
		
		currentMoney.subtract(BigInteger.valueOf(minBorrowingPrice));
		return !borrowActionPortfolio.isEmpty();
	}
	
	/**
	 * @param amount doit être non-négatif
	 * @return true si le joueur peut emprunter le montant amount de r à player
	 */
	private boolean canBorrow(Ressource r, int amount, Player player) {
		
		if(amount == 0) return true;
		else if(amount <= 1) throw new IllegalArgumentException();
		
		int offer = player.getTotalAmount(r);
		if(offer > amount) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	/*private void appendPortfolio(BorrowAction b){
		
			borrowActionPortfolio.stream().forEach(c -> {
				if(c.equals(b)) c.many = b.many;
				return;
			});
			
			borrowActionPortfolio.add(b);
	}*/
	
	/**
	 * @param cost
	 * @return true si le coût ne contient qu'un seul type de ressource. Attention, les pièces sont comptées là-dedans
	 */
	private boolean oneType(Cost cost) {
		return cost.dist.size() == 1;
	}
	
	@SuppressWarnings("unused")
	private boolean choiceUI(Set<Card> cards, Cost cost) {
		return false;
	}
	
	public int getTotalAmount(Ressource r) { // J'ai essayé avec reduce mais c'est compliqué...
		
		BigInteger sum = new BigInteger("0");
		ressourceCards.forEach(c -> sum.add(BigInteger.valueOf(c.getAmount(r))));
		
		return sum.intValue();
		
	}
	
	public int getForce() {

		return getTotalAmount(Ressource.SHIELD);
	}
	
	/**
	 * @param type The type of cards we need to filter on
	 * @return the cards that meet this type
	 */
	public Set<Card> getCards(CardType type) {
		return cards.stream().filter(c -> c.getType() == type).collect(Collectors.toSet());
	}

	public int countPoints() {
		return points;
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

	public int getLeftPrice(Ressource R) {
		return 2;
	}

	public int getRightPrice(Ressource R) {
		return 2;
	}
	
	public boolean equals(Player player) {
		return this.name.equals(player.name);
	}
}