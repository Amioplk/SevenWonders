package main.java.io.github.Amioplk.mainwork;

import java.util.Set;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;

public class Card {
	
	private String name;
	private CardType type;
	private Action action;
	private Set<ActionType> types;
	Cost cost;
	
	// Ajouter l'ere ?
	
	public Card(String name, CardType type) {
		this(name, type, null, null);
	}
	
	public Card(String name, CardType type, Action action, Set<ActionType> types) {
		this.setName(name);
		this.setType(type);
		this.setAction(action);
		this.setTypes(types);
	}
	
	/**
	 * @return true si les verifications pour les chainages sont ok
	 */
	boolean doesChain() {
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

	public Set<ActionType> getTypes() {
		return types;
	}

	public void setTypes(Set<ActionType> types) {
		this.types = types;
	}
	
}
