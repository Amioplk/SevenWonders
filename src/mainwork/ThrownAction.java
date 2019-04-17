package mainwork;

class ThrownAction extends InstantAction implements Applyable{
	
	Card card;
	
	public ThrownAction(Game game, Player player, Card card) {
		this.game = game;
		this.user = player;
		this.card = card;
	}
	
	@Override
	public boolean apply() {
		this.user.cards.remove(this.card);
		
		return true;
	}

}