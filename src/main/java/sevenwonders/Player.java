package sevenwonders;

import java.util.List;
import java.util.Set;

import sevenwonders.actions.Action;
import sevenwonders.actions.ThrownAction;

public class Player {
    // La classe Player doit lancer des Actions !!

    private String name;
    // Les cartes deja  posees
    private Set<Card> cards;
    // Merveille dont le joueur dispose
    private Wonder wonder;
    // Les cartes en main
    private List<Card> hand;
    // Les actions permanentes dont le joueur dispose

    public Player(String name) {
        this.setName(name);
    }

    Action use() {
        return new ThrownAction();
    }

    @SuppressWarnings("unused")
    private boolean checkNeighbours() {
        return false;
    }

    public boolean checkRessources() {
        return false;
    }

    // Pas deux cartes de meme nom
    boolean checkSameCard(Card newCard) {
        for (Card card : cards) {
            if (card.equals(newCard))
                return true;
        }
        return false;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public Wonder getWonder() {
        return wonder;
    }

    public void setWonder(Wonder wonder) {
        this.wonder = wonder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
