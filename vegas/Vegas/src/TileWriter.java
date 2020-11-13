import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class TileWriter {
	public boolean tileToText(String fname, ArrayList<Tile> tiles) {
		File fil = new File(fname);
		return tileToText(fil,tiles);
	}
	public boolean tileToText(File fil, ArrayList<Tile> tiles) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fil)));
			for (Tile tile : tiles) {
				pw.println(tile);
			}
			pw.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;

		}
	}
	public boolean tileToBinary(String fname, ArrayList<Tile> tiles) {
		File fil = new File(fname);
		return tileToBinary(fil,tiles);
	}
	public boolean tileToBinary(File fil, ArrayList<Tile> tiles) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fil));
			oos.writeObject(tiles);
			oos.close();
			return true; // success
		} catch (Exception ex) {
			return false;
		}
	}
	public boolean tileToXML(String fname, ArrayList<Tile> tiles) {
		File fil = new File(fname);
		return tileToXML(fil,tiles);
	}
	public boolean tileToXML(File fil, ArrayList<Tile> tiles) {
		try {
			XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fil)));
			enc.writeObject(tiles);
			enc.close();			
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	public boolean write(String fname, ArrayList<Tile> tiles) {
		File fil = new File(fname);
		return write(fil,tiles);
	}

	public boolean write(File fil, ArrayList<Tile> tiles) {
		String fname = fil.getName().toUpperCase();
		if (fname.endsWith(".TXT")) {
			return tileToText(fil,tiles);
		}
		if (fname.endsWith(".BIN")) {
			return tileToBinary(fil,tiles);
		}
		if (fname.endsWith(".XML")) {
			return tileToXML(fil,tiles);
		}
		return false;  // invalid or unrecognized file type
	}
}


