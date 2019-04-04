package mainwork;

class WonderAction extends InstantAction {
	
	// Mettre la carte sur un etage de merveille
	
	/**
	 * Incomplet
	 */
	public boolean apply() { // A tester
		Wonder wonder = user.wonder;
		if(!this.user.checkRessources()) return false;
		// Il manque une étape je pense
		--wonder.full; //wonderfull lol
	
		return true;
	}
	
}