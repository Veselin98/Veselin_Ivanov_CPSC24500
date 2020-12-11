import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;



    /**
     * a controller class that has a function that randomly chooses and presents 
     * questions to the student and keeps track of and returns how many questions 
     * the student answered correctly.
     */
public class Quizzer {
    public static void quizzer(ArrayList<Question> questions, int nq){
        String userAnswer;
        int numOfQuestions = nq; 
        int counter = 0;
        Scanner sc = new Scanner(System.in);
        Collections.shuffle(questions);
        for(Question question : questions){
            if(counter != numOfQuestions){
                System.out.println(question.giveString());
                System.out.println("Enter answer: ");
                userAnswer = sc.nextLine().trim();
                String answerRight = question.formatAnswer();
                if(userAnswer.equalsIgnoreCase(answerRight)){
                    System.out.println("Correct!!!");
                    counter += 1;
                    System.out.println();
                }else if(userAnswer != answerRight){
                    System.out.printf("Incorrect. The correct answer is:%s\n", answerRight );
                    counter += 1;
                    System.out.println();
                }
            }
        }
    }
}
