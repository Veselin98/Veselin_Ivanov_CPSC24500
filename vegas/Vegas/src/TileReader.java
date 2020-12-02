import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

	/**
	 * reads a saved file of the game from the user's machine and loads it in Jpanel
	 */
public class TileReader {
	public ArrayList<Tile> readFromText(String fname) {
		File f = new File(fname);
		return readFromText(f);
	}
	/**
	 * reads a choosen .txt file from machine
	 */
	public ArrayList<Tile> readFromText(File f) {
		try {
			ArrayList<Tile> tilesRead = new ArrayList<Tile>();
			Scanner fsc = new Scanner(f);
			String line;
			String[] parts;
			int color;
			int shape;
			Tile tile;
			while (fsc.hasNextLine()) {
				line = fsc.nextLine();
				parts = line.split(" ");
				color = Integer.parseInt(parts[0]);
				shape = Integer.parseInt(parts[1]);
				tile = new Tile(color,shape);
				tilesRead.add(tile);
			}
			fsc.close();
			return tilesRead;
		} catch (Exception ex) {
			return null;  
						  
		}
	}
	/**
	 * reads a choosen .bin file from machine
	 */
	public ArrayList<Tile> readFromBinary(String fname) {
		File f = new File(fname);
		return readFromBinary(f);
	}
	public ArrayList<Tile> readFromBinary(File f) {
		try {
			ArrayList<Tile> tilesRead;
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			tilesRead = (ArrayList<Tile>)ois.readObject();
			ois.close();
			return tilesRead;
		} catch (Exception ex) {
			return null;
		}
	}
	/**
	 * reads a choosen .xml file from machine
	 */
	public ArrayList<Tile> readFromXML(String fname) {
		File f = new File(fname);
		return readFromXML(f);
	}
	public ArrayList<Tile> readFromXML(File f) {
		try {
			ArrayList<Tile> tilesRead;
			XMLDecoder dec = new XMLDecoder(
					new BufferedInputStream(new FileInputStream(f)));
			tilesRead = (ArrayList<Tile>)dec.readObject();
			dec.close();
			return tilesRead;
		} catch (Exception ex) {
			return null;
		}
	}
	public ArrayList<Tile> read(String fname) {
		File f = new File(fname);
		return read(f);
	}
	/**
	 * depending on the file type choosen to read, this functions chooses the right function to run
	 */
	public ArrayList<Tile> read(File f) {
		try {
			String fname = f.getName().toUpperCase();
			if (fname.endsWith(".TXT")) {
				return readFromText(f);
			} else if (fname.endsWith(".BIN")) {
				return readFromBinary(f);
			} else if (fname.endsWith(".XML")) {
				return readFromXML(f);
			} else {
				return null;  
			}
		} catch (Exception ex) {
			return null;
		}
	}
}
