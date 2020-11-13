
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//menu options
class SlotMachineFrame extends JFrame{
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private TilePanel pan;
    public void setupMenu(){
        JMenuBar mbar = new JMenuBar();
		JMenu mnuFile = new JMenu("File");
        JMenuItem miLoad = new JMenuItem("Load saved tiles");
		miLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TileReader dr = new TileReader();
				JFileChooser jfc = new JFileChooser();
				if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					ArrayList<Tile> tileRead = dr.read(jfc.getSelectedFile());
					if (tileRead == null) {
						JOptionPane.showMessageDialog(null,"Could not read saved tiles from file.");
					} else {
						pan.setTiles(tileRead);
						repaint();
					}
				}
			}
		});
		mnuFile.add(miLoad);
		
		JMenuItem miSave = new JMenuItem("Save");
		miSave.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				TileWriter dw = new TileWriter();
				if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) { // the user wants to go ahead
					if (dw.write(jfc.getSelectedFile(), pan.getTiles())) {
						JOptionPane.showMessageDialog(null,"Wrote tiles to file.");
					} else {
						JOptionPane.showMessageDialog(null,"Could not write tiles to file.");
					}
				}
			}
		});
		mnuFile.add(miSave);
        JMenuItem miPrint = new JMenuItem("Print");
		mnuFile.add(miPrint);
		//restart
		JMenuItem miRestart = new JMenuItem("Restart");
		mnuFile.add(miRestart);
		//exit
		JMenuItem miExit = new JMenuItem("Exit");
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnuFile.add(miExit);
		mbar.add(mnuFile);
		JMenu mnuHelp = new JMenu("Help");
		JMenuItem miAbout = new JMenuItem("About");
		miAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Veselin Ivanov -- https://github.com/Veselin98/Veselin_Ivanov_CPSC24500");
			}
		});
		mnuHelp.add(miAbout);
		mbar.add(mnuFile);
		mbar.add(mnuHelp);
		setJMenuBar(mbar);
    }

    public void setupLook(){
		setBounds(100,100,1000,800);
		setTitle("Vegas$Baby$Vegas Slot Machine");
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
		pan = new TilePanel();
		c.add(pan,BorderLayout.CENTER);
		JPanel panSouth = new JPanel();
		panSouth.setLayout(new FlowLayout());
		JButton btnMax = new JButton("MAX");
		panSouth.add(btnMax);
		JButton btnMid = new JButton("MID");
		panSouth.add(btnMid);
		JButton btnMin = new JButton("MIN");
		panSouth.add(btnMin);
		panSouth.add(new JLabel("$"));
		JTextField txtBalance = new JTextField(8);
		txtBalance.setText("5.00");
		panSouth.add(txtBalance);
		c.add(panSouth,BorderLayout.SOUTH);
		setupMenu();
	}





    public SlotMachineFrame(){
		setupLook(); 
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		
	}
}    