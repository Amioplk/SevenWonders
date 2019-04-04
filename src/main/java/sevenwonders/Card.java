package sevenwonders;

public class Card {

    private String name;
    private String type;

    public Card(String name, String type) {
        this.setName(name);
        this.setType(type);
    }

    // Les verifications pour les chainages
    boolean doesChain() { // Faire une structure speciale
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    };

    public boolean equals(Card newCard) {
        return (this.name == newCard.name);
    }
}
