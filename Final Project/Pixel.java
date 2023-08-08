package assign11;

/**
 * this class is aim to represents a single pixel in a digital image. The class
 * contains three instance variables and five instance methods, including a
 * constructor.
 * 
 * @author Jiaqi Zou
 * @version 2023/ Apr 23
 *
 */
public class Pixel {
	private int redAmount;
	private int greenAmount;
	private int blueAmount;

	/**
	 * Constructs a Pixel object with the specified red, green, and blue color
	 * components. Each color component must be an integer between 0 and 255,
	 * inclusive.
	 *
	 * @param redAmount   the red color component value (0-255)
	 * @param greenAmount the green color component value (0-255)
	 * @param blueAmount  the blue color component value (0-255)
	 * @throws IllegalArgumentException if any of the color component values are
	 *                                  outside the range of 0-255
	 */
	public Pixel(int redAmount, int greenAmount, int blueAmount) {
		if (redAmount < 0 || redAmount > 255 || greenAmount < 0 || greenAmount > 255 || blueAmount < 0
				|| blueAmount > 255) {
			throw new IllegalArgumentException("Pixel values must be between 0 and 255, inclusive.");

		}
		this.redAmount = redAmount;
		this.blueAmount = blueAmount;
		this.greenAmount = greenAmount;

	}

	/**
	 * this method is to get the amount of red pixel in the image.
	 * 
	 * @param none
	 * @return int
	 */
	public int getRedAmount() {
		return this.redAmount;

	}

	/**
	 * this method is to get the amount of green pixel in the image.
	 * 
	 * @param None
	 * @return int
	 */
	public int getGreenAmount() {
		return this.greenAmount;
	}

	/**
	 * this method is to get the amount of blue pixel in the image.
	 * 
	 * @param None
	 * @return int
	 */
	public int getBlueAmount() {
		return this.blueAmount;
	}

	
	 /**
     * Sets the amount of red pixel in the image.
     * 
     * @param redAmount the amount of red pixel to set (0-255)
     * @throws IllegalArgumentException if the red amount is outside the range of 0-255
     */
	public void setRedAmount(int redAmount) {
	    if (redAmount >= 0 && redAmount <= 255) {
	        this.redAmount = redAmount;
	    } else {
	        throw new IllegalArgumentException("Red amount must be between 0 and 255");
	    }
	}

    
    /**
     * Sets the amount of green pixel in the image.
     * 
     * @param redAmount the amount of green pixel to set (0-255)
     * @throws IllegalArgumentException if the green amount is outside the range of 0-255
     */
    public void setGreenAmount(int greenAmount) {
        if (greenAmount >= 0 && greenAmount <= 255) {
	        this.greenAmount = greenAmount;
	    } else {
	        throw new IllegalArgumentException("Green amount must be between 0 and 255");
	    }
	}
    
    
    /**
     * Sets the amount of blue pixel in the image.
     * 
     * @param redAmount the amount of blue pixel to set (0-255)
     * @throws IllegalArgumentException if the blue amount is outside the range of 0-255
     */
    public void setBlueAmount(int blueAmount) {
    	   if (blueAmount >= 0 && blueAmount <= 255) {
   	        this.blueAmount = blueAmount;
   	    } else {
   	        throw new IllegalArgumentException("Blue amount must be between 0 and 255");
   	    }
   	}
    
	/**
	 * this method is to convert the amount of color we get into RGB value.
	 * 
	 * @param None
	 * @return None
	 */
	public int getPackedRGB() {
		int packedValue = 0;
		packedValue = packedValue | (this.redAmount << 16);
		packedValue = packedValue | (this.greenAmount << 8);
		packedValue = packedValue | this.blueAmount;

		return packedValue;
	}
}
