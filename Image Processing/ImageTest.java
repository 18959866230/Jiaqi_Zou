package assign07;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This class contains tests for the Image class.
 * 
 * @author Prof. Martin and Jiaqi Zou
 * @version 2023/ Mar 15
 */
public class ImageTest {

	@Test
	public void testRedBlueSwapFilter() {
		Image defaultImage = new Image();
		defaultImage.redBlueSwapFilter();

		int[][] expected = { { 255, 255, 0 }, { 0, 0, 255 }, { 0, 255, 0 }, { 255, 0, 255 }, { 0, 255, 255 },
				{ 255, 0, 0 } };
		int pixelCounter = 0;
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 2; j++, pixelCounter++) {
				Pixel p = defaultImage.getPixel(i, j);
				assertEquals(expected[pixelCounter][0], p.getRedAmount(),
						"redAmount for pixel at " + i + ", " + j + " incorrect");
				assertEquals(expected[pixelCounter][1], p.getGreenAmount(),
						"greenAmount for pixel at " + i + ", " + j + " incorrect");
				assertEquals(expected[pixelCounter][2], p.getBlueAmount(),
						"blueAmount for pixel at " + i + ", " + j + " incorrect");
			}

		try {
			defaultImage.getPixel(3, 0);
			fail("getPixel for out-of-range rowIndex should throw exception");
		} catch (IndexOutOfBoundsException e) {
			// do nothing -- exception expected
		}

		try {
			defaultImage.getPixel(0, 2);
			fail("getPixel for out-of-range columnIndex should throw exception");
		} catch (IndexOutOfBoundsException e) {
			// do nothing -- exception expected
		}
	}

	@Test
	public void testBlackAndWhiteFilter() {
		Image defaultImage = new Image();
		defaultImage.blackAndWhiteFilter();

		int[][] expected = { { 170, 170, 170 }, { 85, 85, 85 }, { 85, 85, 85 }, { 170, 170, 170 }, { 170, 170, 170 },
				{ 85, 85, 85 } };
		int pixelCounter = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++, pixelCounter++) {
				Pixel p = defaultImage.getPixel(i, j);
				assertEquals(expected[pixelCounter][0], p.getRedAmount(),
						"redAmount for pixel at " + i + ", " + j + " incorrect");
				assertEquals(expected[pixelCounter][1], p.getGreenAmount(),
						"greenAmount for pixel at " + i + ", " + j + " incorrect");
				assertEquals(expected[pixelCounter][2], p.getBlueAmount(),
						"blueAmount for pixel at " + i + ", " + j + " incorrect");
			}
		}

		try {
			defaultImage.getPixel(3, 0);
			fail("getPixel for out-of-range rowIndex should throw exception");
		} catch (IndexOutOfBoundsException e) {
			// do nothing -- exception expected
		}

		try {
			defaultImage.getPixel(0, 2);
			fail("getPixel for out-of-range columnIndex should throw exception");
		} catch (IndexOutOfBoundsException e) {
			// do nothing -- exception expected
		}
	}

	@Test
	public void testRotateClockwise() {
		Image defaultImage = new Image();
		defaultImage.rotateClockwiseFilter();
		
		 // check pixel values
	    assertEquals(0, defaultImage.getPixel(0, 1).getRedAmount()); // Cyan -> green
	    assertEquals(255, defaultImage.getPixel(0, 0).getRedAmount()); // Red -> cyan
	    assertEquals(0, defaultImage.getPixel(1, 0).getGreenAmount()); // Magenta -> blue
	}

	
	
	@Test
	public void testCustomFilter() {
	    Image defaultImage = new Image();
	    defaultImage.customFilter();
	    int[][] expected = {{255, 0, 0}, {0, 255, 255}, {255, 0, 255}, {0, 255, 0}, {0, 0, 255}, {255, 255, 0}};
	    int pixelCounter = 0;
	    for (int i = 0; i < 3; i++) {
	        for (int j = 0; j < 2; j++, pixelCounter++) {
	            Pixel p = defaultImage.getPixel(i, j);
	            assertEquals(expected[pixelCounter][0], p.getRedAmount(), "redAmount for pixel at " + i + ", " + j + " incorrect");
	            assertEquals(expected[pixelCounter][1], p.getGreenAmount(), "greenAmount for pixel at " + i + ", " + j + " incorrect");
	            assertEquals(expected[pixelCounter][2], p.getBlueAmount(), "blueAmount for pixel at " + i + ", " + j + " incorrect");
	        }
	    }

	    try {
	        defaultImage.getPixel(3, 0);
	        fail("getPixel for out-of-range rowIndex should throw exception");
	    } catch (IndexOutOfBoundsException e) {
	        // do nothing -- exception expected
	    }

	    try {
	        defaultImage.getPixel(0, 2);
	        fail("getPixel for out-of-range columnIndex should throw exception");
	    } catch (IndexOutOfBoundsException e) {
	        // do nothing -- exception expected
	    }
	}

}