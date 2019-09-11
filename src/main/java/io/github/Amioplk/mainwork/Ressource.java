package main.java.io.github.Amioplk.mainwork;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum Ressource {
	STONE,
	WOOD,
	ORE,
	CLAY,
	PAPYRUS,
	FABRIC,
	GLASS,
	SHIELD,
	MONEY;
	
	public static Ressource toRessource(String str) {
		if("Stone".equals(str)) return Ressource.STONE;
		else if("Wood".equals(str)) return Ressource.WOOD;
		else if("Ore".equals(str)) return Ressource.ORE;
		else if("Clay".equals(str)) return Ressource.CLAY;
		else if("Papyrus".equals(str)) return Ressource.PAPYRUS;
		else if("Fabric".equals(str)) return Ressource.FABRIC;
		else if("Glass".equals(str)) return Ressource.GLASS;
		else if("Shield".equals(str)) return Ressource.SHIELD;
		else if("Money".equals(str)) return Ressource.MONEY;
		else throw new IllegalArgumentException();
	}
	
	public static Set<Ressource> getLackingRessources(Set<Ressource> ressources){
		
		Set<Ressource> lackingRessources = Arrays.stream(Ressource.values()).collect(Collectors.toSet());
		
		for(Ressource ressource : lackingRessources) {
			if(ressources.contains(ressource)) {
				lackingRessources.remove(ressource);
			}
		}
		
		return lackingRessources;
	}
	
}
