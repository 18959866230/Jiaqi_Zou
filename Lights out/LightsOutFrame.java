package assign09;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.BooleanSupplier;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * this is a class LightsOutFrame extends JFrame and implements ActionListener
 * that four private instance variables and one constructor, also with four
 * methods.
 * 
 * @author Jiaqi Zou
 * @version 2023/ Apr 4
 *
 */
public class LightsOutFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private LightsOutButton[][] lights;
	private JButton randomizeButton;
	private JButton manualSetupButton;
	private boolean manualSetupMode;

	/**
	 * this is a constructor that take no parameters call
	 * setDefaultCloseOperation(EXIT_ON_CLOSE) to ensure the GUI closes when the red
	 * X is clicked create a JPanelLinks to an external site. container organized
	 * using GridLayoutLinks to an external site. add each of the twenty-five
	 * lights, organized in a 5x5 grid, to the panel with GridLayout create another
	 * JPanel with a reasonable layout add a button for randomly setting whether
	 * each light is on or off to the second pane add a button for allowing manual
	 * setup of the puzzle to the second panel create a third JPanel with a
	 * reasonable layout and add the first two panels set the content pane of "this"
	 * frame to be the third panel add "this" action listener to each button call
	 * randomize (see next bullet)
	 */
	public LightsOutFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel lightsPanel = new JPanel(new GridLayout(5, 5));
		lights = new LightsOutButton[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				lights[i][j] = new LightsOutButton(i, j);
				lightsPanel.add((lights[i][j]));
				lights[i][j].addActionListener(this);
			}
		}
		JPanel buttonPanel = new JPanel();
		randomizeButton = new JButton("Randomize");
		randomizeButton.addActionListener(this);
		manualSetupButton = new JButton("Enter Manual Setup");
		manualSetupButton.addActionListener(this);
		buttonPanel.add(randomizeButton);
		buttonPanel.add(manualSetupButton);

		JPanel contentPanel = new JPanel(new GridLayout(2, 1));
		contentPanel.add(lightsPanel);
		contentPanel.add(buttonPanel);

		setContentPane(contentPanel);
		randomize();

		setSize(500, 500);
		setVisible(true);
	}

	/**
	 * this is a method that it should randomly toggle lights in the 5x5 grid
	 * 
	 * @param none
	 * @return none
	 */
	public void randomize() {
		for (int i = 0; i < 10; i++) {
			int row = (int) (Math.random() * 5);
			int col = (int) (Math.random() * 5);
			toggleLight(row, col);
		}
	}

	/**
	 * this is a method should return a value to indicate whether the light at the
	 * given row and column indexes is on. If either the given row or column index
	 * is out of bounds, this method should thrown an IndexOutOfBoundsException.
	 * 
	 * @param row
	 * @param column
	 * @return lights[row][column].isOn()
	 */
	public boolean lightIsOn(int row, int column) {
		if (row < 0 || row >= 5 || column < 0 || column >= 5) {
			throw new IndexOutOfBoundsException();

		}
		return lights[row][column].isOn();
	}

	/**
	 * this is a method should toggle the light at the given row and column indexes,
	 * as well as the four neighbors of that light. If either the given row or
	 * column index is out of bounds, this method should thrown an
	 * IndexOutOfBoundsException.
	 * 
	 * @param row
	 * @param column
	 * @return none
	 */
	public void toggleLight(int row, int column) {
		if (row < 0 || row >= 5 || column < 0 || column >= 5) {
			throw new IndexOutOfBoundsException();

		}
		lights[row][column].toggle();
		if (row > 0) {
			lights[row - 1][column].toggle();

		}
		if (row < 4) {
			lights[row + 1][column].toggle();

		}
		if (column > 0) {
			lights[row][column - 1].toggle();

		}
		if (column < 4) {
			lights[row][column + 1].toggle();
		}
	}

	/**
	 * This is a method have following functions: If the source of the event is a
	 * LightsOutButton and the puzzle is in manual setup mode, toggle the light of
	 * that individual button. If the source of the event is a LightsOutButton and
	 * the puzzle is not in manual setup mode, toggle the light of that button in
	 * addition to the four neighbors of that button. If the source of the event is
	 * the "Randomize" button, call the randomize method. If the source of the event
	 * is the manual setup button and the puzzle is in manual setup mode, change the
	 * text of the button to "Enter Manual Setup" and update the instance variable
	 * for keeping track of whether the puzzle is in manual setup mode. If the
	 * source of the event is the manual setup button and the puzzle is not in
	 * manual setup mode, change the text of the button to "Exit Manual Setup" and
	 * update the instance variable for keeping track of whether the puzzle is in
	 * manual setup mode. When the puzzle is solved (i.e., all lights are off), this
	 * must be reported in a way that is easy to see and uses the GUI.
	 * 
	 */
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source instanceof LightsOutButton) {
			LightsOutButton button = (LightsOutButton) source;
			if (manualSetupMode) {
				button.toggle();
			} else {
				toggleLight(button.getRow(), button.getColumn());
			}

			if (!manualSetupMode) {
				boolean allLightsOff = true;
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {
						if (lights[i][j].isOn()) {
							allLightsOff = false;
							break;
						}
					}
				}
				if (allLightsOff) {
					JOptionPane.showMessageDialog(this, "Congratulations, you win!");
				}
			}

		} else if (source == randomizeButton) {
			randomize();
		} else if (source == manualSetupButton) {
			if (manualSetupMode) {
				manualSetupButton.setText("Enter Manual Setup");
			} else {
				manualSetupButton.setText("Exit Manual Setup");
			}
			manualSetupMode = !manualSetupMode;
		}
	}

}
