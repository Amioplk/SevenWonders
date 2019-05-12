package main.java.io.github.Amioplk.mainwork;

class ThrownAction extends Action implements Applyable{
	
	Card card;
	
	public ThrownAction(Player player, Card card) {
		this.user = player;
		this.card = card;
	}

	public void apply() {
		if(this.card.getName().equals("Marche Ouest")) ouestMarket();
		if(this.card.getName().equals("Marche Est")) eastMarket();
	}

	private void ouestMarket() {
		this.user.priceLeft = 1;
	}
	
	private void eastMarket() {
		this.user.priceRight = 1;
	}

}