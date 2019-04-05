package mainwork;

public class Wonder {
	
	int full; // On fait un max qu'on decremente;
	String name;
	int side;
	
	public Wonder(Frame frame, String name) {
		side = (Math.random() > 1/2) ? 0 : 1;
		this.name = name;
		this.full = frame.nbFloorsByWonder.get(this.name + side);
	}
	
	public boolean fullWonder() {
		return full == 0;
	}
	
}
