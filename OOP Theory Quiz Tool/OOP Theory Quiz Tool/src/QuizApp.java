 /**
 * OOP Theory And Concept Qestions
 * Veselin Ivanov
 * QuizApp class which is the main function that runs the application
 * 
 */

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;



   
public class QuizApp {  
     /**
     * Prints out the header
     * 
     */
    public static int welcomeHeader(){
    System.out.println("*   What could possibly be more fun than this?   *");
    System.out.println("**************************************************");
    System.out.println("*        OOP Theory and Concept Questions        *");
    System.out.println("**************************************************");
    System.out.println("*   Nothing, Nothing at all! Nope. Nada. Nunca.  *");
    return 0;
    }

    /**
     * prints out the menu and options and scans for choice
     * 
     */
    public static int menuPick(Scanner sc){
    System.out.println("Here are your choices!");
    System.out.println("1. Take a quiz");
    System.out.println("2. See questions and answers"); 
    System.out.println("3. Exit");
    System.out.print("Enter the number of your choice: ");
    int choice = sc.nextInt();
    sc.nextLine();
    System.out.println();
    return choice;
    }
    /**
     * Prints out the Footer at the end when the user chooses to exit
     * 
     */
    public static void goodBye(){
        System.out.println("*************************************");
        System.out.println("*  Thank you for taking CPSC 24500  *");
        System.out.println("*************************************");
    }

      /**
     * Displays the menu, header and footer
     * this function runs the program with the given options from scanner and chooses the information
     * based on the right class that it needs to be called
     */
    public static void main(String[] args){
        ArrayList<Question> questions = new ArrayList<Question>();
        String path = "questions.json";
        int choice;
        Scanner sc = new Scanner(System.in);
        QuestionReader r = new QuestionReader();
        QuestionPrinter p = new QuestionPrinter();
        Quizzer q = new Quizzer();
        int choice1 = 0;
        welcomeHeader();
        if(choice1 != 1){
            do{
                choice = menuPick(sc);
                if(choice == 1){
                    questions = r.readFromJSON(path);
                    System.out.print("How many questions would you like? ");
                    int num = sc.nextInt();
                    System.out.println();
                    q.quizzer(questions, num);
                   

                }
                else if(choice == 2){
                   questions =  r.readFromJSON(path);
                    p.printerQuestion(questions);
                    System.out.println();
                }

            }while(choice != 3);
            
        }else{
            choice1 += 1;
        }
        System.out.println();
        goodBye();
    



    }

}