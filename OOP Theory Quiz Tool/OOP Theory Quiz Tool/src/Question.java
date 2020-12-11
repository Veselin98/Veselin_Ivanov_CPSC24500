

/**
* creates question and model class and holds data that will be printed
* 
*/
public class Question {
   private String question;
   private String answer;
   private String a;
   private String b;
   private String c;
   private String d;

   
     /**
     * get function for question
     * 
     */
   public String recieveQuestion(){
      return question;
   }
    /**
     * set function for question
     * 
     */
    public void giveQuestion(String question){
       this.question = question;
    }
/**
     * get function for answer
     * 
     */
    public void giveAnswer(String answer){
        this.answer = answer;
    }
/**
     * set function for answer
     * 
     */
    public String askAnswer(){
        return answer;
    }
/**
     * get function for a
     * 
     */
   public String askA(){
    return a;
    }
/**
     * set function for a
     * 
     */
    public void giveA(String a){
        this.a = a;
    }
/**
     * get function for b
     * 
     */
    public String askB(){
        return b;
    }
/**
     * set function for b
     * 
     */
    public void giveB(String b){
        this.b = b;
    }
/**
     * get function for c
     * 
     */
    public String askC(){
        return c;
    }
/**
     * set function for c
     * 
     */
    public void giveC(String c){
        this.c = c;
    }
/**
     * get function for d
     * 
     */
    public String askD(){
        return d;
    }
/**
     * set function for d
     * 
     */
    public void giveD(String d){
        this.d = d;
    }

    /**
     * calling set functuions for variables
     * 
     */
    public Question(String question, String a, String b, String c, String d, String answer){
        giveQuestion(question);
        giveA(a);
        giveB(b);
        giveC(c);
        giveD(d);
        giveAnswer(answer);
    }
 /**
     * formats and prints answer
     * 
     */
    public String formatAnswer(){
        return String.format("%s", answer);
    }
  /**
     * formats and prints question
     * 
     */
    public String formatQuestion(){
        return String.format("%s", question);
    }
  /**
     * formats and prints string
     * 
     */
    public String giveString(){
        return String.format("%s\nA. %s\nB. %s\nC. %s\nD. %s\n", question, a, b, c, d);
    }
} //end code

