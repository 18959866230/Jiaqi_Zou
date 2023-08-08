package assign11;

import java.awt.Color;
import java.awt.Graphics;

/**
 * this is a subclass called CropRectangle extend from the Shape class, aim to create the rectangle when the user do the selection.
 * It has a constructor with 5 parameters and also one method overridden. 
 * @author Jiaqi Zou/ Apr 23
 *
 */
public class CropRectangle extends Shape {
	
	/**
	 * this is a constructor of CropRectangle class that it has 5 parameters. 
	 * @param positionX
	 * @param positionY
	 * @param sizeX
	 * @param sizeY
	 * @param color
	 */
	public CropRectangle(int positionX, int positionY, int sizeX, int sizeY, Color color) {
		super(positionX, positionY, sizeX, sizeY, color);
	}

	/**
	 * this is a method extend from Shape class and it is overridden to set the color and give the size of the rectangle. 
	 */
	public void paintMe(Graphics g) {
		super.paintMe(g);
		g.setColor(new Color(105, 105, 105, 125)); 
		g.fillRect(this.getPositionX(), this.getPositionY(), this.getSizeX(), this.getSizeY());
	}
}