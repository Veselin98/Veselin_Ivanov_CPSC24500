import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

  /**
     * this class reads data from a JSON file for the program
     * 
     */
public class QuestionReader {
    public ArrayList<Question> readFromJSON(String fname) {//creates array
        ArrayList<Question> questions = new ArrayList<Question>();//creates array
        String question;
        String answer;
        String a;
        String b;
        String c;
		String d;

		try {

			FileReader reader = new FileReader(new File(fname));
			JSONParser parser = new JSONParser();
			JSONObject all = (JSONObject)parser.parse(reader);
			JSONArray arr = (JSONArray)all.get("questions");
			Iterator itr = arr.iterator();
			JSONObject questionObject;
			while (itr.hasNext()) {
                questionObject = (JSONObject)(itr.next());
                question = questionObject.get("question").toString();
                a = questionObject.get("a").toString();
                b = questionObject.get("b").toString();
                c = questionObject.get("c").toString();
				d = questionObject.get("d").toString();
				answer = questionObject.get("answer").toString();
				questions.add(new Question(question,a,b,c,d, answer));
			}
			reader.close();
			return questions;
		} catch (Exception ex) {
			return null;
		}
	}
}

