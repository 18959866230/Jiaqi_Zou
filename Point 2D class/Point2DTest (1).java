package assign04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This is the class used to test the methods in Point2D class, includes corner case and normal case for each test. 
 * @author Jiaqi Zou
 * @version Feb 11, 2023
 *
 */
public class Point2DTest {
	
	@Test
	public void testGetX() {
		Point2D location = new Point2D(-43, 55);
		assertEquals(-43, location.getX());	
	}
	
	@Test
	public void testGetX2() {
		Point2D locationTwo = new Point2D(0, 0);
		assertEquals(0, locationTwo.getX());
	}
	
	@Test
	public void testGetX3() {
		Point2D locationTwo = new Point2D(0, 7);
		assertEquals(0, locationTwo.getX());
	}
	
	@Test
	public void testGetX4() {
		Point2D locationTwo = new Point2D(7, 0);
		assertEquals(7, locationTwo.getX());
	}
	
	@Test 
	public void testClear() {
		Point2D point = new Point2D(1, -2);
		point.clear();
		assertEquals(0, point.getX());
		assertEquals(0, point.getY());
	}
	
	@Test 
	public void testClear2() {
		Point2D point = new Point2D(0, 0);
		point.clear();
		assertEquals(0, point.getX());
		assertEquals(0, point.getY());
	}
	
	@Test 
	public void testClear3() {
		Point2D point = new Point2D(-1, -2);
		point.clear();
		assertEquals(0, point.getX());
		assertEquals(0, point.getY());
	}
	
	@Test 
	public void testClear4() {
		Point2D point = new Point2D(-1, 2);
		point.clear();
		assertEquals(0, point.getX());
		assertEquals(0, point.getY());
	}
	
	
	@Test
	public void testMove() {
		Point2D zero = new Point2D();
		assertEquals(0, zero.getX());
		assertEquals(0, zero.getY());
		zero.move(100, -2);
		assertEquals(100, zero.getX());
		assertEquals(-2, zero.getY());
	}
	
	@Test
	public void testMove2() {
		Point2D zero = new Point2D();
		assertEquals(0, zero.getX());
		assertEquals(0, zero.getY());
		zero.move(2, 3);
		assertEquals(2, zero.getX());
		assertEquals(3, zero.getY());
	}
	
	@Test
	public void testMove3() {
		Point2D zero = new Point2D();
		assertEquals(0, zero.getX());
		assertEquals(0, zero.getY());
		zero.move(-1, -1);
		assertEquals(-1, zero.getX());
		assertEquals(-1, zero.getY());
	}
	
	@Test
	public void testMove4() {
		Point2D zero = new Point2D();
		assertEquals(0, zero.getX());
		assertEquals(0, zero.getY());
		zero.move(0, 0);
		assertEquals(0, zero.getX());
		assertEquals(0, zero.getY());
	}
	
	@Test
	public void testToString() {
		Point2D zero = new Point2D();
		assertEquals("(0, 0)", zero.toString());
	}
	
	@Test
	public void testToString2() {
		Point2D zero = new Point2D(4, 7);
		assertEquals("(4, 7)", zero.toString());
	}
	
	@Test
	public void testToString3() {
		Point2D zero = new Point2D(-1, -1);
		assertEquals("(-1, -1)", zero.toString());
	}
	
	@Test
	public void testToString4() {
		Point2D zero = new Point2D(1, -1);
		assertEquals("(1, -1)", zero.toString());
	}
	
	@Test
	public void testDistance() {
		Point2D southWest = new Point2D(3, 1);
		Point2D northEast = new Point2D(10, 12);
		
		/* This version of assertEquals has a third parameter for the error 
		 * tolerance when comparing two doubles, which is necessary since 
		 * many values with decimal points cannot be represented exactly in 
		 * a computer. 
		 */
		assertEquals(13.0384, southWest.distance(northEast), 0.0001);
	}
	
	@Test
	public void testDistance2() {
		Point2D southWest = new Point2D(0, 0);
		Point2D northEast = new Point2D(0, 0);
		assertEquals(0, southWest.distance(northEast), 0.0001);
}
	
	@Test
	public void testDistance3() {
		Point2D southWest = new Point2D(1, 1);
		Point2D northEast = new Point2D(-1, -1);
		assertEquals(2.8284, southWest.distance(northEast), 0.0001);
}
	
	@Test
	public void testDistance4() {
		Point2D southWest = new Point2D(-2, 2);
		Point2D northEast = new Point2D(2, -2);
		assertEquals(5.6568, southWest.distance(northEast), 0.0001);
}
	
	@Test
	public void testSlope() {
		Point2D point1 = new Point2D(0,0);
		Point2D point2 = new Point2D(1,1);
		assertEquals(1.0, point1.slope(point2), 0.1);
	}
	
	@Test
	public void testSlope2() {
		Point2D point1 = new Point2D(10,12);
		Point2D point2 = new Point2D(0,27);
		assertEquals(-1.5, point1.slope(point2), 0.1);
	}
	
	@Test
	public void testSlope3() {
		Point2D point1 = new Point2D(1,2);
		Point2D point2 = new Point2D(3,4);
		assertEquals(1.0, point1.slope(point2), 0.1);
	}
	
	@Test
	public void testSlope4() {
		Point2D point1 = new Point2D(4,0);
		Point2D point2 = new Point2D(10,12);
		assertEquals(2.0, point1.slope(point2), 0.1);
	}
	
	@Test
	public void testEquals() {
		Point2D point1 = new Point2D(50, 50);
		Object point2 = new Point2D(50, 50);
		assertTrue(point1.equals(point2));
	}
	
	@Test
	public void testEquals2() {
		Point2D point1 = new Point2D(0, 0);
		Object point2 = new Point2D(0, 0);
		assertTrue(point1.equals(point2));
	}
	
	@Test
	public void testEquals3() {
		Point2D point1 = new Point2D(1, 1);
		Object point2 = new Point2D(-1, -1);
		assertFalse(point1.equals(point2));
	}
	
	@Test
	public void testEquals4() {
		Point2D point1 = new Point2D(1, -1);
		Object point2 = new Point2D(-1, 1);
		assertFalse(point1.equals(point2));
	}

}