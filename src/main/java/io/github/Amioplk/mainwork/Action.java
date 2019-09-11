package main.java.io.github.Amioplk.mainwork;

// SEE om.sun.deploy.association.Action
public abstract class Action {

		// On veut modeliser une action comme quelque chose qui peut etre lance et qui a un effet sur les regles et sur l'etat du jeu et les joueurs

		static Game game;
		Player user;

		static void setGame(Game game){
			Action.game = game;
		}
		
		public Player getWho() {
			return user;
		}

		public void setWho(Player who) {
			this.user = who;
		}

}
