package main.java.io.github.Amioplk.mainwork;

import java.util.Map;

public class Cost {

	Map<Ressource, Integer> dist;
	
	public Cost(Map<Ressource, Integer> dist) {
		this.dist.putAll(dist);
	}
	
	int getNeeds(Ressource r) {
		return dist.get(r);
	}
	
	boolean isEmpty() {
		return dist.isEmpty();
	}

}
