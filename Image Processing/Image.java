package assign07;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * This class represents an image as a two-dimensional array of pixels and
 * provides a number of image filters (via instance methods) for changing the
 * appearance of the image. Application of multiple filters is cumulative; e.g.,
 * obj.redBlueSwapFilter() followed by obj.rotateClockwiseFilter() results in an
 * image altered both in color and orientation.
 * 
 * Note: - The pixel in the northwest corner of the image is stored in the first
 * row, first column. - The pixel in the northeast corner of the image is stored
 * in the first row, last column. - The pixel in the southeast corner of the
 * image is stored in the last row, last column. - The pixel in the southwest
 * corner of the image is stored in the last row, first column.
 * 
 * @author Prof. Martin and Jiaqi Zou
 * @version 2023/ Mar 15
 */
public class Image {

	private Pixel[][] imageArray;

	/**
	 * Creates a new Image object by reading the image file with the given filename.
	 * 
	 * DO NOT MODIFY THIS METHOD
	 * 
	 * @param filename - name of the given image file to read
	 * @throws IOException if file does not exist or cannot be read
	 */
	public Image(String filename) {
		BufferedImage imageInput = null;
		try {
			imageInput = ImageIO.read(new File(filename));
		} catch (IOException e) {
			System.out.println("Image file " + filename + " does not exist or cannot be read.");
		}
		imageArray = new Pixel[imageInput.getHeight()][imageInput.getWidth()];
		for (int i = 0; i < imageArray.length; i++)
			for (int j = 0; j < imageArray[0].length; j++) {
				int rgb = imageInput.getRGB(j, i);
				imageArray[i][j] = new Pixel((rgb >> 16) & 255, (rgb >> 8) & 255, rgb & 255);
			}
	}

	/**
	 * Create a new "default" Image object, whose purpose is to be used in testing.
	 * 
	 * The orientation of this image: cyan red green magenta yellow blue
	 *
	 * DO NOT MODIFY THIS METHOD
	 */
	public Image() {
		imageArray = new Pixel[3][2];
		imageArray[0][0] = new Pixel(0, 255, 255); // cyan
		imageArray[0][1] = new Pixel(255, 0, 0); // red
		imageArray[1][0] = new Pixel(0, 255, 0); // green
		imageArray[1][1] = new Pixel(255, 0, 255); // magenta
		imageArray[2][0] = new Pixel(255, 255, 0); // yellow
		imageArray[2][1] = new Pixel(0, 0, 255); // blue
	}

	/**
	 * Gets the pixel at the specified row and column indexes.
	 * 
	 * DO NOT MODIFY THIS METHOD
	 * 
	 * @param rowIndex    - given row index
	 * @param columnIndex - given column index
	 * @return the pixel at the given row index and column index
	 * @throws IndexOutOfBoundsException if row or column index is out of bounds
	 */
	public Pixel getPixel(int rowIndex, int columnIndex) {
		if (rowIndex < 0 || rowIndex >= imageArray.length)
			throw new IndexOutOfBoundsException("rowIndex must be in range 0-" + (imageArray.length - 1));

		if (columnIndex < 0 || columnIndex >= imageArray[0].length)
			throw new IndexOutOfBoundsException("columnIndex must be in range 0-" + (imageArray[0].length - 1));

		return imageArray[rowIndex][columnIndex];
	}

	/**
	 * Writes the image represented by this object to file. Does nothing if the
	 * image length is 0.
	 * 
	 * DO NOT MODIFY THIS METHOD
	 * 
	 * @param filename - name of image file to write
	 * @throws IOException if file does cannot be written
	 */
	public void writeImage(String filename) {
		if (imageArray.length > 0) {
			BufferedImage imageOutput = new BufferedImage(imageArray[0].length, imageArray.length,
					BufferedImage.TYPE_INT_RGB);

			for (int i = 0; i < imageArray.length; i++)
				for (int j = 0; j < imageArray[0].length; j++)
					imageOutput.setRGB(j, i, imageArray[i][j].getPackedRGB());

			try {
				ImageIO.write(imageOutput, "png", new File(filename));
			} catch (IOException e) {
				System.out.println("The image cannot be written to file " + filename);
			}
		}
	}

	/**
	 * Applies a filter to the image represented by this object such that for each
	 * pixel the red amount and blue amount are swapped. Swaps the red and blue
	 * color components of all pixels in the image.
	 * 
	 * @param None
	 * @return None
	 */
	public void redBlueSwapFilter() {
		for (int i = 0; i < imageArray.length; i++) {
			for (int j = 0; j < imageArray[0].length; j++) {
				int red = imageArray[i][j].getRedAmount();
				int blue = imageArray[i][j].getBlueAmount();
				Pixel newPixel = new Pixel(blue, imageArray[i][j].getGreenAmount(), red);
				imageArray[i][j] = newPixel;
			}
		}
	}

	/**
	 * Applies a filter to the image represented by this object such that the color
	 * of each pixel is converted to its corresponding grayscale shade, producing
	 * the effect of a black and white photo. The filter sets the amount of red,
	 * green, and blue all to the value of this average: (originalRed +
	 * originalGreen + originalBlue) / 3 Converts the image to black and white by
	 * setting the red, green, and blue color components of each pixel to the
	 * average of the original values.
	 * 
	 * @param None
	 * @return None
	 */
	public void blackAndWhiteFilter() {
		for (int i = 0; i < imageArray.length; i++) {
			for (int j = 0; j < imageArray[0].length; j++) {
				int red = imageArray[i][j].getRedAmount();
				int green = imageArray[i][j].getGreenAmount();
				int blue = imageArray[i][j].getBlueAmount();

				int grayScale = (red + green + blue) / 3;
				Pixel newPixel = new Pixel(grayScale, grayScale, grayScale);
				imageArray[i][j] = newPixel;
			}
		}
	}

	/**
	 * Applies a filter to the image represented by this object such that it is
	 * rotated clockwise (by 90 degrees). Rotates the image 90 degrees clockwise by
	 * swapping rows and columns.
	 * 
	 * @param None
	 * @return None
	 */
	public void rotateClockwiseFilter() {
	    int height = imageArray.length;
	    int width = imageArray[0].length;

	    Pixel[][] rotatedImageArray = new Pixel[width][height];
	    for (int i = 0; i < height; i++) {
	        for (int j = 0; j < width; j++) {
	            rotatedImageArray[j][height - i - 1] = imageArray[i][j];
	        }
	    }
	    imageArray = rotatedImageArray;
	}


	/**
	 * Applies a custom filter to the image, modifying the RGB values of each pixel
	 * based on its position in the image.
	 * 
	 * In this filter, the image will be flip horizontally. 
	 * 
	 * @param None
	 * @return None
	 */
	public void customFilter() {
		 int height = imageArray.length;
		    int width = imageArray[0].length;

		    for (int i = 0; i < height; i++) {
		        for (int j = 0; j < width / 2; j++) {
		            Pixel newPixel = imageArray[i][j];
		            imageArray[i][j] = imageArray[i][width - j - 1];
		            imageArray[i][width - j - 1] = newPixel;
		        }
		    }
		}
}