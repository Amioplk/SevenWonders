package io.github.Amioplk.mainwork;

public abstract class Action {

		// On veut modeliser une action comme quelque chose qui peut etre lance et qui a un effet sur les regles et sur l'etat du jeu et les joueurs
		// Une action est la pose d'une carte qui possede un effet, PAS le fait de payer les couts par exemple !

		Game game;
		Player user;

		public Action(){} //Action par defaut si temps trop long --> defausser | Player par defaut ?

}
