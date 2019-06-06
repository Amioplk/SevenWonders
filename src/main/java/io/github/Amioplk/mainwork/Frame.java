package main.java.io.github.Amioplk.mainwork;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * @author Amioplk
 * Set a l'aide de fichiers XML (ou de schémas) !
 */
public class Frame {
	
	/**
	 * Merveilles disponibles
	 */
	Set<String> wondersAvailable;
	
	/**
	 * Chainages (Quel type ?!)
	 */
	Object chain;
	
	/**
	 * Types d'action par carte
	 */
	HashMap<Card, ActionType> actionTypes; // Ex 1piece instant + 1pt a la fin)
	
	/**
	 * Actions par merveille
	 * !! keys are in format NAME + SIDE 
	 */
	HashMap<String, Set<String>> wonderActions;
	
	/**
	 * Listes (par ere) des ensembles de cartes
	 */
	ArrayList<Set<Card>> cards; // Creer des cartes a partir des noms...
	
	/**
	 * Liste des couts des cartes
	 */
	HashMap<Card, Cost> cost;
	
	/**
	 * // Seuil de joueurs minimum
	 */
	HashMap<Card, Integer> nbPlayerPerCard; // Voir si Card -> String
	
	/**
	 * @param r
	 * @return le type de ressource que le String represente
	 */
	public static Ressource toRessource(String r) {
		
		if(r.equals("CLAY")) return Ressource.CLAY;
		else if(r.equals("FABRIC")) return Ressource.FABRIC;
		else if(r.equals("GLASS")) return Ressource.GLASS;
		else if(r.equals("ORE")) return Ressource.ORE;
		else if(r.equals("PAPYRUS")) return Ressource.PAPYRUS;
		else if(r.equals("STONE")) return Ressource.STONE;
		else if(r.equals("WOOD")) return Ressource.WOOD;
		else if(r.equals("SHIELD")) return Ressource.SHIELD;
		else return Ressource.MONEY; 
			
	}
	
}
