package mainwork;
class DiscardAction extends InstantAction { 	// Action de d�fausse
	
	public boolean apply(Game game) {
		
		game.defausse.add(this.card);
		user.money += 3;
		
		return true;
	}
}