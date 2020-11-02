import java.awt.Container;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.Toolkit;
//import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

class PumpDrawPan extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    private int pleft;
    private int ptop;
    private int pwidth;
    private int pheight;
    private String typeEye;
    private String typeNose;
    private String typeMouth;
    int[] eyeLeftx = new int [3];
    int[] eyeLefty = new int [3];
    int[] eyeRightx = new int [3];
    int[] eyeRighty = new int [3];
    int[] nosex = new int [3];
    int[] nosey = new int [3];

    public int getpLeft(){
        return pleft;
    }
    public void setpLeft(int l){
        if (l < 100){
            pleft = 100;
        }
        else{
            pleft = l;
        }
    }
    public int getpTop(){
        return ptop;
    }
    public void setpTop(int t){
        if (t < 100){
            ptop = 100;
        } else{
            ptop = t;
        }
    }
    public int getpWidth(){
        return pwidth;
    }
    public void setpWidth(int w){
        if (w < 100){
            pwidth = 100;
        } else{
            pwidth = w;
        }
    }
    
    public int getpHeight(){
        return pheight;
    }
    public void setpHeight(int h){
        if (h < 100){
            pheight = 100;
        } else{
            pheight = h;
        }
    }
    public String getpTypeEye(){
        return typeEye;
    }
    public void setpTypeEye(String te){
        if (!te.equalsIgnoreCase("C") && !te.equalsIgnoreCase("S") && !te.equalsIgnoreCase("T")){
            typeEye = "C";
        }
        else{
            typeEye = te;
        }
    }
    public String getpTypeNose(){
        return typeNose;
    }
    public void setpTypeNose(String tn){
        if (!tn.equalsIgnoreCase("C") && !tn.equalsIgnoreCase("S") && !tn.equalsIgnoreCase("T")){
            typeNose = "s";
        }
        else{
            typeNose = tn;
        }
    }
    public String getpTypeMouth(){
        return typeMouth;
    }
    public void setpTypeMouth(String tm){
        if (!tm.equalsIgnoreCase("O") && !tm.equalsIgnoreCase("R")){
            typeEye = "o";
        }
        else{
            typeEye = tm;
        }
    }
    public PumpDrawPan(){
        pleft = 190;
        ptop = 100;
        pwidth = 100;
        pheight = 100;
        typeEye = "c";
        typeNose = "s";
        typeMouth = "r";
    }
    public void paint(Graphics v){
        super.paint(v);
        v.setColor(Color.ORANGE);
		v.fillOval(pleft, ptop, pwidth, pheight);
        v.setColor(Color.WHITE);

        eyeLeftx[0] = pleft +(pleft/2);
		eyeLeftx[1] = pleft +(pleft/4);
		eyeLeftx[2] = pleft + (pleft/3);
		
		eyeLefty[0] = ptop +(pheight/5);
		eyeLefty[1] = ptop +(pheight/5);
		eyeLefty[2] = (ptop +(pheight/8));
		
		eyeRightx[0] = (pleft +(pleft/5));
		eyeRightx[1] = (pleft +(pleft/7));
		eyeRightx[2] = (pleft+(pleft/6));
		
		eyeRighty[0] = (ptop +(pheight/5));
		eyeRighty[1] = (ptop +(pheight/5));
		eyeRighty[2] = (ptop +(pheight/8));
		
		nosex[0] = pleft +(pleft/6);
		nosex[1] = (pleft +(pleft/4));
		nosex[2] = (pleft +(pleft/5));
		
		nosey[0] = (ptop +(pheight/2));
		nosey[1] = (ptop +(pheight/4));
		nosey[2] = (ptop +(pheight/6));

        v.setColor(Color.ORANGE);
        v.fillOval(pleft,ptop,pwidth,pheight);
        if (typeEye.equalsIgnoreCase("c")){
            v.setColor(Color.WHITE);
            v.fillOval((pleft + ((pleft/3))),(ptop+((pheight/8))),(pwidth/8),(pheight/8));
            v.fillOval((pleft + ((pleft/6))),(ptop+(pheight/8)),(pwidth/8),(pheight/8));
        }
        else if (typeEye.equalsIgnoreCase("s")){
            v.setColor(Color.WHITE);
            v.fillRect((pleft + ((pleft / 3))), (ptop + ((pheight / 8))), (pwidth / 8), (pheight / 8));
            v.fillRect((pleft + ((pleft / 6))), (ptop + ((pheight / 8))), (pwidth / 8), (pheight / 8));
        }
        else if(typeEye.equalsIgnoreCase("T")){
            v.setColor(Color.WHITE);
            v.fillPolygon(eyeLeftx,eyeLefty,3);
            v.fillPolygon(eyeRightx,eyeRighty,3);
        }
        if (typeNose.equalsIgnoreCase("c")){
            v.setColor(Color.WHITE);
            v.fillOval((pleft + ((pleft/5))),(ptop+((pheight/3))),(pwidth/6),(pheight/6));
        }
        else if (typeNose.equalsIgnoreCase("s")){
            v.setColor(Color.WHITE);
            v.fillRect((pleft + ((pleft / 4))), (ptop + ((pheight / 3))), (pwidth / 8), (pheight / 8));
        }
        else if(typeNose.equalsIgnoreCase("T")){
            v.setColor(Color.WHITE);
            v.fillPolygon(nosex,nosey,3);
        }
        if (typeMouth.equalsIgnoreCase("o")){
            v.setColor(Color.WHITE);
            v.fillOval((pleft + ((pleft / 6))), (ptop + ((pheight / 2))), (pwidth / 2), (pheight / 6));
        }
        else if (typeMouth.equalsIgnoreCase("r")){
            v.setColor(Color.WHITE);
            v.fillRect((pleft + ((pleft / 6))), (ptop + ((pheight / 2))), (pwidth / 2), (pheight / 6));
        }
        v.fillRect((pleft + ((pleft / 4))), (ptop - 9), (pwidth / 9), (pheight / 9));
     }
}
class PumpkinMaker extends JFrame{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    PumpDrawPan drawshape;

