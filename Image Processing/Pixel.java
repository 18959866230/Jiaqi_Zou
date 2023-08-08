package assign07;


/**
 * this class is aim to represents a single pixel in a digital image.
 * The class contains three instance variables and five instance methods, including a constructor.
 * @author Jiaqi Zou
 * @version 2023/ Mar 15
 *
 */
public class Pixel {
	private int redAmount;
	private int greenAmount;
	private int blueAmount;
	
	public Pixel(int redAmount, int greenAmount, int blueAmount){
		if(redAmount < 0 || redAmount >255 ||
			greenAmount <0 || greenAmount >255||
			blueAmount<0 || blueAmount > 255) {
			throw new IllegalArgumentException("Pixel values must be between 0 and 255, inclusive.");
			
		}
		this.redAmount = redAmount;
		this.blueAmount = blueAmount;
		this.greenAmount = greenAmount;
		
	}
	
	/**
	 * this method is to get the amount of red pixel in the image. 
	 * @param none 
	 * @return None 
	 */
	public int getRedAmount() {
		return this.redAmount;
		
	}
	/**
	 * this method is to get the amount of green pixel in the image.
	 * @param None 
	 * @return None 
	 */
	public int getGreenAmount() {
		return this.greenAmount;
	}
	
	
	/**
	 * this method is to get the amount of blue pixel in the image.
	 * 
	 * @param None 
	 * @return None 
	 */
	public int getBlueAmount() {
		return this.blueAmount;
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
