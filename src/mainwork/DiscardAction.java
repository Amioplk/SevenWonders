package mainwork;
class DiscardAction extends InstantAction { 	// Action de d�fausse
	
	@Override
	public boolean apply() {
		
		game.defausse.add(this.card);
		this.user.setMoney(this.user.getMoney() + 3) ;
		
		return true;
	}
}