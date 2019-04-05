package mainwork;

class WonderAction extends InstantAction {
	
	// Mettre la carte sur un etage de merveille
	
	@Override
	/**
	 * Incomplet
	 */
	public boolean apply() { // A tester
		
		if(!this.user.checkRessources(this.game, this.card.cost)) {return false;}
		// Etape d'apply
		--user.wonder.full; // wonderful lol
	
		return true;
	}

}