package main.java.io.github.Amioplk.mainwork;

public class InstantAction extends Action {
	
	Card card;
		
	public InstantAction(Player player, Card card) {
		this.user = player;
		this.card = card;
	}

	public boolean apply() {
		
		if(card.getName().equals("Tavern")) tavern();
		
		return false;
	}

	private void tavern() {
		user.addMoney(6);
	}
		
}
