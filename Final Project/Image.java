package assign11;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

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
 * @version 2023/Apr 23
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

	// New constructor that accepts a BufferedImage
	public Image(BufferedImage bufferedImage) {
		imageArray = new Pixel[bufferedImage.getHeight()][bufferedImage.getWidth()];
		for (int i = 0; i < imageArray.length; i++) {
			for (int j = 0; j < imageArray[0].length; j++) {
				int rgb = bufferedImage.getRGB(j, i);
				imageArray[i][j] = new Pixel((rgb >> 16) & 255, (rgb >> 8) & 255, rgb & 255);
			}
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
	

	/**
	 * Sets the specified Pixel object at the given x, y coordinates in the image array.
	 *
	 * @param x     the x-coordinate of the pixel
	 * @param y     the y-coordinate of the pixel
	 * @param pixel the Pixel object to set at the specified coordinates
	 */
	public void setPixel(int x, int y, Pixel pixel) {
		this.imageArray[x][y] = pixel;
	}

	
	/**
	 * Adjusts the brightness of the image by the given value.
	 * Positive values will increase the brightness, while negative values will decrease it.
	 *
	 * @param value the amount to adjust the brightness by
	 */
	public void brightnessFilter(int value) {
		int height = imageArray.length;
		int width = imageArray[0].length;

		for (int x = 0; x < height; x++) {
			for (int y = 0; y < width; y++) {
				Pixel pixel = getPixel(x, y);
				int newRed = Math.min(Math.max(pixel.getRedAmount() + value, 0), 255);
				int newGreen = Math.min(Math.max(pixel.getGreenAmount() + value, 0), 255);
				int newBlue = Math.min(Math.max(pixel.getBlueAmount() + value, 0), 255);
				setPixel(x, y, new Pixel(newRed, newGreen, newBlue));
			}
		}
	}

	
	/**
	 * Crops the image to the specified rectangular region with coordinates (x1, y1) and (x2, y2).
	 * The resulting image will have dimensions equal to the width and height of the specified region.
	 *
	 * @param x1 the x-coordinate of the first corner of the region to be cropped
	 * @param y1 the y-coordinate of the first corner of the region to be cropped
	 * @param x2 the x-coordinate of the second corner of the region to be cropped
	 * @param y2 the y-coordinate of the second corner of the region to be cropped
	 * @return a new Image object containing the cropped portion of the original image
	 */
	public Image crop(int x1, int y1, int x2, int y2) {
		int width = x2 - x1;
		int height = y2 - y1;
		BufferedImage croppedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = croppedImage.getGraphics();
		g.drawImage(croppedImage, 0, 0, width, height, x1, y1, x2, y2, null);
		g.dispose();
		return new Image(croppedImage);
	}

	
	/**
	 * Applies a old movie filter to the image, giving it a warm, brownish tone.
	 * This method modifies the image's pixels directly, without creating a new image.
	 */
	public void oldMovieFilter() {
	    int height = imageArray.length;
	    int width = imageArray[0].length;

	    Random random = new Random();

	    for (int y = 0; y < height; y++) {
	        for (int x = 0; x < width; x++) {
	            Pixel pixel = getPixel(y, x);
	            int r = pixel.getRedAmount();
	            int g = pixel.getGreenAmount();
	            int b = pixel.getBlueAmount();

	            // add random noise to each color channel
	            int tr = Math.min(255, Math.max(0, r + random.nextInt(51) - 25));
	            int tg = Math.min(255, Math.max(0, g + random.nextInt(51) - 25));
	            int tb = Math.min(255, Math.max(0, b + random.nextInt(51) - 25));

	            int sr = (int) (0.393 * tr + 0.769 * tg + 0.189 * tb);
	            int sg = (int) (0.349 * tr + 0.686 * tg + 0.168 * tb);
	            int sb = (int) (0.272 * tr + 0.534 * tg + 0.131 * tb);

	            sr = Math.min(255, Math.max(0, sr));
	            sg = Math.min(255, Math.max(0, sg));
	            sb = Math.min(255, Math.max(0, sb));

	            pixel.setRedAmount(sr);
	            pixel.setGreenAmount(sg);
	            pixel.setBlueAmount(sb);
	        }
	    }
	}




	/*
	 * this method is aim to convert the image format from the image to buffered
	 * image.
	 */
	public BufferedImage toBufferedImage() {
		int height = imageArray.length;
		int width = imageArray[0].length;
		BufferedImage output = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				output.setRGB(j, i, imageArray[i][j].getPackedRGB());
			}
		}

		return output;
	}

	/**
	 * this method is aim to get the number of rows in the image so that it can
	 * return the result we want and display the image on the screen.
	 * 
	 * @return this.imageArray.length
	 */
	public int getNumberOfRows() {
		return this.imageArray.length;
	}

	/**
	 * this method is aim to get the number of columns in the image so that it can
	 * return the result we want and display the image on the screen.
	 * 
	 * @return this.imageArray[0].length
	 */
	public int getNumberOfColumns() {
		if (this.imageArray.length == 0)
			return 0;
		return this.imageArray[0].length;
	}
}