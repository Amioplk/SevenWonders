package main.java.io.github.Amioplk.mainwork;
import java.util.List;
import java.util.Map;
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
	 * Chainages (Arbre binaire ?)
	 */
	Object chain;
	
	/**
	 * Types d'action par carte
	 * Ex : 1 piece instant + 1 pt a la fin : INSTANT et FINAL
	 */
	Map<String, Set<ActionType>> actionTypes;
	
	/**
	 * Actions par merveille
	 * !! keys are in format NAME + SIDE 
	 */
	Map<String, List<String>> wonderActions;
	
	/**
	 * Listes (par ere) des ensembles de cartes
	 */
	List<Set<String>> cards; // ?? -> Game ??
	
	/**
	 * Liste des couts des cartes
	 */
	Map<String, Map<Ressource, Integer>> cost;
	
	/**
	 * Seuil de joueurs minimum
	 */
	Map<String, Integer> nbPlayerPerCard;
	
	/**
	 * Le type de carte de chaque carte
	 */
	Map<String, CardType> cardTypes;

}
