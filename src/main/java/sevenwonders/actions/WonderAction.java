package sevenwonders.actions;

import sevenwonders.Wonder;

public class WonderAction extends InstantAction {

    // Mettre la carte sur un etage de merveille
    /**
     * Incomplet
     */
    @Override
    public boolean apply() { // A tester
        Wonder wonder = user.getWonder();
        if (!this.user.checkRessources())
            return false;
        // Il manque une étape je pense
        --wonder.full; // wonderfull lol
        return true;
    }
}
