package main.java.io.github.Amioplk.mainwork;

import java.util.Map;

public class RessourceCard extends Card {

	/**
	 * La composition en ressource de chaque carte
	 */
	private Map<Ressource, Integer> composition; 
	
	public RessourceCard(Map<Ressource, Integer> m){ // Vérifier que la première
		composition.putAll(m);
	}
	
	public RessourceCard(String name) {
		super(name);
	}

	public boolean offersChoice() {
		return getFullComposition().size() >= 2;
	}
	
	public int getAmount(Ressource r) {
		
		if(!composition.containsKey(r)) return 0;
		
		return (composition.get(r));
	}
	
	public boolean containsRessource(Ressource r) {
		
		return composition.containsKey(r);
	}
	
	public Map<Ressource, Integer> getFullComposition(){
		return composition; 
	}
	
}
