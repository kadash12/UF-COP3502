//Michael Arboleda
import static org.junit.Assert.*;

import org.junit.Test;

public class TheOfficeTest {

	public static String error = "TheOfficeTest\n";

	@Test
	public void testTheOfficeToString(){
		error += ("testTheOfficeToString() \t TheOffice toString\n");

		//Tasks
		Task t1 = new Task("T1", 1);
		Task t2 = new Task("T2", 2);
		Task[] ansTasks = {t1, t2};

		//Jim items
		String[] items = {"100x white paper","Sabre Printer" ,"Sabre Copier"};

		//Dummy Manager for Jim and Dwight
		RegionalManager r = new RegionalManager(-1, "Michael Scott", null, -1, null, -1);

		SalesAssociate sa = new SalesAssociate(3, "James Duncan Halpert", ansTasks, 5, items, r);
		AssistantRegionalManager arm = new AssistantRegionalManager(2, "Dwight Kurt Schrute III", ansTasks, r, 5);
		Receptionist pam = new Receptionist(4, "Pamela Morgan Beesly", ansTasks, arm, 5);

		//Employee Array for actual Michael
		Employee[] e = {arm, sa, pam};
		RegionalManager mike = new RegionalManager(1, "Michael Scott", ansTasks, 10, e, 8);

		String rString = "Assistant Regional Manager\nName: Dwight Kurt Schrute III\nID: 2\nTask List: \n" +
				"\tTask: T1\tLevel: 1\n\tTask: T2\tLevel: 2\nRegional Manager: Michael Scott\nMinimum Task Level: 5";

		String saString = "Sales Associate\nName: James Duncan Halpert\nID: 3\nTask List: \n\tTask: T1\tLevel: 1\n" +
				"\tTask: T2\tLevel: 2\nRegional Manager: Michael Scott\nNumber of clients: 5\nProducts to sell: \n" +
				"\t100x white paper\n\tSabre Printer\n\tSabre Copier";		

		String pamString = "Receptionist\nName: Pamela Morgan Beesly\nID: 4\nTask List: \n\tTask: T1\tLevel: 1\n" +
				"\tTask: T2\tLevel: 2\nAssistant Regional Manager: Dwight Kurt Schrute III\nMax Task Level: 5";


		String ans = "Regional Manager\nName: Michael Scott\nID: 1\nTask List: \n\tTask: T1\tLevel: 1\n\tTask: T2\tLevel: 2\n" +
				"Region Number: 10\nMinimum Task Level: 8\nEmployees: \n" + rString + "\n" + saString + "\n" + pamString;

		Employee[] allWorkers = {arm, sa, pam, mike};
		
		TheOffice office = new TheOffice();
		office.setWorkers(allWorkers);


		String students = office.toString();

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
	
	@Test
	public void testLevelDisplay(){
		error += ("testLevelDisplay() \t TheOffice levelDisplay\n");
		
		//Tasks
		Task t1 = new Task("T1", 1);
		Task t2 = new Task("T2", 2);
		Task[] ansTasks = {t1, t2};

		//Jim items
		String[] items = {"100x white paper","Sabre Printer" ,"Sabre Copier"};

		//Dummy Manager for Jim and Dwight
		RegionalManager r = new RegionalManager(-1, "Michael Scott", null, -1, null, -1);

		SalesAssociate sa = new SalesAssociate(3, "James Duncan Halpert", ansTasks, 5, items, r);
		AssistantRegionalManager arm = new AssistantRegionalManager(2, "Dwight Kurt Schrute III", ansTasks, r, 5);
		Receptionist pam = new Receptionist(4, "Pamela Morgan Beesly", ansTasks, arm, 5);

		//Employee Array for actual Michael
		Employee[] e = {arm, sa, pam};
		RegionalManager mike = new RegionalManager(1, "Michael Scott", ansTasks, 10, e, 8);
		
		Employee[] allWorkers = {mike, arm, sa, pam};
		
		TheOffice office = new TheOffice();
		office.setWorkers(allWorkers);

		String ans = "Name: Michael Scott\tLevel: 8\nName: Dwight Kurt Schrute III\tLevel: 5\nName: James Duncan Halpert\tLevel: 1\nName: Pamela Morgan Beesly\tLevel: 1";
				
		String students = office.levelDisplay();		
		
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

	@Test
	public void testTheOfficeToStringFromFile() throws TaskLevelException{
		error += ("testTheOfficeToStringFromFile() \t TheOffice toString\n");
		
		TheOffice o = new TheOffice(("office3.txt"));
		

		String rString = "Assistant Regional Manager\nName: Dwight Kurt Schrute III\nID: 2\nTask List: \n" +
				"\tTask: Help Michael Scott\tLevel: 8\n\tTask: Start Fire Drill\tLevel: 5\n\tTask: Start Gun Safety Presentation\tLevel: 10\nRegional Manager: Michael Scott\nMinimum Task Level: 5";

		String saString = "Sales Associate\nName: James Duncan Halpert\nID: 3\nTask List: \n\tTask: Sell paper\tLevel: 3\n" +
				"\tTask: Say Hi to Pam\tLevel: 10\nRegional Manager: Michael Scott\nNumber of clients: 5\nProducts to sell: \n" +
				"\t100x white paper\n\tSabre Printer\n\tSabre Copier";		

		String pamString = "Receptionist\nName: Pamela Morgan Beesly\nID: 4\nTask List: \n\tTask: Record Threat Level Midnight\tLevel: 5\n" +
				"\tTask: Make Copies\tLevel: 3\n\tTask: Set up printer\tLevel: 5\nAssistant Regional Manager: Dwight Kurt Schrute III\n" +
				"Max Task Level: 5";


		String ans = "Regional Manager\nName: Michael Scott\nID: 1\nTask List: \n\tTask: Fight Charles\tLevel: 10\n" + 
				"\tTask: Marry Holly\tLevel: 10\n\tTask: Form Michael Scott Paper Company\tLevel: 9\n\tTask: Lead meeting\tLevel: 8\n" +
				"\tTask: Make Commercial\tLevel: 8\nRegion Number: 10\nMinimum Task Level: 8\nEmployees: \n" + rString + "\n" + saString + "\n" + pamString;
		
		String students = o.toString();
		
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