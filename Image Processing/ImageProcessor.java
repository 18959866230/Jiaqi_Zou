package assign07;

import java.io.IOException;
import java.util.Scanner;

/**
 * this class is to Accesses the command-line arguments, reading from the file whose name is the first command-line argument
 * Display a menu of image filter options. Read the user's selection from the console.
 * @author Jiaqi Zou
 * @version 2023/ Mar 15
 *
 */
public class ImageProcessor {
	
	/**
	 * this main method is aim to reading from the file whose name is the first command-line argument.
	 * Display a menu of image filter options (see reference output below).  
	 * Read the user's selection from the console
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		if (args.length < 2) {
			System.out.println("Error: Must provide input and output file names.");
			System.exit(1);
		}

		String inputFile = args[0];
		String outputFile = args[1];
		Image image = new Image(inputFile);
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Select an option:");
			System.out.println("  1 -- Swap red and blue");
			System.out.println("  2 -- Convert to black and white");
			System.out.println("  3 -- Rotate clockwise");
			System.out.println("  4 -- Custom filter");
			System.out.println("  5 -- Write image to file and quit");

			int choice = scanner.nextInt();
			scanner.nextLine();

			if (choice < 1 || choice > 5) {
				System.out.println("Error: Invalid choice. Please choose an option between 1 and 5.");
				continue;
			}

			if (choice == 1) {
				image.redBlueSwapFilter();
			} else if (choice == 2) {
				image.blackAndWhiteFilter();
			} else if (choice == 3) {
				image.rotateClockwiseFilter();
			} else if (choice == 4) {
				image.customFilter();
			} else {
				image.writeImage(outputFile);
				System.out.println("Filtered image written to " + outputFile);
				break;
			}

			System.out.println("... applying " + image + " image filter");

			System.out.println("To cumulatively apply another filter, select 1-4. "
					+ "To see the results of the previous filter(s), select 5.");

		}
		scanner.close();
	}
}
