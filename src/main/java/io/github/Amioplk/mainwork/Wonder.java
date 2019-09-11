package main.java.io.github.Amioplk.mainwork;

import java.util.List;

public class Wonder {
	
	
	int max;
	int index;
	String name;
	private List<String> actions;
	char side;
	private Card defaultAction;
	
	public Wonder() {}
	
	public Wonder(Frame frame, String name) {
		this.side = (Math.random() > 1/2) ? 'A' : 'B';
		this.name = name;
		this.actions = frame.wonderActions.get(name + side);
		this.max = actions.size();
		this.index = 0;
	}
	
	public boolean fullWonder() {
		return max == index;
	}

	public List<String> getActions() {
		return actions;
	}

	public void setActions(List<String> actions) {
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
	 * @return the index of the next action available on this Wonder
	 */
	public int getNextAvailable() {
		return index;
	}
	
}
