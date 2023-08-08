package assign11;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/**
 * This class represents a GUI component for displaying an image.
 * 
 * @author Prof. Martin and Jiaqi Zou
 * @version 2023/ Apr 23
 */
public class ImagePanel extends JPanel {

	private BufferedImage bufferedImg;
	private int startX, startY, endX, endY;
	private boolean isDragging;
	private CropRectangle cropRectangle;
	private ImageProcessorFrame imageProcessorFrame;

	/**
	 * Constructs an ImagePanel with the given Image and ImageProcessorFrame objects.
	 * Initializes the panel with the image data and adds mouse listeners for cropping functionality.
	 *
	 * @param img                 the Image object to be displayed on the panel
	 * @param imageProcessorFrame the ImageProcessorFrame object to which this ImagePanel is associated
	 */
	public ImagePanel(Image img, ImageProcessorFrame imageProcessorFrame) {
		this.imageProcessorFrame = imageProcessorFrame;
		int rowCount = img.getNumberOfRows();
		int colCount = img.getNumberOfColumns();
		this.bufferedImg = new BufferedImage(colCount, rowCount, BufferedImage.TYPE_INT_RGB);

		for (int i = 0; i < rowCount; i++)
			for (int j = 0; j < colCount; j++)
				this.bufferedImg.setRGB(j, i, img.getPixel(i, j).getPackedRGB());

		this.setPreferredSize(new Dimension(colCount, rowCount));

		MouseAdapter adapter = new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				endX = e.getX();
				endY = e.getY();
				int width = Math.abs(endX - startX);
				int height = Math.abs(endY - startY);
				int x = Math.min(startX, endX);
				int y = Math.min(startY, endY);
				cropRectangle = new CropRectangle(x, y, width, height, new Color(105, 105, 105, 125));
				repaint();
				imageProcessorFrame.updateFilterMenuItems(imageProcessorFrame.getFiltersMenu());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				startX = e.getX();
				startY = e.getY();
				isDragging = true;

				imageProcessorFrame.updateFilterMenuItems(imageProcessorFrame.getFiltersMenu());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				isDragging = false;
				if (imageProcessorFrame != null) {
					imageProcessorFrame.updateFilterMenuItems(imageProcessorFrame.getFiltersMenu());
				}
			}

		};
		addMouseListener(adapter);
		addMouseMotionListener(adapter);

	}

	
	/**
	 * Constructs an ImagePanel with a reference to the specified ImageProcessorFrame.
	 *
	 * @param imageProcessorFrame the ImageProcessorFrame object to which this ImagePanel is associated
	 */
	public ImagePanel(ImageProcessorFrame imageProcessorFrame) {
		this.imageProcessorFrame = imageProcessorFrame;
	}

	/**
	 * This method is called by the system when a component needs to be painted.
	 * Which can be at one of three times: --when the component first appears --when
	 * the size of the component changes (including resizing by the user) --when
	 * repaint() is called
	 * 
	 * Partially overrides the paintComponent method of JPanel.
	 * 
	 * @param g -- graphics context onto which we can draw
	 */

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (this.bufferedImg != null) {
			g.drawImage(this.bufferedImg, 0, 0, this);
			if (isDragging && cropRectangle != null) {
				cropRectangle.paintMe(g);
			}
		}
	}

	private static final long serialVersionUID = 1L;

	/**
	 * Returns the filtered image currently displayed by the ImagePanel.
	 * 
	 * @return a BufferedImage representing the filtered image, or null if no image
	 *         is currently displayed
	 */
	public BufferedImage getFilteredImage() {
		return bufferedImg;
	}

	/**
	 * Sets a new image to be displayed by the ImagePanel and updates the
	 * component's size accordingly.
	 *
	 * @param newImage the BufferedImage to be displayed by the ImagePanel
	 */
	public void setImage(BufferedImage newImage) {
		this.bufferedImg = newImage;
		this.setPreferredSize(new Dimension(newImage.getWidth(), newImage.getHeight()));
		this.repaint();
	}

	/**
	 * Sets the current image to the specified Image object.
	 *
	 * @param image the new Image object to replace the current image
	 */
	public void setImage(Image image) {
		setImage(image.toBufferedImage());
	}

	/**
	 * Checks if the user is currently dragging the mouse on the image.
	 *
	 * @return true if the user is dragging, false otherwise
	 */
	public boolean isDragging() {
		return isDragging;
	}

	/**
	 * Sets the dragging state of the user's interaction with the image.
	 *
	 * @param isDragging a boolean indicating whether the user is currently dragging the mouse on the image
	 */
	public void setDragging(boolean isDragging) {
		this.isDragging = isDragging;
	}

	/**
	 * Retrieves the current CropRectangle object representing the crop region.
	 *
	 * @return the current CropRectangle object
	 */
	public CropRectangle getCropRectangle() {
		return cropRectangle;
	}

	/**
	 * Sets the current CropRectangle object representing the crop region.
	 *
	 * @param cropRectangle the new CropRectangle object to replace the current crop region
	 */
	public void setCropRectangle(CropRectangle cropRectangle) {
		this.cropRectangle = cropRectangle;

	}

}