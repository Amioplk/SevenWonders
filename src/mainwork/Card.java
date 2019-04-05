package mainwork;

public class Card {
	
	private String name;
	private TypeOfCards type;
	int nbPlayersMinimum; // Pas sur de figurer ici
	
	public Card(String name, TypeOfCards type) {
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

	public TypeOfCards getType() {
		return type;
	}

	public void setType(TypeOfCards type) {
		this.type = type;
	};
	
	public boolean equals(Card newCard) {
		return (this.name == newCard.name);
	}
	
	@Override
	public String toString() {
		return this.getName();
	}
	
}
