package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import mainwork.Frame;
import mainwork.Wonder;

class WonderTest {

	@Test
	void newWonderIsNotFull() {
		Wonder wonder = new Wonder(new Frame(), "Carte");
		assertFalse(wonder.fullWonder());
	}

}
