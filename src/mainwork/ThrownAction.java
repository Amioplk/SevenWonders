package mainwork;

class ThrownAction extends Action implements Applyable{
	
	Card card;
	
	public ThrownAction(Game game, Player player, Card card) {
		this.game = game;
		this.user = player;
		this.card = card;
	}
	
	@Override
	public boolean apply() {
		
		return false;
	}

}