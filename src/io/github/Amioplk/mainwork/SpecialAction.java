package io.github.Amioplk.mainwork;

public class SpecialAction extends Action implements Applyable {
	
	Card card;
	
	public SpecialAction(Game game, Player player, Card card) {
		
	}
	
	public boolean apply() { // identify
		switch(this.card.getName()) {
		
		}
		
		return true;
	}
	
}
