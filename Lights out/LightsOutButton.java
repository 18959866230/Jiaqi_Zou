package assign09;

import javax.swing.JButton;

/**
 * the class LightsOutButton extends JButton and the object of this class acts
 * both as one of the lights in the grid and a button that when clicked toggles
 * the light
 * 
 * @author Jiaqi Zou
 * @version 2023/Apr 4
 *
 */
public class LightsOutButton extends JButton {
	private static final long serialVersionUID = 1L;
	private int row;
	private int column;
	private boolean isOn;

	/**
	 * this is a constructor that it has two int type parameters called row and
	 * column.
	 * 
	 * @param row
	 * @param column
	 */
	public LightsOutButton(int row, int column) {
		super();
		this.row = row;
		this.column = column;
		this.isOn = false;

	}

	/**
	 * this is a method should turn on the light on, if it was previously off, and
	 * turn it off, if it was previously on
	 * 
	 * @param none
	 * @return none
	 */

	public void toggle() {
		isOn = !isOn;
		if (isOn) {
			this.setText("ON");
		} else {
			this.setText("OFF");
		}
	}

	/**
	 * this is a method should return the row, it is getter method for the
	 * corresponding instance variable row.
	 * 
	 * @param none
	 * @return none
	 */
	public int getRow() {
		return row;
	}

	/**
	 * this is a method should return the column,it is getter method for the
	 * corresponding instance variable row.
	 * 
	 * @return
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * this is a method should be a getter method for the instance variable keeping
	 * track of whether the light is on
	 * 
	 * @return none
	 * @param none
	 */
	public boolean isOn() {
		return isOn;

	}

}
