import java.awt.Color;
import java.io.Serializable;
import java.util.Random;

public class Tile implements Serializable {
	/**
	 *Draws the shapes and colors of tiles 
	 */
	private static final long serialVersionUID = 1L;
	private static final Color[] colors = { Color.YELLOW, Color.GREEN, Color.ORANGE, Color.RED, Color.BLUE };
	private static final String[] colorNames = {"yellow","green","orange","red","blue"};
	private static final String[] shapes = {"circle","square"};
	private int color; //0 - yellow, 1 - green, 2 - orange, 3 - red, 4 - blue
	private int shape; // 0 - circle, 1 - square, 2 - diamond
	public Tile() {
		color = 3;
		shape = 0;
	}
	/**
	 * Tile create function
	 */
	public Tile(int color, int shape) {
		setColor(color);
		setShape(shape);
	}
	/**
	 *get color function
	 */
	public int getColor() {
		return color;
	}
	/**
	 *sets color function
	 */
	public void setColor(int color) {
		if (color < 0) {
			this.color = 0;
		} else if (color > 4) {
			this.color = 4;
		} else {
			this.color = color;
		}
	}
	/**
	 *sets the colors and shapes to random
	 */
	public void setRandomly(Random rnd) {
		color = rnd.nextInt(colors.length);
		shape = rnd.nextInt(shapes.length);
	}
	/**
	 *gets the color of tile function
	 */
	public Color getActualColor() {
		return colors[color];
	}
	/**
	 *get the color name of tile function
	 */
	public String getColorName() {
		return colorNames[color];
	}
	/**
	 *get the shape of tile function
	 */
	public int getShape() {
		return shape; 
	}
	/**
	 *sets the shape of tile function
	 */
	public void setShape(int shape) {
		if (shape < 0) {
			this.shape = 0;
		} else if (shape > 1) {
			this.shape = 1;
		} else {
			this.shape = shape;
		}
	}
	/**
	 *gets the shape of tile and turns it to a string function
	 */
	public String getShapeAsString() {
		return shapes[shape];
	}
	/**
	 * makes the string of tile more fancy function
	 */
	public String toStringFancy() {
		return String.format("%s %s", getColorName(), getShapeAsString());
	}
	/**
	 *turns tile to string function
	 */
	@Override
	public String toString() {
		return String.format("%d %d",color,shape);
	}
	/**
	 *gets the code function
	 */
	public int getCode() {
		return color*10+shape;
	}
}

