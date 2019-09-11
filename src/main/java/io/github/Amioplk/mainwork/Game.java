package main.java.io.github.Amioplk.mainwork;

import java.util.*;

// Type de jeu ? Chacun son tour ? En reseau ?

/**
 * @author Amioplk Represente l'etat du jeu en general
 */
public class Game {

	// Ere
	int era;
	/**
	 * Defausse des cartes
	 */
	Collection<Card> defausse;
	/**
	 * Extentions
	 * (https://gusandco.net/2012/06/14/7-wonders-compile-de-toutes-nos-extensions/)
	 */
	List<String> ext;
	/**
	 * Placement des joueurs
	 */
	public ArrayList<Player> players;
	/**
	 * Référentiel du jeu -> Le même pour toute partie
	 */
	static Frame frame;

	/**
	 * The Borrow Actions that could be carried out at the time
	 */
	Map<Card, Set<Set<BorrowAction>>> borrowActionsToCome;
	
	static void swapHands(Player x, Player y) { // A tester

		ArrayList<Card> xCards = x.getHand();
		x.setHand(y.getHand());
		y.setHand(xCards);
	}

	/**
	 * @param it
	 * @param player Fonction reccursive qui echange les mains de deux joueurs
	 */
	static void swapHands(Iterator<Player> it, Player player) { // A tester

		if (!it.hasNext()) {
			return;
		}

		Player newPlayer = it.next();
		swapHands(player, newPlayer);

		swapHands(it, newPlayer);

	}

	/**
	 * Phase de draft
	 */
	void draft() { // A tester

		ArrayList<Player> properPlayers = new ArrayList<>();
		properPlayers.addAll(this.players);
		if (era % 2 == 1)
			Collections.reverse(properPlayers);
		Iterator<Player> it = properPlayers.iterator();

		while (it.hasNext()) {

			swapHands(it, properPlayers.get(0));

		}

	}

	/**
	 * Verifier que les joueurs ne sont pas vides
	 * 
	 * @throws IllegalAccessException
	 */
	boolean endEra() throws IllegalAccessException { // A tester

		if (players.size() == 0) {
			throw new IllegalStateException();
		}
		if (players.get(0).getHand() == null) {
			throw new IllegalStateException();
		}

		return (players.get(0).getHand().size() <= 1);

	}

	void beginEra() {

		this.allocateCards();
	}

	/**
	 * Les players doivent etre donnes dans l'ordre des aiguilles d'une montre
	 */
	void setGame() {

	}

	/**
	 * Distribuer les cartes
	 */
	void allocateCards() { // A tester
		// Verifier que les cartes sont bien distribuees equitablement

		Set<Card> eraCards = new HashSet<>();
		for(String name : frame.cards.get(this.era)) {
			eraCards.add(new Card(name));
		}
		
		int i = 1;
		for (Card card : eraCards) {
			players.get(i % players.size()).getHand().add(card);
			++i;
		}
	}

	void allocateWonders() {

	}

	/**
	 * L'utilisateur joue
	 * 
	 * @param user
	 * @throws FullWonderException
	 */
	void play(Player user) throws FullWonderException {

		Card card = choseCard(user);
		if(!user.checkPlayable(card)) {
			Set<Set<BorrowAction>> borrowActions = borrowActionsToCome.get(card);
			for(Set<BorrowAction> borrowSet : borrowActions) {
				if(borrowSet.isEmpty()) throw new IllegalStateException();
				else if(borrowSet.size() > 1) borrowSet.forEach(b -> b.apply());
				else choseBorrowAction();
			}
		}

		if (choseMode() == PlayMode.THROWN) {
			card.apply(user);
		} else if (choseMode() == PlayMode.WONDER) {

			if (user.wonder.fullWonder()) {
				// Log
				throw new FullWonderException();
			}

			user.wonder.getActions().get(user.wonder.index);
			++user.wonder.index;
		} else if (choseMode() == PlayMode.DISCARD)
			this.discardCard(card, user);

		user.cards.remove(card);

	}

	private void choseBorrowAction() {
		// TODO Auto-generated method stub
		
	}

	private PlayMode choseMode() {
		return null;
	}

	/**
	 * Must be private after testing
	 * 
	 * @param player
	 * @param right  true if we want the right Neighbour, false otherwise
	 * @return Neighbour
	 */
	public Player getNeighbour(Player player, boolean right) {

		int index = this.players.indexOf(player); // Uses Player.equals()

		int i = right ? 0 : this.players.size() - 1;
		int realIndex = right ? index + 1 : index - 1;

		if (realIndex >= this.players.size() || realIndex < 0) {
			return this.players.get(i);
		} else {
			return this.players.get(realIndex);
		}
	}

	private void discardCard(Card card, Player user) {
		this.defausse.add(card);
		user.setMoney(user.getMoney() + 3);
	}

	private Card choseCard(Player player) {
		return new Card("Discard");
	}

}
