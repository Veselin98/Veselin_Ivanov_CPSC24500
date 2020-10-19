/**
 * This code takes in user input and prints out and graphs cumulitive and daily deaths from covid for chosen countries
 */

/**
 * @author veselinivanov
 *
 */
import java.awt.Container;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Scanner;
import javax.swing.JFrame;
import org.math.plot.Plot2DPanel;
import org.math.plot.plotObjects.BaseLabel;
import java.awt.BorderLayout;
import java.awt.Color;



public class CovidPlotter {
    /**
     * This prints out a banner
     */
	public static void Welcome(){
		System.out.println("*************************************************");
		System.out.println(" *   INTERNATIONAL COVID-19 MORTALITY RATES    *");
		System.out.println("*************************************************");
    }
    /**
     * This builds an array of the deaths for day
     * @param amount
     * @return
     */
    public static double[] deaths(double[] amount){
        int death = amount.length;
        double[] result = new double[death];
        for (int i = 1; i < death; i++) {
            result[i] = amount[i] - amount[i-1];
        }
        return result;
    }
    /**
     * This builds array of numbers that we use to plot the value for days of countries
     * @param amount
     * @return
     */
	public static double[] days(int amount) {
        double[] result = new double[amount];
        for (int i = 0; i < amount; i++) {
            result[i] = i;
        }
        return result;
    }
    /**
     * This creates the LinkedHashMap and returns the values and names
     * @param fsc
     * @return
     */
	public static LinkedHashMap<String,double[]> readData(Scanner fsc) {
        LinkedHashMap<String,double[]> result = new LinkedHashMap<String,double[]>();
        fsc.nextLine();
        String[] parts;
        String line; 
        double[] values;
        String name;
        while (fsc.hasNextLine()) {
            line = fsc.nextLine();
            parts = line.split("\t");
            name = parts[0];
            values = new double[parts.length-1];
            for (int i = 1; i < parts.length; i++) {
                values[i-1] = Double.parseDouble(parts[i]);
            }
            result.put(name,values);
        }
        return result;
    }
    /**
     * This function is the main which allows user choose and interact with the program and calls
     * functions within the code for computing
     * @param fsc
     * @return
     */
    public static void main(String[] args) {
        LinkedHashMap<String,double[]> accounts = null;
        String names, fname;
        String[] parts;
        double[] data;
        Scanner sc = new Scanner(System.in);
        Welcome();
        System.out.print("Enter the name fo the text file: ");
        fname = sc.nextLine();
        //sc.close();
        try {
            Scanner fsc = new Scanner(new File(fname));
            accounts = readData(fsc);
            fsc.close();
        } catch (Exception ex) {
            accounts = null;
        }
        if (accounts == null) {
            System.out.println("Sorry! Couldn't read the account data.");
        } else {
            do {
                System.out.print("Enter names of countries separated by commas or quit to exit: ");
                names = sc.nextLine();
                if (!names.equalsIgnoreCase("quit")) {
                    System.out.print("D for daily or C for cummulitive: ");
                    String choice2 = sc.nextLine();
                    Plot2DPanel plot = new Plot2DPanel();
                    plot.setAxisLabels("Days", "Deaths");
                    if(choice2.equalsIgnoreCase("c")){
                        BaseLabel title = new BaseLabel("Cumulitive Deaths",Color.RED,0.5,1.1);
                        plot.addLegend("SOUTH");
                        parts = names.split(",");
                        for (String part : parts) {
                            part = part.trim();
                            if (accounts.containsKey(part) == false) {
                                System.out.printf("%s was not found.\n",part);
                            } else {
                                data = accounts.get(part);
                                plot.addLinePlot(part,days(data.length),data);
                                JFrame frm = new JFrame();
                                frm.setTitle("Cumulitive Deaths");
                                frm.setBounds(100,100,500,500);
                                frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                Container c = frm.getContentPane();
                                c.setLayout(new BorderLayout());
                                c.add(plot,BorderLayout.CENTER);
                                frm.setVisible(true);
                            }
                        }
                    }
                    else if(choice2.equalsIgnoreCase("d")){
                        BaseLabel title = new BaseLabel("Daily Deaths",Color.RED,0.5,1.1);
                        plot.addLegend("SOUTH");
                        parts = names.split(",");
                        for (String part : parts) {
                            part = part.trim();
                            if (accounts.containsKey(part) == false) {
                                System.out.printf("%s was not found.\n",part);
                            } else {
                                data = accounts.get(part);
                                plot.addLinePlot(part,days(data.length),deaths(data));
                                JFrame frm = new JFrame();
                                frm.setTitle("Daily Deaths");
                                frm.setBounds(100,100,500,500);
                                frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
                                Container c = frm.getContentPane();
                                c.setLayout(new BorderLayout());
                                c.add(plot,BorderLayout.CENTER);
                                frm.setVisible(true);
                            }
                        }
                    }
                }
            } while (!names.equalsIgnoreCase("quit"));
        }
    }
}