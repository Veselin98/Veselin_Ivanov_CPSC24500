import java.util.Scanner;

public class Flooring {
	public static double BoardA(double l, double w) {
		double areab = l * w;
		return areab;
	}
	public static void main(String[] args) {
		int t1, t2, th1, r1, r2 ;
		double Tarea;
		double Rarea;
		double RoomArea;
		double Barea;
		double b1;
		double b2;
		double BoardPackArea;
		double NumBoardPacksForRoom;
		double costperpack;
		double Cost;
		double Room20;
		// t1 is base 1 of trapezoid
		t1 = 20;
		// t2 is base 2 of trapezoid
		t2 = 10;
		// th1 is height of trapezoid
		th1 = 12;
		// Tarea is the area of the trapezoid
		Tarea = .5 * (t1+t2) * th1;
		
		// r1 is height of rectangle
		r1 = 20;
		// r2 is width of rectangle
		r2 = 13;
		// Rarea is the area of the rectangle
		Rarea = r1 * r2;
	
		// RoomArea is the area of the rectangle plus the area of the trapezoid
		RoomArea = Tarea + Rarea;
		System.out.println("The area of the whole room is: " + RoomArea);
		
		//  b1 is height of laminate board
		b1 = 2.5;
		//b2 is the width of laminate board
		b2 = 0.5;
		// Barea is the area of a single board
		//Barea = b1 * b2;
		Barea = BoardA(b1, b2);
		// area of room plus 20%
		Room20  =  (RoomArea * 0.20) + RoomArea;
		System.out.println("The room area plus 20% is: "  + Room20);
		
		//BoardPackArea is the area covered by a pack of boards
		BoardPackArea = Barea * 6;
		System.out.println("The area of a pack of laminate boards is: " + BoardPackArea);
		
		
		
		//NumBoardPacksForRoom  is the number of packs of laminate flooring needed for the room and using Math.ceil() method to round to the next highest whole number
		NumBoardPacksForRoom = Room20 / BoardPackArea;
		System.out.println("The number of board packs that are needed to cover the whole room is: " + Math.ceil(NumBoardPacksForRoom));
		
		// costperpack is the cost of one pack of laminate flooring
		costperpack = 24.99;
		// Cost is the amount of packs needed to fill the room times the costperpack
		Cost = NumBoardPacksForRoom * costperpack;
		System.out.println("The cost to laminate the room floor is $" + Cost);

	}
}