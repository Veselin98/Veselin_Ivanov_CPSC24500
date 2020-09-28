import java.util.Scanner;
import java.util.Random;

public class GameZone {
/*
 * Veselin Ivanov
 * 09/28/2020
 */
	public static void Welcome(){
		System.out.println("************************************");
		System.out.println("*     Welcome to the Game Zone     *");
		System.out.println("************************************");
	}
	public static void PrintHands(int a, int b) {
		System.out.println("Your hand " + a);
		System.out.println("Computer hand " + b);
	}
	public static void RpS(int a, int b, String c, String d) {
		if(a == 1) {
			c = "rock";
		}
		else if (a == 2) {
			c = "Paper";
		}
		else{
			c = "Scissors";
		}
		if(b == 1) {
			d = "Rock";
		}
		else if(b == 2){
			d = "Paper";
		}
		else {
			d = "Scissors";
		}
		System.out.println("You Played " + c +" and the Computer played " + d);
	}
	
	public static void main(String[] args){
		Scanner enter = new Scanner(System.in);
		Random rnd =  new Random();
		int choice;
		do {
			Welcome();
			System.out.println("What would you like to play?");
			System.out.println("1. Twenty-one");
			System.out.println("2. Rock Paper Scissors");
			System.out.println("3. Neither - I'm done!");
			choice = enter.nextInt();
			if(choice == 1) {
				int hand1 = 1 + rnd.nextInt(11); //user
				int hand2 = 13 + rnd.nextInt(8); //computer
				boolean game = true;
				while(game = true) {
					int choice2;
					if(hand1 > 21) {
						PrintHands(hand1, hand2);
						System.out.println("You went over!");
						game = false;
						break;
					}
					System.out.println("Press 1 for another card");
					System.out.println("Press 2 to keep current amount");
					System.out.println("Press any other number to quit");
					choice2 = enter.nextInt();
					if(choice2 == 1) {
						int addTo = 1 + rnd.nextInt(11);
						hand1 = hand1 + addTo;
						System.out.println("Your hand is " + hand1);
					}
					else if(choice2 ==2) {
						PrintHands(hand1, hand2);
						if(hand1 > hand2) {
							System.out.println("You Won!");
						}
						else if(hand1 == hand2) {
							System.out.println("Its a tie!");
						}
						else {
							System.out.println("The Computer Won!");
						}
						game = false;
						break;
					}
					else {
						game = false;
						break;
					}
				}
			}
			if(choice == 2) {
				int num1 = 1 + rnd.nextInt(3); //user choice
				int num2 = 1 + rnd.nextInt(3); //comp choice
				String user = null;
				String comp = null;
				//Scanner userChoice = new Scanner(System.in);
				if (num1 == 1 && num2 == 2 || num1 == 1 && num2 == 2 || num1 == 2 && num2 == 3) {
					RpS(num1, num2, user, comp);
					System.out.println("You Lost");
				}
				else if(num1 == 1 && num2 == 1 || num1 == 2 && num2 == 2 || num1 == 3 && num2 == 3){
					RpS(num1, num2, user, comp);
					System.out.println("It was a tie");
				}
				else if(num1 == 1 && num2 == 3 || num1 == 2 && num2 == 1 || num1 == 3 && num2 == 2) {
					RpS(num1, num2, user, comp);
					System.out.println("You win");	
				}
			}
		} while (choice != 3);
		System.out.println("GoodByte");
			
	}
}