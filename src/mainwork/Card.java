package mainwork;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;

public class Card {
	
	private String name;
	private CardType type;
	private Action action;
	Cost cost;
	int nbPlayersMinimum;
	
	public Card(String name, CardType type) {
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

	public CardType getType() {
		return type;
	}

	public void setType(CardType type) {
		this.type = type;
	};
	
	public boolean equals(Card newCard) {
		return (this.toString().equals(newCard.toString()));
	}
	
	@Override
	public String toString() {
		ToStringHelper string = MoreObjects.toStringHelper(this);
		string.add(this.name, true);
		return string.toString();
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}
	
}
