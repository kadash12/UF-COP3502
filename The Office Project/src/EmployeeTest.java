//Michael Arboleda
import static org.junit.Assert.*;

import org.junit.Test;
import java.lang.reflect.Field;

//Used to test abstract class
class EmployeeMock extends Employee{
	EmployeeMock(int IDNumber, String name, Task[] taskList){
		super(IDNumber, name, taskList);
	}

}

public class EmployeeTest {
	public static String error = "EmployeeTest \n\n";

	//Test Constructor
	@Test
	public void testConstructor() throws IllegalArgumentException, IllegalAccessException{
		error += ("testConstructor() \t Employee Employee\n");

		boolean same = true;
		int ansID = 21;
		String ansName = "Michael";
		Task t1 = new Task("T1", 1);
		Task t2 = new Task("T2", 2);
		Task[] ansTasks = {t1, t2};

		EmployeeMock e = new EmployeeMock(21, "Michael", ansTasks);	

		final Field fields[] = Employee.class.getDeclaredFields();
		for (int i = 0; i < fields.length; ++i) {
			if ("IDNumber".equals(fields[i].getName())) {
				fields[i].setAccessible(true);
				int studentsID = (int) fields[i].get(e);  
				if(ansID != studentsID){
					error += ("Correct Ans: " + ansID + "\tStudnets: " + studentsID  + "\n");
					same = false;
				}
			}
			else if("name".equals(fields[i].getName())){
				fields[i].setAccessible(true);
				String studentsName = (String) fields[i].get(e);
				if(!ansName.equals(studentsName)){
					error += ("Correct Ans: " + ansName + "\tStudnets: " + studentsName  + "\n");
					same = false;
				}

			}
			else if("taskList".equals(fields[i].getName())){
				fields[i].setAccessible(true);
				Task[] studentsTasks = (Task[]) fields[i].get(e);
				int min = Math.min(ansTasks.length, studentsTasks.length);

				if(ansTasks.length !=  studentsTasks.length){
					error += ("\tArray size is " + ansTasks.length + " but received array size " + studentsTasks.length + "\n\n");
				}

				for(int j = 0; j<min; j++){
					if(studentsTasks[j] == null){
						same = false;
						error += ("\tIndex: " + j + " Ans: " + ansTasks[j] + " \tStudents: null\n");
					}
					else if(!ansTasks[j].equals(studentsTasks[j])){
						same = false;
						error += ("\tIndex: " + j + " Ans: " + ansTasks[j] + " \tStudents: " + studentsTasks[j] + "\n");
					}
				}
			}
			else{
				error += (fields[i].getName() + " is not a valid parameter\n");
				same = false;
			}
		}
		error += ("\n");

		assert(same);
	}


	//Test getID
	@Test
	public void testGetID(){
		error += ("testGetID() \t Employee getIDNumber\n");

		int ans = 21;
		int students;
		boolean same;

		EmployeeMock e = new EmployeeMock(21, null, null);
		students = e.getIDNumber();
		same = (ans == students);

		if(!same){
			error += ("Correct Ans: " + ans + "\tStudnets: " + students + "\n");
		}
		error += ("\n");

		assert(same);
	}


	//Test setID
	@Test
	public void testSetID(){
		error += ("testGetID() \t Employee getIDNumber\n");

		int ans = 21;
		int students;
		boolean same;

		EmployeeMock e = new EmployeeMock(-1, null, null);
		e.setIDNumber(21);

		students = e.getIDNumber();
		same = (ans == students);

		if(!same){
			error += ("Correct Ans: " + ans + "\tStudnets: " + students + "\n");
		}
		error += ("\n");

		assert(same);
	}


	//Test  getName
	@Test
	public void testGetName() {
		error += ("testGetName() \t Employee getName\n");

		String ans = "Michael";
		String students;
		boolean same;

		EmployeeMock e = new EmployeeMock(-1, "Michael", null);
		students = e.getName();
		same = (ans.equals(students));

		if(!same){
			error += ("Correct Ans: " + ans + "\tStudnets: " + students + "\n");
		}
		error += ("\n");

		assert(same);
	}


	//Test  getName
	@Test
	public void testSetName() {
		error += ("testSetName() \t Employee setName\n");

		String ans = "Michael";
		String students;
		boolean same;

		EmployeeMock e = new EmployeeMock(-1, null, null);
		e.setName("Michael");

		students = e.getName();
		same = (ans.equals(students));

		if(!same){
			error += ("Correct Ans: " + ans + "\tStudnets: " + students + "\n");
		}
		error += ("\n");

		assert(same);
	}


	//Test getTask
	@Test
	public void testgetTasks() {
		error += ("testgetTasks() \t Employee getTaskList\n");

		Task t1 = new Task("T1", 1);
		Task t2 = new Task("T2", 2);
		Task[] ans = {t1, t2};

		Task[] students;
		boolean same = true;

		EmployeeMock e = new EmployeeMock(-1, null, ans);
		students = e.getTaskList();

		int min = Math.min(ans.length, students.length);
		if(ans.length !=  students.length){
			error += ("\tArray size is " + ans.length + " but received array size " + students.length + "\n\n");
		}

		for(int i = 0; i<min; i++){
			if(students[i] == null){
				same = false;
				error += ("\tIndex: " + i + " Ans: " + ans[i] + " \tStudents: null\n");
			}
			else if(!ans[i].equals(students[i])){
				same = false;
				error += ("\tIndex: " + i + " Ans: " + ans[i] + " \tStudents: " + students[i] + "\n");

			}
		}

		error += ("\n");
		assert(same);
	}


	//Test setTask
	@Test
	public void testSetTasks() {
		error += ("testSetTasks() \t Employee setTaskList\n");

		Task t1 = new Task("T1", 1);
		Task t2 = new Task("T2", 2);
		Task[] ans = {t1, t2};

		Task[] students;
		boolean same = true;

		EmployeeMock e = new EmployeeMock(-1, null, null);
		e.setTaskList(ans);
		students = e.getTaskList();

		int min = Math.min(ans.length, students.length);
		if(ans.length !=  students.length){
			error += ("\tArray size is " + ans.length + " but received array size " + students.length + "\n\n");
		}

		for(int i = 0; i<min; i++){
			if(students[i] == null){
				same = false;
				error += ("\tIndex: " + i + " Ans: " + ans[i] + " \tStudents: null\n");
			}
			else if(!ans[i].equals(students[i])){
				same = false;
				error += ("\tIndex: " + i + " Ans: " + ans[i] + " \tStudents: " + students[i] + "\n");

			}
		}

		error += ("\n");
		assert(same);
	}


	//Test toString
	@Test
	public void testEmployeeToString(){
		error += ("testEmployeeToString() \t Employee toString\n");
		
		Task t1 = new Task("T1", 1);
		Task t2 = new Task("T2", 2);
		Task[] ansTasks = {t1, t2};
		String ans = "Name: Michael\nID: 21\nTask List: \n\tTask: T1\tLevel: 1\n\tTask: T2\tLevel: 2";		

		EmployeeMock e = new EmployeeMock(21, "Michael", ansTasks);	
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