package test.java.io.github.Amioplk;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import main.java.io.github.Amioplk.mainwork.*;

public class TestingFeatures {
	
	@Test
	void correctNumberOfRessources() { //Incorrect -> Ajouter dans le frame
		//Game.setFrame(new Frame());
		//Game.frame.composition = 

		Set<ActionType> types = new HashSet<ActionType>();
		types.add(ActionType.PERM);
		
		Player player = new Player();
		Card card = new Card("permanente", CardType.RAW, types);
		player.cards.add(card);
		
		Assertions.assertTrue(player.getTotalRessources(Ressource.WOOD)==2);
	}
	
	@Test
	void correctLeftNeighbour() {
		Game g = new Game(); // A changer des que l'on peut set up une partie
		g.players = new ArrayList<Player>();
		g.players.add(new Player());
		g.players.add(new Player("Amir"));
		Assertions.assertTrue(g.getNeighbour(g.players.get(1), false).name.equals("Anonymous"));
	}
	
	@Test
	void correctRightNeighbour() {
		Game g = new Game(); // A changer des que l'on peut set up une partie
		g.players = new ArrayList<Player>();
		g.players.add(new Player());
		g.players.add(new Player("Amir"));
		Assertions.assertTrue(g.getNeighbour(g.players.get(1), true).name.equals("Anonymous"));
	}
	
}
