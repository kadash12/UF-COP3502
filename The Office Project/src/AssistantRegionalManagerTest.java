//Michael Arboleda
import static org.junit.Assert.*;

import org.junit.Test;

public class AssistantRegionalManagerTest {
	public static String error = "AssistantRegionalManagerTest\n";
	
	@Test
	public void testAssistantRegionalManagerToString(){
		error += ("testAssistantRegionalManagerToString() \t AssistantRegionalManager toString\n");

		
		Task t1 = new Task("T1", 1);
		Task t2 = new Task("T2", 2);
		Task[] ansTasks = {t1, t2};
		RegionalManager r = new RegionalManager(-1, "Michael Scott", null, -1, null, -1);
		
		
		String ans = "Assistant Regional Manager\nName: Dwight Kurt Schrute III\nID: 2\nTask List: \n" +
		"\tTask: T1\tLevel: 1\n\tTask: T2\tLevel: 2\nRegional Manager: Michael Scott\nMinimum Task Level: 5";
		
		AssistantRegionalManager e = new AssistantRegionalManager(2, "Dwight Kurt Schrute III", ansTasks, r, 5);
		String students = e.toString();

		int min = Math.min(ans.length(), students.length());
		if(ans.length() !=  students.length()){
			error += ("\tSize was " + ans.length() + " but received size " + students.length() + "\n\n");
		}

		for(int i = 0; i < min; i++){
			if(ans.charAt(i) != students.charAt(i)){
				String temp1 = "";
				String temp2 = "";

				if(ans.charAt(i) == '\t'){
					temp1 = "\\t";
				}
				else if(ans.charAt(i) == '\n'){
					temp1 = "\\n";
				}
				else{
					temp1 = ("" + ans.charAt(i));
				}

				if(students.charAt(i) == '\t'){
					temp2 = "\\t";
				}
				else if(students.charAt(i) == '\n'){
					temp2 = "\\n";
				}
				else{
					temp2 = ("" + students.charAt(i));
				}
				error += ("\tIndex: " + i + " Ans: " + temp1 + " Students: " + temp2 + "\n");	
			}
		}
		error += ("\n");

		assert(ans.equals(students));
	}
}