package mainwork;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Frame { // Set à l'aide de fichiers !
	
	Set<String> wondersAvailable; // Merveilles disponibles
	
	Object chain; // Chainages (Quel type ?!)
	
	HashMap<Card, String> typeOfAction; // Type d'action par carte (plusieurs types ? 
	// Ex 1piece instant + 1pt à la fin)
	
	/**
	 * String must be name + side (0: A ; 1:B)
	 */
	HashMap<String, Integer> nbFloorsByWonder;
	
	ArrayList<Set<Card>> cards; // Créer des cartes à partir des noms...
	
	HashMap<Card, ArrayList<String>> effect; // Liste des effets des cartes : formaté comment ? (Pour l'instant 0: nbr et 1: Ressource)
	
	HashMap<Card, Cost> cost; // Liste des couts des cartes -> seulement de l'initialisation
	
	HashMap<Card, Integer> nbPlayerPerCard; // Seuil de joueurs minimum
	
	public static Ressource toRessource(String r) {
		
		switch(r) {
			case("CLAY"): return Ressource.CLAY;
			case("FABRIC"): return Ressource.FABRIC;
			case("GLASS"): return Ressource.GLASS;
			case("ORE"): return Ressource.ORE;
			case("PAPYRUS"): return Ressource.PAPYRUS;
			case("STONE"): return Ressource.STONE;
			case("WOOD"): return Ressource.WOOD;
			case("SHIELD"): return Ressource.SHIELD;
			case("POINTS"): return Ressource.POINTS;
			default: return Ressource.UNDEFINED;
		}
	}
	
}
