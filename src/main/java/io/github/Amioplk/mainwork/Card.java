package main.java.io.github.Amioplk.mainwork;

import java.util.Set;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;

public class Card {
	
	private String name;
	private CardType type;
	private Set<ActionType> types;
	Cost cost;
	
	public Card() {
		this("Default");
	}
	
	public Card(String name) {
		this.setName(name);
		this.type = Game.frame.cardTypes.get(name);
		this.types = Game.frame.actionTypes.get(name);
	}
	
	public Card(String name, CardType type, Set<ActionType> types) {
		this.setName(name);
		this.setType(type);
		this.setTypes(types);
	}
	
	void apply(Player user) {
		
		if(this.types.contains(ActionType.INSTANT)){
			InstantAction instantAction = new InstantAction(user, this);
			instantAction.apply();
		}
	}
	
	boolean containsActionType(ActionType at) {
		return types.contains(at);
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

	public Set<ActionType> getTypes() {
		return types;
	}

	public void setTypes(Set<ActionType> types) {
		this.types = types;
	}
	
}
