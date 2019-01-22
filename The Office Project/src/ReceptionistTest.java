//Michael Arboleda
import static org.junit.Assert.*;

import org.junit.Test;

public class ReceptionistTest {

	public static String error = "ReceptionistTest\n";

	@Test
	public void testReceptionistToString(){
		error += ("testReceptionistToString() \t Receptionist toString\n");

		Task t1 = new Task("T1", 1);
		Task t2 = new Task("T2", 2);
		Task[] ansTasks = {t1, t2};
		AssistantRegionalManager a  = new AssistantRegionalManager(-1, "Dwight Kurt Schrute III", null, null, -1);

		String ans = "Receptionist\nName: Pamela Morgan Beesly\nID: 4\nTask List: \n\tTask: T1\tLevel: 1\n" +
				"\tTask: T2\tLevel: 2\nAssistant Regional Manager: Dwight Kurt Schrute III\nMax Task Level: 5";

		Receptionist e = new Receptionist(4, "Pamela Morgan Beesly", ansTasks, a, 5);

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