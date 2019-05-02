package io.github.Amioplk.mainwork;

class WonderAction extends Action implements Applyable {
	
	// Mettre la carte sur un etage de merveille
	
	public WonderAction(Game game, Player player) {
		this.game = game;
		this.user = player;
	}
	
	public boolean apply() { // A tester
		
		// Etape d'apply
		--user.wonder.full; // wonderful lol
	
		return true;
	}

}