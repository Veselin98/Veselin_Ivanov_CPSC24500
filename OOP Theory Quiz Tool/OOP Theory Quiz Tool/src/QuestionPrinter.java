
import java.util.ArrayList;

  /**
     * this class allows the program to print the questions and answers from
     * the JSON file ArrayList that has been connected
     */
public class QuestionPrinter {
    /**
     * this function sorts through the array list and prints out the 
     * number, question, and answer
     */
    public void printerQuestion(ArrayList<Question> questions){

        for (Question question : questions) {
            String formAns = question.formatAnswer();
            String formQui = question.formatQuestion();
            System.out.printf(formAns + " " + formQui + "\n");
		}


    }

    
}
