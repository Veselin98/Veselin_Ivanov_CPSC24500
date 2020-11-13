import java.util.Random;

public class Tile {
    private int tileColor;
	private int tileShape;
	public int getTileShape() {
		return tileShape;
	}
	public int getTileColor() {
		return tileColor;
	}
	public void setTileShape(int shape) {
        if (shape >= 1) {
			this.tileShape = 1;//square
		} else {
			this.tileShape = 0;//circle
		}
    }

	public void setTileColor(int color) {
		if (color == 0) {
			this.tileColor = 0;
		} else if(color == 1){
			this.tileColor = 1;
		} else if(color == 2){
			this.tileColor = 2;
		} else if(color == 3){
			this.tileColor = 3;
		} else if(color == 4){
			this.tileColor = 4;
		}
	}
	public Tile() {
        Random rand = new Random();
        this.tileShape = rand.nextInt(2);
        this.tileColor = rand.nextInt(5);
    }
    public void setORide(){
        Random rand = new Random();
        this.tileShape = rand.nextInt(2);
        this.tileColor = rand.nextInt(5);
    } 
	public Tile(int s, int c) {
		setTileShape(s);
		setTileColor(c);
	}
	@Override
	public String toString() {
		return String.format("%d %d",tileShape,tileColor);
	}
}

