package io.github.Amioplk.test;


import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import io.github.Amioplk.mainwork.Card;
import io.github.Amioplk.mainwork.CardType;

public class CardTest {
	
	@Test
	void TestEqualityOfACardWithItself() {
		Card card = new Card("olive", CardType.OTHER);
		assertTrue(card.equals(card));
	}
	
}
