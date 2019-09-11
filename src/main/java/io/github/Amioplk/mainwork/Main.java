package main.java.io.github.Amioplk.mainwork;

import java.util.HashSet;
import java.util.Set;

public class Main {
	
	static Set<BorrowAction> borrowActionPortfolio = new HashSet<>();
	
	@SuppressWarnings("null")
	public static void main(String[] args) {
		Player p1 = new Player();
		BorrowAction a1 = new BorrowAction(Ressource.CLAY, 1, p1);
		BorrowAction a2 = new BorrowAction(Ressource.CLAY, 2, p1);

		appendPortfolio2(a1);
		appendPortfolio2(a2);
		
		borrowActionPortfolio.forEach(c -> System.out.println(c));
		
		System.out.println(a1.equals(a2));
	}
	
	private static void appendPortfolio(BorrowAction b){
		
		boolean present = false;
		for(BorrowAction action : borrowActionPortfolio) {
			if(action.equals(b)) {
				System.out.println("OK");
				action.many = b.many;
				present = true;
			}
		}
		
		if(!present) borrowActionPortfolio.add(b);
		
	}
	
	private static void appendPortfolio2(BorrowAction b){
		borrowActionPortfolio.stream().forEach(c -> {
			if(c.equals(b)) c.many = b.many;
			b.many = -1;
		});
		
		if(b.many >= 0) borrowActionPortfolio.add(b);
	}
	
}
