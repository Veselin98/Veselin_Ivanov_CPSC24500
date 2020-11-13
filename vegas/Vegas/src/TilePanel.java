import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Color;

class TilePanel extends JPanel implements MouseListener {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String mouseStatus;
    private int left;
    private int top;
    //private ArrayList<Tile> t;
    private ArrayList<Tile> ts;
    private Tile tile1;
    private Tile tile2;
    private Tile tile3;
    private Tile tile4;
    
    
	public void clearTiles() {
		ts.clear();
	}
	public ArrayList<Tile> getTiles() {
		return ts;
	}
	public void setTiles(ArrayList<Tile> ts) {
		this.ts = ts;
	}
	public TilePanel() {
        top = 50;
        tile1 = new Tile();
        tile2 = new Tile();
        tile3 = new Tile();
        tile4 = new Tile();
        ts = new ArrayList<Tile>(4);
        ts.add(tile1);
        ts.add(tile2);
        ts.add(tile3);
        ts.add(tile4);
        
	}
	@Override
	public void paintComponent(Graphics v) {
        super.paintComponent(v);
        int offset = 0;
        for(Tile t : ts){
            if(t.getTileShape() == 0 && t.getTileColor() == 4) {
                v.setColor(Color.RED);
                if (offset == 0) {
                    left = 850;
                    offset += 1;
                } else if(offset == 1){
                    left = 650;
                    offset += 1;
                }else if(offset == 2){
                    left = 300;
                    offset += 1;
                }else if(offset == 3){
                    left = 50;
                    offset += 0;
                }
                v.fillOval(left, top, 100, 100);
		    }else if(t.getTileShape() == 0 && t.getTileColor() == 3) {
                v.setColor(Color.YELLOW);
                if (offset == 0) {
                    left = 850;
                    offset += 1;
                } else if(offset == 1){
                    left = 650;
                    offset += 1;
                }else if(offset == 2){
                    left = 300;
                    offset += 1;
                }else if(offset == 3){
                    left = 50;
                    offset += 0;
                }
                v.fillOval(left, top, 100, 100);

            }else if(t.getTileShape() == 0 && t.getTileColor() == 2) {
                v.setColor(Color.GRAY);
                if (offset == 0) {
                    left = 850;
                    offset += 1;
                } else if(offset == 1){
                    left = 650;
                    offset += 1;
                }else if(offset == 2){
                    left = 300;
                    offset += 1;
                }else if(offset == 3){
                    left = 50;
                    offset += 0;
                }
                v.fillOval(left, top, 100, 100);

            }else if(t.getTileShape() == 0 && t.getTileColor() == 1) {
                v.setColor(Color.MAGENTA);
                if (offset == 0) {
                    left = 850;
                    offset += 1;
                } else if(offset ==1){
                    left = 650;
                    offset += 1;
                }else if(offset ==2){
                    left = 300;
                    offset += 1;
                }else if(offset == 3){
                    left = 50;
                    offset += 0;
                }
                v.fillOval(left, top, 100, 100);
            }else if(t.getTileShape() == 0 && t.getTileColor() == 0) {
                v.setColor(Color.CYAN);
                if (offset == 0) {
                    left = 850;
                    offset += 1;
                } else if(offset == 1){
                    left = 650;
                    offset += 1;
                }else if(offset == 2){
                    left = 300;
                    offset += 1;
                }else if(offset == 3){
                    left = 50;
                    offset += 0;
                }
                v.fillOval(left, top, 100, 100);
            } else if(t.getTileShape() == 1 && t.getTileColor() == 4) {
            v.setColor(Color.RED);
            if (offset == 0) {
                left = 850;
                offset += 1;
            } else if(offset == 1){
                left = 650;
                offset += 1;
            }else if(offset == 2){
                left = 300;
                offset += 1;
            }else if(offset == 3){
                left = 50;
                offset += 0;
            }
            v.fillRect(left, top, 100, 100);
        }else if(t.getTileShape() == 1 && t.getTileColor() == 3) {
            v.setColor(Color.YELLOW);
            if (offset == 0) {
                left = 850;
                offset += 1;
            } else if(offset == 1){
                left = 650;
                offset += 1;
            }else if(offset == 2){
                left = 300;
                offset += 1;
            }else if(offset == 3){
                left = 50;
                offset += 0;
            }
            v.fillOval(left, top, 100, 100);

        }else if(t.getTileShape() == 1 && t.getTileColor() == 2) {
            v.setColor(Color.GRAY);
            if (offset == 0) {
                left = 850;
                offset += 1;
            } else if(offset == 1){
                left = 650;
                offset += 1;
            }else if(offset == 2){
                left = 300;
                offset += 1;
            }else if(offset == 3){
                left = 50;
                offset += 0;
            }
            v.fillRect(left, top, 100, 100);

        }else if(t.getTileShape() == 1 && t.getTileColor() == 1) {
            v.setColor(Color.MAGENTA);
            if (offset == 0) {
                left = 850;
                offset += 1;
            } else if(offset == 1){
                left = 650;
                offset += 1;
            }else if(offset == 2){
                left = 300;
                offset += 1;
            }else if(offset == 3){
                left = 50;
                offset += 0;
            }
            v.fillRect(left, top, 100, 100);

        }else if(t.getTileShape() == 1 && t.getTileColor() == 0) {
            v.setColor(Color.CYAN);
            if (offset == 0) {
                left = 850;
                offset += 1;
            } else if(offset == 1){
                left = 600;
                offset += 1;
            }else if(offset == 2){
                left = 300;
                offset += 1;
            }else if(offset == 3){
                left = 50;
                offset += 0;
            }
            v.fillRect(left, top, 100, 100);
        } 
        }
	}
	public String getMouseStatus() {
		return mouseStatus;
	}
	public void setMouseStatus(String ms) {
		mouseStatus = ms;
    }
	@Override
	public void mouseClicked(MouseEvent e) {
        if (e.getX() > 0 && e.getX() < 250) {
			tile1.setORide();
			repaint();
		}else if(e.getX() > 251 && e.getX() < 500) {
			tile2.setORide();
			repaint();
		}else if(e.getX() > 501 && e.getX() < 750) {
			tile3.setORide();
			repaint();
		}else if(e.getX() > 751 && e.getX() < 1000) {
			tile4.setORide();
			repaint();
        }
       
}

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
	@Override
	public void mousePressed(MouseEvent e) {
	
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	
	}
    @Override
    public void mouseEntered(MouseEvent e) {

    }
}