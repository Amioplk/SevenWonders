package test;

import java.util.HashMap;

public class TestingFeatures {
	
	public static void main(String[] args) {
		HashMap<String, Integer> hashmap = new HashMap<>();
		hashmap.put("Amir", 1);
		hashmap.put("Amir", 2);
		for(String x: hashmap.keySet()) {
			System.out.println(x + ": " + hashmap.get(x));
		}
	}
	
}
