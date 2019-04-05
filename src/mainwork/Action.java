package mainwork;
public abstract class Action {
	  // On veut modeliser une action comme quelque chose qui peut etre lancé et qui a un effet sur les regles et sur l'etat du jeu et les joueurs
	  // Une action est la pose d'une carte qui possede un effet, PAS le fait de payer les couts par exemple !

	  Player user;
	  Card card;
	  // type, couleur

	  // Defausser
	  // Emprunter chez les autres ??? (Action ? ou Troc ?)
	  // Mettre en dessous de la merveille

	  public Action(){} //Action par defaut si temps trop long --> defausser | Player par defaut ?

	}