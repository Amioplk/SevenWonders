package mainwork;

class WonderAction extends InstantAction {
	
	// Mettre la carte sur un etage de merveille
	
	/**
	 * Incomplet
	 */
	public boolean apply(Game game) { // A tester
		
		if(!this.user.checkRessources()) return false;
		
		--user.wonder.full; //wonderfull lol
	
		return true;
	}
	
}