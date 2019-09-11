package main.java.io.github.Amioplk.mainwork;

/**
 * @author Amioplk Represente l'action d'emprunter
 */
class BorrowAction extends Action { // Facilement remplacable par une methode dans Game ?

	int many;
	/**
	 * On suppose que la ressource n'est pas SHIELD car le shield ne sera pas
	 * présent dans les coûts des cartes
	 */
	Ressource what;
	Player who;

	public BorrowAction(Ressource r, int need, Player player) {
		this.what = r;
		this.many = need;
		this.who = player;
	}

	public void apply() {

		who.addMoney(many * user.getLeftPrice(what));
		user.addMoney(-many * user.getLeftPrice(what));
		// Log

	}
	
	public boolean equals(BorrowAction b) {
		return this.what == b.what && this.who == b.who;
	}
	
}