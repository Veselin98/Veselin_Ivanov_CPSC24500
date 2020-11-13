import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;


public class TileReader {
		public ArrayList<Tile> readFromText(String fname) {
            File fil = new File(fname);
            return readFromText(fil);
        }
        public ArrayList<Tile> readFromText(File fil) {
            try {
                ArrayList<Tile> result = new ArrayList<Tile>();
                Scanner sc = new Scanner(fil);
                String line;
                String[] parts;
                int tileShape, tileColor;
                Tile tile;
                while (sc.hasNextLine()) {
                    line = sc.nextLine().trim();  // get rid of whitespace at the end
                    if (line.length() > 0) {  // prevent processing a blank line
                        parts = line.split(" ");
                        tileShape = Integer.parseInt(parts[0]);
                        tileColor = Integer.parseInt(parts[1]);
                        tile = new Tile(tileShape, tileColor);
                        result.add(tile);
                    }
                }
                sc.close();
                return result; 
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;  // object equivalent to false 
            }
        }
        public ArrayList<Tile> readFromBinary(String fname) {
            File fil = new File(fname);
            return readFromBinary(fil);
        }
        public ArrayList<Tile> readFromBinary(File fil) {
            try {
                ArrayList<Tile> tilesRead;
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fil));
                tilesRead = (ArrayList<Tile>)ois.readObject();
                ois.close();
                return tilesRead;
            } catch (Exception ex) {
                return null;
            }
        }
        public ArrayList<Tile> readFromXML(File fil){
            try{ 
                  XMLDecoder dec = new XMLDecoder(new BufferedInputStream(new FileInputStream(fil)));
                  ArrayList<Tile> result = (ArrayList<Tile>)(dec.readObject());
                  dec.close();
                  return result;
              }catch(Exception ex){
                  return null;
              }
      }
        public ArrayList<Tile> read(String fname) {
            File fil = new File(fname);
            return read(fil);
        }
        public ArrayList<Tile> read(File fil) {
            String fname = fil.getName().toUpperCase();
            if (fname.endsWith(".TXT")) {
                return readFromText(fil);
            }
            if (fname.endsWith(".BIN")) {
                return readFromBinary(fil);
            }
            if(fname.endsWith(".XML")){
                return readFromXML(fil);
            }
            return null;  // unrecognize file type.
        }
    }

