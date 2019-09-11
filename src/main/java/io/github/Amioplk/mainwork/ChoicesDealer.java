package main.java.io.github.Amioplk.mainwork;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Function;

/**
 * @author Amioplk
 *
 * @param <T> Le type de données sur lequel on veut choisir
 * @param <U> Le type de données sur lequel on veut avoir une contrainte
 */
public class ChoicesDealer<T> {

	Map<Set<T>, Integer> portfolio; 
	int constraint;
	List<Integer> distribution;
	
	void purge(Function<Set<T>, Integer> function){
		
		for(Entry<Set<T>, Integer> entry : portfolio.entrySet()) {
			if((function.apply(entry.getKey())) < constraint) portfolio.remove(entry.getKey());
		}
		
	}
}
