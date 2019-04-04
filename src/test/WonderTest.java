package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mainwork.Wonder;

class WonderTest {

	@Test
	void newWonderIsNotFull() {
		Wonder wonder = new Wonder();
		assertFalse(wonder.fullWonder());
	}

}
