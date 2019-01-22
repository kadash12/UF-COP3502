/**
 * This class creates an employee object and formats it to a output string to be printed. 
 * @author Johnny Li and Colby Lathrop
 */
public abstract class Employee {	
	//Declare private variables.
	private int IDNumber;
	private String name;
	private Task[] taskList;

	/**
	 *Constructor with argument.
	 *@param IDNumber The int number of the Employee.
	 *@param name The string name of the Employee.
	 *@param taskList A Task (object) array of tasks.
	 *@return Employee An object with the content of int IDNumber, String name, Task[] taskList.
	 */ 
	Employee(int IDNumber, String name, Task[] taskList){
		this.IDNumber = IDNumber;
		this.name = name;
		this.taskList = taskList;
	}
	/**
	 * Constructor with no argument.
	 */
	Employee(){}

	//Collection of Getters and Setters.
	/**
	 * Getter for IDNumber.
	 * @return IDNumber
	 */
	int getIDNumber(){
		return IDNumber;
	}
	/**
	 * Setter for IDNumber.
	 * @param IDNumber
	 */
	void setIDNumber(int IDNumber){
		this.IDNumber = IDNumber;
	}
	/**
	 * Getter for name.
	 * @return name
	 */
	String getName(){
		return name;
	}
	/**
	 * Setter for name. 
	 * @param name
	 */
	void setName(String name){
		this.name = name;
	}
	/**
	 * Getter for taskList.
	 * @return taskList
	 */
	Task[] getTaskList(){
		return taskList;
	}
	/**
	 * Setter for taskList.
	 * @param taskList
	 */
	void setTaskList(Task[] taskList){
		this.taskList = taskList;
	}

	/**
	 * Format a string for output.
	 * Note: After EVERY colon (:) there MUST be a single space after it.
	 * Note: There must be NO newline (\n) at the very end of the entire string.
	 * Note: That the each Task is formatted exactly described in the Task’s toString method.
	 * @return output: A string with employee's name, ID, and task. 
	 */
	public String toString(){
		// Creates output that contains the name, ID number, and tasks for an employee object.
		String output = "Name: " + getName() + "\nID: " + getIDNumber() + "\nTask List: ";
		// adds the task information for the employee's taskList
    	for (int i = 0; i < taskList.length; i++) {
    		output += "\n" + taskList[i].toString();
    	}
		return output;
	}
	/**
	 * This method was provided complete.
	 * DO NOT EDIT!
	 * @param e Takes in a employee object.
	 * @return equal A boolean- true when everything matches. 
	 * @author Michael Arboleda
	 */
	public boolean equals(Employee e){
		boolean equal = true;
		equal = equal && (e.getIDNumber() == IDNumber);
		equal = equal && (e.getName().equals(name));
		for(int i = 0; i < taskList.length; i++){
			equal = equal && (taskList[i].equals(e.getTaskList()[i]));
		}
		return equal;
	}
}