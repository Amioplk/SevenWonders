package test;


import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import mainwork.Card;
import mainwork.CardType;

public class CardTest {
	
	@Test
	void TestEqualityOfACardWithItself() {
		Card card = new Card("olive", CardType.OTHER);
		assertTrue(card.equals(card));
	}
	
}
