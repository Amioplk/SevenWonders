package io.github.Amioplk.mainwork;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Frame { // Set à l'aide de fichiers !
	
	Set<String> wondersAvailable; // Merveilles disponibles
	
	Object chain; // Chainages (Quel type ?!)
	
	HashMap<Card, String> typeOfAction; // Type d'action par carte (plusieurs types ? 
	// Ex 1piece instant + 1pt à la fin)
	
	HashMap<String, String> typeOfWonderAction; // Type d'action par étage de merveille
	
	/**
	 * String must be name + side (0: A ; 1:B)
	 */
	HashMap<String, Integer> nbFloorsByWonder;
	
	ArrayList<Set<Card>> cards; // Créer des cartes à partir des noms...
	
	HashMap<Card, ArrayList<String>> effect; // Liste des effets des cartes : formaté comment ? (Pour l'instant 0: nbr et 1: Ressource)
	
	HashMap<Card, Cost> cost; // Liste des couts des cartes -> seulement de l'initialisation
	
	HashMap<Card, Integer> nbPlayerPerCard; // Seuil de joueurs minimum
	
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
