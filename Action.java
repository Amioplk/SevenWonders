import java.util.*;



abstract class Action {
  // On veut modeliser une action comme quelque chose qui peut etre lancé et qui a un effet sur les regles et sur l'etat du jeu et les joueurs
  // Une action est la pose d'une carte qui possede un effet, PAS le fait de payer les couts par exemple !

  Player user;
  String what; // Nom de la carte !
  // type, couleur

  // Defausser
  // Emprunter chez les autres ??? (Action ? ou Troc ?)
  // Mettre en dessous de la merveille

  public Action(){} //Action par défaut ? --> défausser | Player par défaut ?

  public Action(Player user, String card){
    this.user = user;
    this.what = card;
  }

}



class ThrownAction extends Action {

  int cost;

}



class InstantAction extends ThrownAction {

  int gain; // Peut être négatif, peut concerner les ressources

}



class PermAction extends ThrownAction {

  // Les cartes jaunes qui donnent un bonus permanent

}



class FinalAction extends ThrownAction {

  HashMap<String, Integer> choices; //?

}



class BorrowedAction extends Action { //extends action ?

  int many;
  Player who;

}
