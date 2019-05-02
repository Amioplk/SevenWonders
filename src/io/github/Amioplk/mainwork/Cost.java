package io.github.Amioplk.mainwork;

import java.util.HashMap;
import java.util.Set;

public class Cost {

	HashMap<Ressource, Integer> dist;
	
	public Cost() {}
	
	public static Cost instanciateCost(Cost cost, Set<Ressource> keys) {
		Cost newCost = new Cost();
		newCost.dist = new HashMap<Ressource, Integer>();
		for(Ressource key : keys) {
			newCost.dist.put(key, cost.dist.get(key));
		}
		
		return newCost;
	}

}
