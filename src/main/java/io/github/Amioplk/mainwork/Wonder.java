package main.java.io.github.Amioplk.mainwork;

import java.util.List;

public class Wonder {
	
	
	int full; // On fait un max qu'on decremente;
	String name;
	private List<Card> actions;
	char side;
	
	public Wonder() {}
	
	public Wonder(Frame frame, String name) {
		this.side = (Math.random() > 1/2) ? 'A' : 'B'; // A ou B
		this.name = name;
		this.full = this.getSize(frame);
	}
	
	public boolean fullWonder() {
		return full == 0;
	}

	public List<Card> getActions() {
		return actions;
	}

	public void setActions(List<Card> actions) {
		this.actions = actions;
	}

	/**
	 * @param frame
	 * @return Size of the wonder
	 */
	public int getSize(Frame frame) {
		return frame.wonderActions.get(name + side).size();
	}
	
	/**
	 * @param frame
	 * @return the index of the next action available on this Wonder
	 */
	public int getNextAvailable(Frame frame) {
		return this.getSize(frame) - this.full;
	}
	
}
