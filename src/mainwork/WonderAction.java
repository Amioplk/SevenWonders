package mainwork;

class WonderAction extends Action implements Applyable {
	
	// Mettre la carte sur un etage de merveille
	
	class WonderThrownAction extends WonderAction { // D�finie comme une classe interne � WonderAction

		public WonderThrownAction() {}
		
		@Override
		public boolean apply() {
			return false;
		}

	}
	
	@Override
	/**
	 * Incomplet
	 */
	public boolean apply() { // A tester
		
		// Etape d'apply
		--user.wonder.full; // wonderful lol
	
		return false;
	}

}