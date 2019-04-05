package mainwork;

class ThrownAction extends InstantAction {
	
	int moneyEarning;
	
	public ThrownAction(Game game, Player player, Card card, int earning) {
		this.game = game;
		this.user = player;
		this.card = card;
		this.moneyEarning = earning;
	}
	
	@Override
	public boolean apply() {
		this.user.cards.add(this.card);
		this.user.setMoney(this.user.getMoney() + this.moneyEarning);
		return true;
	}

}