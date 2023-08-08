package assign05;

/**
 * this is a public class called Line2D that represents a line segment on a
 * two-dimensional plane. The class contains two instance variables and seven
 * instance methods, including constructors.
 * 
 * @author Jiaqi Zou
 * @version Feb 21/ 2023
 *
 */

public class Line2D {
	private Point2D endPoint1;
	private Point2D endPoint2;

	/**
	 * This constructor has no parameters and creates a new Line2D object for which
	 * one end point is (0, 0) and the other end point is (1, 1).
	 */
	public Line2D() {
		this.endPoint1 = new Point2D(0, 0);
		this.endPoint2 = new Point2D(1, 1);

	}

	/**
	 * This constructor has two parameters and creates a new Line2D object for which
	 * the two end points are set according to the parameters.
	 * 
	 * @param endPoint1
	 * @param endPoint2
	 * @return none
	 */
	public Line2D(Point2D endPoint1, Point2D endPoint2) {
		this.endPoint1 = endPoint1.copyOf();
		this.endPoint2 = endPoint2.copyOf();

	}

	/**
	 * This method creates and returns an array containing copies of the two end
	 * points of this Line2D object.
	 * 
	 * @param none
	 * @return an array containing copies of the two end points of this Line2D
	 *         object
	 * 
	 */
	public Point2D[] getEndpoints() {
		Point2D[] endPoints = new Point2D[2];
		endPoints[0] = endPoint1.copyOf();
		endPoints[1] = endPoint2.copyOf();
		return endPoints;
	}

	/**
	 * This method returns the distance between the two end points of this Line2D
	 * object.
	 * 
	 * @param none
	 * @return distance between the two end points of this Line2D object
	 */
	public double distance() {
		Point2D[] endPoints = getEndpoints();
		double distances = endPoints[0].distance(endPoints[1]);
		return distances;

	}

	/**
	 * This method returns the slope of this Line2D object
	 * 
	 * @param none
	 * @return the slope of this Line2D object
	 */
	public double slope() {
		Point2D[] endPoints = getEndpoints();
		double slopes = endPoints[0].slope(endPoints[1]);
		return slopes;

	}

	/**
	 * This method returns the Point2D object that is the midpoint of this Line2D
	 * object.
	 * 
	 * @param none
	 * @return the Point2D object that is the midpoint of this Line2D object
	 */
	public Point2D midpoint() {
		Point2D[] endPoints = getEndpoints();
		Point2D midpoints = endPoints[0].midpoint(endPoints[1]);
		return midpoints;

	}

	/**
	 * This method returns true if the two end points of this Line2D object are
	 * equal to the two end points of the Line2D object referenced by other, and
	 * returns false otherwise.
	 * 
	 * @param none
	 * @return a boolean value under conditions.
	 */
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (!(other instanceof Line2D)) {
			return false;
		}
		Line2D otherLine = (Line2D) other;
		Point2D[] endPoints = getEndpoints();
		Point2D[] otherEndPoints = otherLine.getEndpoints();
		return (endPoints[0].equals(otherEndPoints[0]) && endPoints[1].equals(otherEndPoints[1]))
				|| (endPoints[0].equals(otherEndPoints[1]) && endPoints[1].equals(otherEndPoints[0]));
	}
}
