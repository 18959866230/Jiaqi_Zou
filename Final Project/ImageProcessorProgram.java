package assign11;

/**
 * this is a class aim to run the events we created in the ImageProvessorFrame
 * by a main method.
 * 
 * @author Jiaqi Zou
 * @version 2023/ Apr 23
 *
 */
public class ImageProcessorProgram {
	/**
	 * the main method is aim to creates and launches the GUI. Run the program and
	 * ensure that a frame pops up and displays the image.
	 * 
	 * @param args
	 * @retun void
	 */
	public static void main(String[] args) {
		ImageProcessorFrame frame = new ImageProcessorFrame();
		frame.setVisible(true);
	}
}