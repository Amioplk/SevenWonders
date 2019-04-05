package mainwork;
class DiscardAction extends InstantAction { 	// Action de défausse
	
	public boolean apply(Game game) {
		
		game.defausse.add(this.card);
		user.money += 3;
		
		return true;
	}
}