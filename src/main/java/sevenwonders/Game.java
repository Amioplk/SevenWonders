package sevenwonders;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Game {
    // On met ici l'etat du jeu en general

    // Ere
    private int era;
    // Defausse (Collection)
    private Collection<Card> defausse;
    // Extentions
    private List<String> ext;
    // Placement des joueurs
    private LinkedList<Player> players;
    // Référentiel
    private Frame frame;

    private static void swapHands(Player x, Player y) {
        List<Card> xCards = x.getHand();
        x.setHand(y.getHand());
        y.setHand(xCards);
    }

    private static void swapHands(LinkedList<Player> players, boolean ascendingOrder) {
        if (ascendingOrder) {
            List<Card> initialHand = players.getFirst().getHand();
            for (int i = 0; i < players.size() - 1; i++) {
                swapHands(players.get(i), players.get(i + 1));
            }
            players.getLast().setHand(initialHand);
        } else {
            List<Card> initialHand = players.getLast().getHand();
            for (int i = players.size(); i > 0; i--) {
                swapHands(players.get(i), players.get(i - 1));
            }
            players.getFirst().setHand(initialHand);
        }
    }

    void draft() {
        swapHands(players, (era & 1) == 0);
    }

    boolean endEra() { // A tester
        return (players.getFirst().getHand().size() <= 1);
    }

    void beginEra() {
        this.allocateCards();
    }

    void setGame() {
    }

    void allocateCards() {
        // Distribuer les cartes
    }

    int countPoints(Player player) {
        return 0;
    }
}
