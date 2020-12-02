import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
public class TilePanel extends JPanel implements MouseListener {
	/**
	 *creates the functions that are called by the SlotMachineFrame
	 */
	private String file = "tiles.txt";
	public void setSelectedFile(String file){
		this.file = file;
	}
	public String getSelectedFile(){
		return file;
	}
	private static final long serialVersionUID = 1L;
	private ArrayList<Tile> tiles;
	private Random rnd;
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {
		int whichTile = e.getX()/(this.getWidth()/4);
		Tile tile = tiles.get(whichTile);
		tile.setRandomly(rnd);
		repaint();
	}
	/**
	 *setAmount function
	 */
	private double amount = 5;
	public void setAmount(double amount){
		this.amount =  amount;
	}
	/**
	 *getAmount function
	 */
	public double getAmount(){
		return amount;
	}
	/**
	 * draws the tiles
	 */
	public TilePanel() {
		tiles = new ArrayList<Tile>();
		Tile tile;
		rnd = new Random();
		for (int i = 0; i < 4; i++) {
			tile = new Tile();
			tile.setRandomly(rnd);
			tiles.add(tile);
		}
		addMouseListener(this);
	}
	/**
	 *get tiles function
	 */
	public ArrayList<Tile> getTiles() {
		return tiles;
	}
	/**
	 *set tiles function
	 */
	public void setTiles(ArrayList<Tile> tiles) {
		this.tiles = tiles;
	}
	@Override
	/**
	 *fills in the tiles with color
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int cellWidth = this.getWidth() / 4;
		int tileSize = 4*cellWidth/5;
		int shape;
		Color color;
		Tile tile;
		for (int i = 0; i < tiles.size(); i++) {
			tile = tiles.get(i);
			shape = tile.getShape();
			color = tile.getActualColor();
			g.setColor(color);
			if (shape == 0) {
				g.fillOval(i*cellWidth + cellWidth/10, cellWidth/10, tileSize, tileSize); 
			} else if (shape == 1) {
				g.fillRect(i*cellWidth + cellWidth/10, cellWidth/10, tileSize, tileSize);
			} 
		}
	}
	/**
	 * creates a new tile
	 */
	public void newTile(){
		tiles = new ArrayList<Tile>();
		Tile tile;
		rnd = new Random();
		for (int i = 0; i < 4; i++) {
			tile = new Tile();
			tile.setRandomly(rnd);
			tiles.add(tile);
		}
		repaint();
	}
	/**
	 *resets the amount function
	 */
	public void resetAmount(){
		amount = 5;
	}
	/**
	 *checks the tiles and colors to determine winning and loosing plus calculates
	 * the amount the user is betting, winning, or loosing.
	 */
	public void tileChecker(int b){
		int shape ; // shape
		Color color; // color
		Tile tile; // tile holder
		double winCS = 0; //color winner
		int winColor = 0; //shape winner
		int circle = 0; // shape counter circle
		int square = 0;// shape counter square
		int redColor = 0;// color counter red
		int yellowColor = 0;// color counter yellow
		int greenColor = 0;// color counter green
		int orangeColor = 0;// color counter orange
		int blueColor = 0;// color counter blue
		for (int i = 0; i < tiles.size(); i++) {
			tile = tiles.get(i);
			shape = tile.getShape();
			color = tile.getActualColor();
			if(shape == 0 && color == Color.YELLOW){
				circle += 1;
				yellowColor += 1;
			} else if ( shape == 0 && color == Color.GREEN){
				circle +=1;
				greenColor += 2;
			}else if(shape == 0 && color == Color.ORANGE){
				circle += 1;
				orangeColor += 1;
			}else if(shape == 0 && color == Color.RED){
				circle += 1;
				redColor += 1;
			}else if(shape == 0 && color == Color.BLUE){
				circle += 1;
				blueColor += 1;
			} else if(shape == 1 && color == Color.YELLOW){
				square += 1;
				yellowColor += 1;
			} else if(shape == 1 && color == Color.GREEN){
				square += 1;
				greenColor += 1;
			} else if(shape == 1 && color == Color.ORANGE){
				square += 1;
				orangeColor += 1;
			} else if(shape == 1 && color == Color.RED){
				square += 1;
				redColor += 1;
			} else if(shape == 1 && color == Color.BLUE){
				square += 1;
				blueColor += 1;
			}
		}
		if(circle == 4 && yellowColor == 4){
			winCS += 1;
		}else if(circle == 4 && greenColor == 4){
			winCS += 1;
		}else if(circle == 4 && orangeColor == 4){
			winCS += 1;
		}else if(circle == 4 && redColor == 4){
			winCS += 1;
		}else if(circle == 4 && blueColor == 4){
			winCS += 1;
		}
		else if(square == 4 && yellowColor == 4){
			winCS +=1;
		}else if(square == 4 && greenColor == 4){
			winCS += 1;
		}else if(square == 4 && orangeColor == 4){
			winCS += 1;
		}else if(square == 4 && redColor == 4){
			winCS += 1;
		}else if(square == 4 && blueColor ==4){
			winCS += 1;
		}else{
			winCS *= 0;
		}	
		if(yellowColor == 4){
			winColor +=1;
		}else if(greenColor == 4){
			winColor +=1;
		}else if(orangeColor ==4){
			winColor +=1;
		}else if(redColor ==4){
			winColor +=1;
		}else if(blueColor ==4){
			winColor +=1;
		}else{
			winColor *= 0;
		}

		if(b == 2){ //max
			if(winCS == 1){
				amount *= 100;
			}else if(winColor == 1 && winCS != 1){
				amount *= 25;
			}else{//lost
				amount *= 0;
			}
		}else if(b == 1){ //mid
			if(winCS == 1){
				amount *= 50;
			}else if(winColor == 1 && winCS != 1){
				amount *= 10;
			}else{ //lost
				amount *= .5;
			}
		}else if(b == 0){ // min
			if(winCS == 1){
				amount *= 10;
			}else if(winColor == 1 && winCS != 1){
				amount *= 5;
			}else{
				amount *= .9; //lost
			}
		}else{
			amount *=0;
		}
		//repaint();
	}
	
}