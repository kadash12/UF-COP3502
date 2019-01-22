/**
 * This class creates an Receptionist object and formats it to a output string to be printed. 
 * @author Johnny Li and Colby Lathrop
 */
public class Receptionist extends Employee{
	//Declares private variables
	private AssistantRegionalManager supervisor;
	private int maxTaskComplexityLevel;

	/**
	 * Constructor of the object type Receptionist
	 * @param IDNumber - The int number of the Employee
	 * @param name - The string name of the Employee 
	 * @param taskList - An array of tasks for the specific employee
	 * @param supervisor - The AssistantRegionalManager object that the Receptionist object acts as a surbonidate to
	 * @param maxTaskComplexityLevel - The int that corresponds to the highest priority task
	 */
	Receptionist(int IDNumber, String name, Task[] taskList, AssistantRegionalManager supervisor, int maxTaskComplexityLevel){
		super.setIDNumber(IDNumber);
		super.setName(name);
		super.setTaskList(taskList);
		this.supervisor = supervisor;
		this.maxTaskComplexityLevel = maxTaskComplexityLevel;
	}

	//Collection of Getters and Setters
	/**
	 * Getter for the supervisor private variable
	 * @return supervisor - The AssistantRegionalManager object that the Receptionist object acts as a surbonidate to
	 */
	public AssistantRegionalManager getSupervisor() {
		return supervisor;
	}
	/**
	 * Setter for the supervisor private variable
	 * @param supervisor - The AssistantRegionalManager object that the Receptionist object acts as a surbonidate to
	 */
	public void setSupervisor(AssistantRegionalManager supervisor) {
		this.supervisor = supervisor;
	}
	/**
	 * Getter for the maxTaskComplexityLevel private variable
	 * @return maxTaskComplexityLevel - The int that corresponds to the highest priority task
	 */
	public int getMaxTaskComplexityLevel() {
		return maxTaskComplexityLevel;
	}
	/**
	 * Setter for the maxTaskComplexityLevel private variable
	 * @param maxTaskComplexityLevel - The int that corresponds to the highest priority task
	 */
	public void setMaxTaskComplexityLevel(int maxTaskComplexityLevel) {
		this.maxTaskComplexityLevel = maxTaskComplexityLevel;
	}

	/**
	 * Format a string for output.
	 * Note: After EVERY colon (:) there MUST be a single space after it.
	 * Note: There must be NO newline (\n) at the very end of the entire string.
	 * Note: That the each Task is formatted exactly described in the Task’s toString method.
	 * @return output: A string with employee's name, ID, and task. 
	 */
	public String toString() {
		// Creates the string output will contain all of the information of the Receptionist
    	String output = "Receptionist\nName: " + super.getName() + "\nID: " + super.getIDNumber();
    	output += "\nTask List: ";
    	
    	// adds the task information for the Receptionist through the Task's toString method
    	for (int i = 0; i < super.getTaskList().length; i++) {
    		Task[] toPrint = super.getTaskList();
    		output += "\n" + toPrint[i].toString();
    	}
    	
    	// adds the supervisor and max task level information to the output string
    	output += "\nAssistant Regional Manager: " + supervisor.getName() + "\nMax Task Level: " + maxTaskComplexityLevel;
    	
    	return output;
	}

	/**
	 * This method was provided complete.
	 * DO NOT EDIT!
	 * @param r Takes in a Receptionist object.
	 * @return equal A boolean- true when everything matches. 
	 * @author Michael Arboleda
	 */
	public boolean equals(Receptionist r){
		boolean equal = super.equals(r);
		equal = equal && (r.getSupervisor().equals(supervisor));
		equal = equal && (r.getMaxTaskComplexityLevel() == maxTaskComplexityLevel);
		return equal;
	}
}