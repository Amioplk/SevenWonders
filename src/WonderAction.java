class WonderAction extends InstantAction {
	
	// Mettre la carte sur un etage de merveille
	
	/**
	 * Incomplet
	 */
	public void apply() {
		Wonder wonder = user.wonder;
		//checkRessources
		wonder.full--; //wonderfull lol
	}
	
}