package assign07;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This class contains tests for the Pixel class.
 * 
 * @author Prof. Martin and Jiaqi Zou
 * @version 2023/ Mar 15
 */
public class PixelTest {

	@Test
	public void testGetRedAmount() {
		Pixel tan = new Pixel(210, 180, 140);
		assertEquals(210, tan.getRedAmount());
	}

	@Test
	public void testGetBlueAmount() {
		Pixel tan = new Pixel(210, 180, 140);
		assertEquals(140, tan.getBlueAmount());
	}

	@Test
	public void testGetGreenAmount() {
		Pixel tan = new Pixel(210, 180, 140);
		assertEquals(180, tan.getGreenAmount());
	}

	@Test
	public void testGetPackedRGBZero() {
		Pixel black = new Pixel(0, 0, 0);
		assertEquals(0, black.getPackedRGB());
	}

	@Test
	public void testGetPackedRGB1() {
		Pixel color = new Pixel(0, 0, 255);
		assertEquals(255, color.getPackedRGB());
	}

	@Test
	public void testGetPackedRGB2() {
		Pixel color = new Pixel(255, 0, 0);
		assertEquals(16711680, color.getPackedRGB());
	}

	@Test
	public void testGetPackedRGB3() {
		Pixel color = new Pixel(0, 255, 0);
		assertEquals(65280, color.getPackedRGB());
	}

	@Test
	public void testGetPackedRGB4() {
		Pixel color = new Pixel(255, 255, 0);
		assertEquals(16776960, color.getPackedRGB());
	}

}