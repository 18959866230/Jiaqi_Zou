package assign04;

/**
 * This is the class represents a point (x, y) on a two-dimensional plane, and
 * have two instance variables and ten non-static methods, including
 * constructors.
 * 
 * @author Jiaqi Zou
 * @version Feb 11, 2023
 *
 */
public class Point2D {
	private int x;
	private int y;

	/**
	 * This constructor has no parameters and creates a new Point2D object in which
	 * both the x and the y of the point are set to 0.
	 * 
	 * @param none
	 * @return none
	 */
	public Point2D() {
		this.x = 0;
		this.y = 0;

	}

	/**
	 * This constructor has two parameters and creates a new Point2D object in which
	 * the x and the y of the point are set according to the value of the
	 * parameters.
	 * 
	 * @param x
	 * @param y
	 * @return none
	 */
	public Point2D(int x, int y) {
		this.x = x;
		this.y = y;

	}

	/**
	 * This method returns the value of the x coordinate of this Point2D object.
	 * 
	 * @param none
	 * @return x
	 */
	public int getX() {
		return x;

	}

	/**
	 * This method returns the value of the x coordinate of this Point2D object.
	 * 
	 * @param none
	 * @return y
	 */
	public int getY() {
		return y;

	}

	/**
	 * This method sets both the x and the y of this Point2D object to 0, regardless
	 * of their values before this method was called.
	 * 
	 * @param none
	 * @return none
	 */
	public void clear() {
		x = 0;
		y = 0;

	}

	/**
	 * This method sets both the x and the y of this Point2D object to the values
	 * indicated by the parameters, regardless of their values before this method
	 * was called.
	 * 
	 * @param x
	 * @param y
	 * @return none
	 */
	public void move(int x, int y) {
		this.x = x;
		this.y = y;

	}

	/**
	 * This method does not change the x and the y of this Point2D object. Instead,
	 * it returns a text representation of the point. For example, if this object's
	 * x is 4 and this object's y is 7, the method returns "(4, 7)".
	 * 
	 * @param none
	 * @return a text representation of the point, "(" + x + ", " + y + ")".
	 */
	public String toString() {
		String pointToString = "(" + x + ", " + y + ")";
		return pointToString;
	}

	/**
	 * This method does not change the x and the y of this Point2D object. Instead,
	 * it returns the distance between the two points, using the Euclidean formula
	 * for distance: ((x2-x1)^2+(y2-y1)^2)^0.5.
	 * 
	 * @param secondPoint
	 * @return the distance between the two points, distances.
	 */
	public double distance(Point2D secondPoint) {
		int xDifference = x - secondPoint.x;
		int yDifference = y - secondPoint.y;
		double distances = Math.sqrt(Math.pow(xDifference, 2) + Math.pow(yDifference, 2));
		return distances;

	}

	/**
	 * This method does not change the x and the y of this Point2D object. Instead,
	 * it returns the slope of the straight line between the two points. Since slope
	 * is the change in y coordinate with respect to the change in x coordinate of
	 * that line, use this formula:(y2-y1)/(x2-x1).
	 * 
	 * @param secondPoint
	 * @return slopes
	 */
	public double slope(Point2D secondPoint) {
		double x2 = secondPoint.getX();
	    double y2 = secondPoint.getY();
	    double x1 = this.x;
	    double y1 = this.y;
	    return (y2 - y1) / (x2 - x1);
	}

	/**
	 * This method does not change the x and the y of this Point2D object. Instead,
	 * it returns true if the two points have the same values for x coordinates and
	 * the same values for y coordinates. The method returns false otherwise.
	 * 
	 * @param other
	 * @return this.x == otherPoint.x && this.y == otherPoint.y
	 */
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}

		if (this.getClass() != other.getClass()) {
			return false;
		}

		Point2D otherPoint = (Point2D) other;
		return this.x == otherPoint.x && this.y == otherPoint.y;

	}
}
