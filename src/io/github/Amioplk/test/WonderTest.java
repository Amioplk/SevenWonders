package io.github.Amioplk.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import io.github.Amioplk.mainwork.Frame;
import io.github.Amioplk.mainwork.Wonder;

class WonderTest {

	@Test
	void newWonderIsNotFull() {
		Wonder wonder = new Wonder(new Frame(), "Carte");
		assertFalse(wonder.fullWonder());
	}

}
