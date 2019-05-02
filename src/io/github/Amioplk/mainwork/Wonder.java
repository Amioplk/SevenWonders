package io.github.Amioplk.mainwork;

import java.util.ArrayList;

public class Wonder {
	
	int full; // On fait un max qu'on decremente;
	String name;
	ArrayList<Action> actions;
	int side;
	
	public Wonder() {}
	
	public Wonder(Frame frame, String name) {
		side = (Math.random() > 1/2) ? 0 : 1; // A ou B
		this.name = name;
		this.full = frame.nbFloorsByWonder.get(this.name + side);
	}
	
	public boolean fullWonder() {
		return full == 0;
	}
	
}
