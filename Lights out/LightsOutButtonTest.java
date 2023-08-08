package assign09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This class contains tests for the LightsOutButton class.
 * 
 * @author Prof. Martin and Jiaqi Zou
 * @version 2023/Apr 3
 */
public class LightsOutButtonTest {

	@Test
	public void testGetRow() {
		LightsOutButton button = new LightsOutButton(3, 4);
		assertEquals(3, button.getRow());

		LightsOutButton button2 = new LightsOutButton(0, 3);
		assertEquals(0, button2.getRow());

		LightsOutButton button3 = new LightsOutButton(1, 4);
		assertEquals(1, button3.getRow());

		LightsOutButton button4 = new LightsOutButton(2, 4);
		assertEquals(2, button4.getRow());

	}

	@Test
	public void testGetColumn() {
		LightsOutButton button = new LightsOutButton(3, 4);
		assertEquals(4, button.getColumn());

		LightsOutButton button2 = new LightsOutButton(0, 3);
		assertEquals(3, button2.getColumn());

		LightsOutButton button3 = new LightsOutButton(1, 4);
		assertEquals(4, button3.getColumn());

		LightsOutButton button4 = new LightsOutButton(2, 4);
		assertEquals(4, button4.getColumn());
	}

	@Test
	public void testIsOn() {
		LightsOutButton button = new LightsOutButton(0, 3);
		assertFalse(button.isOn());

		LightsOutButton button2 = new LightsOutButton(1, 3);
		assertFalse(button2.isOn());

		LightsOutButton button3 = new LightsOutButton(2, 3);
		assertFalse(button3.isOn());

		LightsOutButton button4 = new LightsOutButton(3, 3);
		assertFalse(button4.isOn());
	}

	@Test
	public void testToggle() {
		LightsOutButton button = new LightsOutButton(1, 1);
		button.toggle();
		assertTrue(button.isOn());

		LightsOutButton button2 = new LightsOutButton(2, 1);
		button2.toggle();
		assertTrue(button2.isOn());

		LightsOutButton button3 = new LightsOutButton(3, 1);
		button3.toggle();
		assertTrue(button3.isOn());

		LightsOutButton button4 = new LightsOutButton(4, 3);
		button4.toggle();
		assertTrue(button4.isOn());

	}
}