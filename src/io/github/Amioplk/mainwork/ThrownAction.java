package io.github.Amioplk.mainwork;

class ThrownAction extends Action implements Applyable{
	
	Card card;
	
	public ThrownAction(Game game, Player player, Card card) {
		this.game = game;
		this.user = player;
		this.card = card;
	}

	public boolean apply() {
		switch(this.card.getName()) {
			case "March� Ouest" : ouestMarket();
			case "March� Est" : eastMarket();
		}
		return false;
	}

	private void ouestMarket() {
		this.user.priceLeft = 1;
	}
	
	private void eastMarket() {
		this.user.priceRight = 1;
	}

}