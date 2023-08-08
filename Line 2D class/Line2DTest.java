package assign05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This is the J unit5 tests set up for class Line2D for each instances method.
 * 
 * @author Jiaqi Zou
 * @version Feb 21/ 2023
 *
 */

public class Line2DTest {

	@Test
	public void testGetEndpoints() {
		Line2D line1 = new Line2D(new Point2D(1, 2), new Point2D(3, 4));
		Point2D[] expectedEndpoints1 = { new Point2D(1, 2), new Point2D(3, 4) };
		assertArrayEquals(expectedEndpoints1, line1.getEndpoints());

		Line2D line2 = new Line2D(new Point2D(-1, -2), new Point2D(-3, -4));
		Point2D[] expectedEndpoints2 = { new Point2D(-1, -2), new Point2D(-3, -4) };
		assertArrayEquals(expectedEndpoints2, line2.getEndpoints());

		Line2D line3 = new Line2D();
		Point2D[] expectedEndpoints3 = { new Point2D(0, 0), new Point2D(1, 1) };
		assertArrayEquals(expectedEndpoints3, line3.getEndpoints());
	}

	@Test
	public void testDistance() {
		Line2D line1 = new Line2D(new Point2D(1, 2), new Point2D(3, 4));
		assertEquals(2.828, line1.distance(), 0.001);

		Line2D line2 = new Line2D(new Point2D(-5, -6), new Point2D(-7, -8));
		assertEquals(2.828, line2.distance(), 0.001);

		Line2D line3 = new Line2D();
		assertEquals(1.414, line3.distance(), 0.001);
	}

	@Test
	public void testSlope() {
		Line2D line1 = new Line2D(new Point2D(1, 2), new Point2D(3, 4));
		assertEquals(1, line1.slope(), 0.1);

		Line2D line2 = new Line2D(new Point2D(-50, -60), new Point2D(-70, -80));
		assertEquals(1, line2.slope(), 0.1);

		Line2D line3 = new Line2D();
		assertEquals(1, line3.slope(), 0.1);
	}

	@Test
	public void testMidpoint() {
		Line2D line1 = new Line2D(new Point2D(1, 2), new Point2D(3, 4));
		Point2D expectedMidpoint1 = new Point2D(2, 3);
		assertEquals(expectedMidpoint1, line1.midpoint());

		Line2D line2 = new Line2D(new Point2D(-5, -6), new Point2D(-7, -8));
		Point2D expectedMidpoint2 = new Point2D(-6, -7);
		assertEquals(expectedMidpoint2, line2.midpoint());

		Line2D line3 = new Line2D();
		Point2D expectedMidpoint3 = new Point2D(0, 0);
		assertEquals(expectedMidpoint3, line3.midpoint());
	}

	@Test
	public void testEquals() {
		Line2D line1 = new Line2D(new Point2D(1, 2), new Point2D(3, 4));
		Line2D line2 = new Line2D(new Point2D(3, 4), new Point2D(1, 2));
		Line2D line3 = new Line2D(new Point2D(1, 2), new Point2D(5, 6));

		assertTrue(line1.equals(line2));
		assertFalse(line1.equals(line3));
	}

	@Test
	public void testEquals2() {
		Line2D line1 = new Line2D(new Point2D(5, 6), new Point2D(7, 8));
		Line2D line2 = new Line2D(new Point2D(7, 8), new Point2D(5, 6));

		assertTrue(line1.equals(line2));
	}

	@Test
	public void testEquals3() {
		Line2D line1 = new Line2D(new Point2D(0, 0), new Point2D(3, 4));
		Line2D line2 = new Line2D(new Point2D(3, 4), new Point2D(0, 0));
		Line2D line3 = new Line2D(new Point2D(1, 2), new Point2D(5, 6));

		assertTrue(line1.equals(line2));
		assertFalse(line1.equals(line3));
	}

	@Test
	public void testEquals4() {
		Line2D line1 = new Line2D(new Point2D(1, -2), new Point2D(-3, 4));
		Line2D line2 = new Line2D(new Point2D(-3, 4), new Point2D(1, -2));
		Line2D line3 = new Line2D(new Point2D(1, -2), new Point2D(-3, 6));

		assertTrue(line1.equals(line2));
		assertFalse(line1.equals(line3));
	}

}
