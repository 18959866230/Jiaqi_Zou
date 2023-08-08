
package assign11;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * the ImageProcessorFrame is a subclass of JFrame and it also implements
 * interface ActionListener. It has four private instances and it also has one
 * constructor and one method actionPerformed that is overridden. This class is
 * aim to create a GUI application that it could open the certain format file we
 * selected and apply the filtered we want to this file and save it on computer.
 * 
 * @author Jiaqi Zou
 * @version 2023/Apr 23
 */
public class ImageProcessorFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JFileChooser fileChooser;
	private JMenuItem openMenuItem, saveMenuItem;
	private ImagePanel imagePanel;
	private Image currentImage;
	private JSlider brightnessSlider;
	private JMenuItem filter1, filter2, filter3, filter4, filter5, filter6, filter7;
	private JMenu filtersMenu;

	/**
	 * this is a constructor that it create the GUI frame first, and give the frame
	 * two main menu, File and Filter under the menu File there are two optional
	 * menu, open file and save filtered file, the saving option is only available
	 * when the image exist in the frame. and under the menu Filters, there are four
	 * optional menus that apply the different filters. And each option has a tip
	 * tool reminder.
	 */
	public ImageProcessorFrame() {
		setTitle("Image Processor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		openMenuItem = new JMenuItem("Open Image");
		openMenuItem.addActionListener(this);
		fileMenu.add(openMenuItem);

		saveMenuItem = new JMenuItem("Save Filtered Image");
		saveMenuItem.addActionListener(this);
		fileMenu.add(saveMenuItem);

		filtersMenu = new JMenu("Filters");
		menuBar.add(filtersMenu);

		filter1 = new JMenuItem("red-blue Swap filter");
		filter1.setToolTipText("Swaps the red and blue color components of all pixels in the image");
		filter1.addActionListener(this);
		filtersMenu.add(filter1);

		filter2 = new JMenuItem("black-white filter");
		filter2.setToolTipText(
				"Converts the image to black and white by setting each pixel to the average of the original values");
		filter2.addActionListener(this);
		filtersMenu.add(filter2);

		filter3 = new JMenuItem("rotate clockwise filter");
		filter3.setToolTipText("Rotates the image 90 degrees clockwise");
		filter3.addActionListener(this);
		filtersMenu.add(filter3);

		filter4 = new JMenuItem("custom filter");
		filter4.setToolTipText("Image will be flip horizontally");
		filter4.addActionListener(this);
		filtersMenu.add(filter4);

		filter5 = new JMenuItem("brightness filter");
		filter5.setToolTipText("Adjust the brightness of the image using the slider");
		filter5.addActionListener(this);
		filtersMenu.add(filter5);

		brightnessSlider = new JSlider(-200, 200, 0);
		brightnessSlider.setToolTipText("Adjust the brightness of the image");
		brightnessSlider.setEnabled(false);
		add(brightnessSlider, BorderLayout.SOUTH);
		brightnessSlider.setVisible(false);

		filter6 = new JMenuItem("Crop Filter");
		filter6.setToolTipText("Crop the image to a rectangular region");
		filter6.addActionListener(this);
		filter6.setEnabled(false);
		filtersMenu.add(filter6);

		filter7 = new JMenuItem("old movie filter");
		filter7.setToolTipText("Apply a sepia tone to the image");
		filter7.addActionListener(this);
		filtersMenu.add(filter7);

		updateFilterMenuItems(getFiltersMenu());

		pack();
		setLocationRelativeTo(null);
	}

	/**
	 * this is a overridden method extends from the JFrame. It handles below events
	 * to run the whole GUI application: 1. it check the menu File is in function
	 * and if so, it would allow the user to open the certain format file from the
	 * computer in the application. 2. it check if the saving option under the file
	 * menu is in function, if so it would allow the user to save this filtered
	 * image by showing the windows dialog to update the saving option. 3. it check
	 * if the option under the menu filter is in function, if so it would allow user
	 * to switch the four filters freely. But if the GUI frame is empty, the filter
	 * wont' work because of the input is null. All these checking have the
	 * exception case that if user events cannot be recognized or there is not
	 * accepted format files or matched filter don't have correct implements, the
	 * GUI would display the error message on the screen to show the current error.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == openMenuItem) {
			fileChooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "jpeg", "png", "bmp", "gif");
			fileChooser.setFileFilter(filter);

			int result = fileChooser.showOpenDialog(this);
			if (result == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				try {
					BufferedImage bufferedImage = ImageIO.read(selectedFile);
					currentImage = new Image(bufferedImage);
					imagePanel = new ImagePanel(currentImage, this);
					getContentPane().add(imagePanel, BorderLayout.CENTER);
					pack();
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(this, "Error loading image", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}

		else if (e.getSource() == saveMenuItem) {
			fileChooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG Image", "jpg");
			fileChooser.setFileFilter(filter);

			int result = fileChooser.showSaveDialog(this);
			if (result == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				try {
					ImageIO.write(imagePanel.getFilteredImage(), "jpg", selectedFile);
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(this, "Error saving image", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} else if (result == JFileChooser.CANCEL_OPTION) {
				JOptionPane.showMessageDialog(this, "File save cancelled", "Cancelled",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}

		if (e.getSource() instanceof JMenuItem) {
			JMenuItem source = (JMenuItem) e.getSource();
			String filterName = source.getText();
			BufferedImage filteredImage = imagePanel.getFilteredImage();
			Image image = new Image(filteredImage);

			// Disable brightness slider by default
			setBrightnessSliderVisible(false);
			brightnessSlider.setEnabled(false);

			if (filterName.equals("Crop Filter")) {
				applyCropFilter();
			} else {
				switch (filterName) {
				case "red-blue Swap filter":
					image.redBlueSwapFilter();
					break;
				case "black-white filter":
					image.blackAndWhiteFilter();
					break;
				case "rotate clockwise filter":
					image.rotateClockwiseFilter();
					break;
				case "custom filter":
					image.customFilter();
					break;
				case "brightness filter":
					setBrightnessSliderVisible(true);
					brightnessSlider.setEnabled(true);
					brightnessSlider.addChangeListener(sliderEvent -> {
						Image imageCopy = new Image(currentImage.toBufferedImage());
						imageCopy.brightnessFilter(brightnessSlider.getValue());
						imagePanel.setImage(imageCopy.toBufferedImage());
					});
					break;
				case "old movie filter":
					image.oldMovieFilter();
					break;
				}
				BufferedImage newFilteredImage = image.toBufferedImage();
				imagePanel.setImage(newFilteredImage);
			}
		}
	}

	/**
	 * Sets the visibility of the brightness slider.
	 *
	 * @param visible true if the brightness slider should be visible, false otherwise
	 */
	public void setBrightnessSliderVisible(boolean visible) {
		brightnessSlider.setVisible(visible);
	}

	
	/**
	 * Updates the enabled state of the filter menu items based on the crop state.
	 *
	 * @param filtersMenu the JMenu containing the filter menu items
	 */
	public void updateFilterMenuItems(JMenu filtersMenu) {
		boolean cropEnable = imagePanel != null && imagePanel.getCropRectangle() != null;

		for (Component menuItem : filtersMenu.getMenuComponents()) {
			menuItem.setEnabled(!cropEnable);
		}
		filter6.setEnabled(cropEnable);
	}

	
	/**
	 * Returns the filters menu.
	 *
	 * @return the JMenu containing the filter menu items
	 */
	public JMenu getFiltersMenu() {
		return filtersMenu;
	}

	
	/**
	 * Applies the crop filter to the image in the ImagePanel based on the crop rectangle.
	 * and update the image to display on the frame correctly. 
	 */
	public void applyCropFilter() {
		CropRectangle cropRect = imagePanel.getCropRectangle();
		if (cropRect != null) {
			int x = cropRect.getPositionX();
			int y = cropRect.getPositionY();
			int width = cropRect.getSizeX();
			int height = cropRect.getSizeY();

			BufferedImage originalImage = imagePanel.getFilteredImage();
			BufferedImage croppedImage = originalImage.getSubimage(x, y, width, height);

			imagePanel.setImage(croppedImage);

			imagePanel.setCropRectangle(null);
			imagePanel.setDragging(false);

			pack();
		}
	}

}