    public void centerGraphics(){
        Toolkit toolK = Toolkit.getDefaultToolkit();
        Dimension d = toolK.getScreenSize();
        int swidth = (int)d.getWidth();
        int sheight = (int)d.getHeight();
        int cheight = 400;
        int cwidth = 800;
        int l =swidth/2 - cwidth/2;
        int h = sheight/2 - cheight/2;
        setBounds(l,h,cwidth,cheight);
    }

    public void setLook() {
        setTitle("Pumpkin Maker");
        centerGraphics();
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        drawshape = new PumpDrawPan();
        c.add(drawshape, BorderLayout.CENTER);
        JPanel panSouth = new JPanel();
        panSouth.setLayout(new FlowLayout());
      
        JLabel lblLeft = new JLabel("Left");
        panSouth.add(lblLeft);
        JTextField tLeft = new JTextField(3);
        panSouth.add(tLeft);
        
        JLabel lblTop = new JLabel("Top");
        panSouth.add(lblTop);
        JTextField tTop = new JTextField(3);
        panSouth.add(tTop);
        
        JLabel lblWidth = new JLabel("Width");
        panSouth.add(lblWidth);
        JTextField tWidth = new JTextField(3);
        panSouth.add(tWidth);
        
        JLabel lblHeight = new JLabel("Height");
        panSouth.add(lblHeight);
        JTextField tHeight = new JTextField(3);
        panSouth.add(tHeight);
        
        JLabel lblEyes = new JLabel("Eyes:(C S T)"); // C is circle, S is square, T is triangle
        panSouth.add(lblEyes);
        JTextField tEyes = new JTextField(1);
        panSouth.add(tEyes);

        JLabel lblNose = new JLabel("Nose:(C S T)"); // C is circle, S is square, T is triangle
        panSouth.add(lblNose);
        JTextField tNose = new JTextField(1);
        panSouth.add(tNose);
       
        JLabel lblMouth = new JLabel("Mouth:(O R)"); // O is oval, R is rectangular
        panSouth.add(lblMouth);
        JTextField tMouth = new JTextField(1);
        panSouth.add(tMouth);
        
        JButton draw = new JButton("Draw");
        draw.addActionListener (new ActionListener(){
            public void actionPerformed(ActionEvent e){
               drawshape.setpLeft(Integer.parseInt(tLeft.getText()));
               drawshape.setpTop(Integer.parseInt(tTop.getText()));
               drawshape.setpWidth(Integer.parseInt(tWidth.getText()));
               drawshape.setpHeight(Integer.parseInt(tHeight.getText()));
               drawshape.setpTypeEye((tEyes.getText()));
               drawshape.setpTypeNose((tNose.getText()));
               drawshape.setpTypeMouth((tMouth.getText()));
                repaint();
            }

        });
        panSouth.add(draw);
        c.add(panSouth,BorderLayout.SOUTH);
    }

    public PumpkinMaker() {
        setLook();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

public class PumpkinMakerAPP {
    public static void main(String[] args) {
        PumpkinMaker frm = new PumpkinMaker();
        frm.setVisible(true); 
    }
}