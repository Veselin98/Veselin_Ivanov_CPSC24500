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


public class SlotMachineFrame extends JFrame {
	/**
	 *creates the Slot Machine Interface 
	 */
	private static final long serialVersionUID = 1L;
	private TilePanel tpan;
	private JTextField txtBalance;
	private JButton btnMax, btnMid, btnMin;
	/**
	 *creates the menu
	 */
	public void setupMenu() {
		JMenuBar mbar = new JMenuBar(); // creates a menu bar
		JMenu mnuFile = new JMenu("File"); // creates a File button inside the menu bar
		JMenuItem miLoad = new JMenuItem("Load");// creates a Load button
		JMenuItem miSave = new JMenuItem("Save");// creates a save button
		JMenuItem miPrint = new JMenuItem("Print");// creates a print button
		JMenuItem miRestart = new JMenuItem("Restart");// creates a restart button
		JMenuItem miExit = new JMenuItem("Exit");// creates an exit button
		miLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				TileReader tr = new TileReader();
				ArrayList<Tile> tiles;
				if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					tiles = tr.read(jfc.getSelectedFile());
					if (tiles != null) {
						tpan.setTiles(tiles);
						repaint();
					} else {
						JOptionPane.showMessageDialog(null,"Tiles could not be read.");
					}
				}
			}
		});
		/**
	 	*function for the Save button
	 	*/ 
		miSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				TileWriter tw = new TileWriter();
				if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					if (tw.write(jfc.getSelectedFile(),tpan.getTiles())) {
						JOptionPane.showMessageDialog(null,"Wrote tiles successfully.");
					} else {
						JOptionPane.showMessageDialog(null,"Could not write tiles.");
					}
				}
			}
		});
		/**
	 	*function for the restart button
	 	*/ 
		miRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tpan.newTile();
				tpan.resetAmount();
				txtBalance.setText(String.format("%.2f", tpan.getAmount()));
				if(tpan.getAmount() == 5){
					btnVisT();
				}
				repaint();
			}
		});
		/**
	 	*function for the print button
	 	*/ 
		miPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser("C:/Users/Ves/Desktop");
				TileWriter tw = new TileWriter();
				if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					if (tw.write(jfc.getSelectedFile(),tpan.getTiles())) {
						JOptionPane.showMessageDialog(null,"Wrote tiles successfully.");
					} else {
						JOptionPane.showMessageDialog(null,"Could not write tiles.");
					}
				}
				ArrayList<Tile> tiles;
				TileReader tr = new TileReader();
				if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					tiles = tr.read(jfc.getSelectedFile());
					if (tiles != null) {
						tpan.setTiles(tiles);
						repaint();
					} else {
						JOptionPane.showMessageDialog(null,"Tiles could not be read.");
					}
				}
			}
		});
		/**
	 	*function for the exit button
	 	*/ 
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnuFile.add(miLoad);
		mnuFile.add(miSave);
		mnuFile.add(miPrint);
		mnuFile.add(miRestart);
		mnuFile.add(miExit);
		mbar.add(mnuFile);
		JMenu mnuHelp = new JMenu("Help");
		JMenuItem miAbout = new JMenuItem("About");
		miAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Veselin Ivanov -- https://github.com/Veselin98/Veselin_Ivanov_CPSC24500");
			}
		});
		mnuHelp.add(miAbout);
		mbar.add(mnuHelp);
		setJMenuBar(mbar);
	}
		/**
	 	*Buttons are not visible
	 	*/  
	public void btnVisF(){
		btnMax.setEnabled(false);
		btnMid.setEnabled(false);
		btnMin.setEnabled(false);
	}
		/**
	 	*Buttons are visible
	 	*/   
	public void btnVisT(){
		btnMax.setEnabled(true);
		btnMid.setEnabled(true);
		btnMin.setEnabled(true);
	}
	/**
	 * sets up the look of the game and adds the buttons that are used to play the game with
	 */
	public void setupLook() {
		setBounds(100,100,750,300);
		setTitle("Vegas Baby Vegas Slot Machine");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JPanel panSouth = new JPanel();
		panSouth.setLayout(new FlowLayout());
		/**
	 	*max button
	 	*/ 
		btnMax = new JButton("Max");
		btnMax.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){  
				tpan.newTile();
				tpan.tileChecker(2);
				txtBalance.setText(String.format("%.2f", tpan.getAmount()));
				if(tpan.getAmount() == 0){
					btnVisF();
				}
				else{
					//btnVisT();
				}
				repaint();
			}
		});
		/**
	 	*mid button
	 	*/ 
		btnMid = new JButton("Mid");
		btnMid.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){  
				tpan.newTile();
				tpan.tileChecker(1);
				txtBalance.setText(String.format("%.2f", tpan.getAmount()));
				if(tpan.getAmount() == 0){
					btnVisF();
				}
				else{
					//btnVisT();
				}
				repaint();
			}
		});
		/**
	 	*min button
	 	*/ 
		btnMin = new JButton("Min");
		btnMin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){  
				tpan.newTile();
				tpan.tileChecker(0);
				txtBalance.setText(String.format("%.2f", tpan.getAmount()));
				if(tpan.getAmount() == 0){
					btnVisF();
				}
				else{
					//btnVisT();
				}
				repaint();
			}
		});
		/*btnMax = new JButton("Max");
		btnMid = new JButton("Mid");
		btnMin = new JButton("Min");
		*/
		panSouth.add(btnMax);
		panSouth.add(btnMid);
		panSouth.add(btnMin);
		c.add(panSouth,BorderLayout.SOUTH);
		tpan = new TilePanel();
		c.add(tpan,BorderLayout.CENTER);
		JLabel lblBalance = new JLabel("$");
		panSouth.add(lblBalance);
		txtBalance = new JTextField(6);
		txtBalance.setEditable(false);
		txtBalance.setText(String.format("%.2f", tpan.getAmount()));
		panSouth.add(txtBalance);
		setupMenu();
	}
		/**
	 	* creates frame
	 	*/ 
	public SlotMachineFrame() {
		setupLook();
	}
}
