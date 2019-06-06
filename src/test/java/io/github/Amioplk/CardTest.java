package test.java.io.github.Amioplk;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import main.java.io.github.Amioplk.mainwork.Card;
import main.java.io.github.Amioplk.mainwork.CardType;

public class CardTest {
	
	@Test
	void TestEqualityOfACardWithItself() {
		Card card = new Card("olive", CardType.OTHER);
		Card card1 = new Card("tom", CardType.OTHER);
		assertTrue(card.equals(card));
		assertFalse(card.equals(card1));
	}
	
}
