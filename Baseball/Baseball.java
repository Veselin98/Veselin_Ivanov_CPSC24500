import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.awt.*;
import java.util.concurrent.*;

public class Baseball {
	public static int Menu(Scanner sc){
		System.out.println("*****************************************");
		System.out.println("*	Baseball Standings Analyzer	*");
		System.out.println("*****************************************");
		System.out.println("Which Stats would you like to see?"); 
		System.out.println("1. AL East");
		System.out.println("2. Al Central");
		System.out.println("3. AL West"); 
		System.out.println("4. NL East");
		System.out.println("5. NL Central");
		System.out.println("6. NL West");; 
		System.out.println("7. Overall");
		System.out.println("8. Exit"); 
		System.out.print("Enter your choice: ");
		int choice = sc.nextInt();
		return choice;
	}

	public static double getPct(String games){
		String [] parts = games.split("\t");
		double pct1 = (Integer.parseInt(parts[1])) + (Integer.parseInt(parts[2])) ;
		double pct = (Integer.parseInt(parts[1])) /pct1;
		return pct;
	}

	public static void printStats(ArrayList<String> teams){
		String [] parts;
		double pct;
		System.out.println("Team	 Wins	  Loses	       Pct");
		System.out.println("__________________________________");
		for(String team : teams){
			parts = team.split("\t");
			pct = getPct(team);
			System.out.printf("%-10s%-10s%-10s%6.2f\n", parts[0], parts[1], parts[2], pct);
			//System.out.println(parts[1]);
			//System.out.println(parts[2]);
			}
		}
		public static void gameAverage(ArrayList<String> all, String line) {
			double thisAvg = getPct(line);
			double otherAvg;
			int pos = -1;
			for (int i = 0; i < all.size(); i++) {
				otherAvg = getPct(all.get(i));
				if (thisAvg > otherAvg) {     
					pos = i;
					break;   // leaves the loop because the insert location
				}
			}
			if (pos < 0) {
				all.add(line);  // append at the bottom of the list
			} else {
				all.add(pos,line);  // insert the new student (line) at location pos
			}
		}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter name of file: ");
		String fname = sc.nextLine();
		ArrayList<String> aleast = new ArrayList<String>();
		ArrayList<String> alwest = new ArrayList<String>();
		ArrayList<String> alcentral = new ArrayList<String>();
		ArrayList<String> nleast = new ArrayList<String>();
		ArrayList<String> nlwest = new ArrayList<String>();
		ArrayList<String> nlcentral = new ArrayList<String>();
		ArrayList<String> target = null;
		ArrayList<String> overall = new ArrayList<String>();
		String line;
		String[] parts;
		String sem;
		boolean canGoAhead;
		int choice;
		try {
			Scanner fsc = new Scanner(new File(fname));
			while (fsc.hasNextLine()) {
				line = fsc.nextLine();
				parts = line.split("\t");
				if (parts[0].equalsIgnoreCase("League")) {
					sem = parts[1].toUpperCase();
					if (sem.equalsIgnoreCase("AL East")) {
						target = aleast;
					} else if (sem.equalsIgnoreCase("AL West")) {
						target = alwest;
					} else if (sem.equalsIgnoreCase("AL Central")) {
						target = alcentral;
					} else if (sem.equalsIgnoreCase("NL East")) {
						target = nleast;
					} else if (sem.equalsIgnoreCase("NL West")) {
						target = nlwest;
					} else if (sem.equalsIgnoreCase("NL Central")) {
						target = nlcentral;
					}
				} else {
					target.add(line);
					gameAverage(overall, line);
				}
			}
			fsc.close();
			canGoAhead = true;
		} catch (Exception ex) {
			System.out.println("Couldn't read the file.");
			canGoAhead = false;
		}
		if (canGoAhead) {
			do {
				choice = Menu(sc);
				if (choice == 1) {
					//System.out.println(aleast);
					printStats(aleast);
				} else if (choice == 2) {
					printStats(alwest);
				} else if (choice == 3) {
					printStats(alcentral);
				} else if (choice == 4) {
					printStats(nleast);
				} else if (choice == 5) {
					printStats(nlwest);
				} else if (choice == 6) {
					printStats(nlcentral);
				} else if (choice ==7) {
					printStats(overall);
				}
			} while (choice != 8);
		}	
	}
}