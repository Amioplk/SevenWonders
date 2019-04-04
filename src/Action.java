import java.util.*;



abstract class Action {
  // On veut modeliser une action comme quelque chose qui peut etre lancé et qui a un effet sur les regles et sur l'etat du jeu et les joueurs
  // Une action est la pose d'une carte qui possede un effet, PAS le fait de payer les couts par exemple !

  Player user;
  // type, couleur

  // Defausser
  // Emprunter chez les autres ??? (Action ? ou Troc ?)
  // Mettre en dessous de la merveille

  public Action(){} //Action par défaut ? --> défausser | Player par défaut ?

  public Action(Player user){
    this.user = user;
  }

}



class ThrownAction extends Action {

  int cost;

}



class InstantAction extends ThrownAction {

  int gain; // Peut etre negatif

}



class PermAction extends ThrownAction {

  // Les cartes jaunes qui donnent un bonus permanent

}



class FinalAction extends ThrownAction {

  HashMap<String, Integer> choices; //Choix final de science par exemple

}



class BorrowedAction extends Action { //extends action ?

  int many;
  Player who;

}



class WonderAction extends ThrownAction {
	
	// Mettre la carte sur un etage de merveille
	
	/**
	 * Incomplet
	 */
	public void apply() {
		Wonder wonder = user.wonder;
		//checkRessources
		wonder.full--;
	}
	
}



class Discard extends ThrownAction {
	
	// Action de d�fausse
	
	public void apply() {
		
	}
}