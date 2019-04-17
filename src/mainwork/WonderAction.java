package mainwork;

class WonderAction extends InstantAction implements Applyable {
	
	// Mettre la carte sur un etage de merveille
	
	@Override
	/**
	 * Incomplet
	 */
	public boolean apply() { // A tester
		
		// Etape d'apply
		--user.wonder.full; // wonderful lol
	
		return true;
	}

}