package mainwork;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Frame { // Set � l'aide de fichiers !
	
	Set<Wonder> wondersAvailable; // Merveilles disponibles
	Object chain; // Chainages (Quel type ?!)
	HashMap<Card, String> typeOfAction; // Type d'action par carte (plusieurs types ? 
	// Ex 1piece instant + 1pt � la fin) -> enum ?
	ArrayList<Set<Card>> cards; // Cr�er des cartes � partir des noms...
	
}
