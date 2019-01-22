/**
 * This class creates an AssistantRegionalManager object and formats it to a output string to be printed. 
 * @author Johnny Li and Colby Lathrop
 */
public class AssistantRegionalManager extends Employee{
	//Declares private variables
	private RegionalManager manager;
	private int minimumTask;
	/**
	 * Constructor of the object type AssistantRegionalManager
	 * @param IDNumber - The int number of the Employee.
	 * @param name - The string name of the Employee.
	 * @param taskList - An array of tasks for the specific employee.
	 * @param manager - The RegionalManager object that the specific AssistantRegionalManager is the subordinate of. 
	 * @param minimumTask - The lowest task priority that this AssistantRegionalManager has cannot be greater than the 
	 * minimumTask of this object's RegionalManager.
	 */
	AssistantRegionalManager(int IDNumber, String name, Task[] taskList, RegionalManager manager, int minimumTask){
		super.setIDNumber(IDNumber);
		super.setName(name);
		super.setTaskList(taskList);
		this.manager = manager;
		this.minimumTask = minimumTask;
	}

	// Collection of Getters and Setters
	/**
	 * Getter for the manager private variable 
	 * @return manager - The RegionalManager object that the specific AssistantRegionalManager is the subordinate of. 
	 */
	public RegionalManager getManager() {
		return manager;
	}
	/**
	 * Setter for the manager private variable
	 * @param manager - The RegionalManager object that the specific AssistantRegionalManager is the subordinate of. 
	 */
	public void setManager(RegionalManager manager) {
		this.manager = manager;
	}
	/**
	 * Getter for the minimumTask private variable
	 * @return minimumTask - The lowest task priority of the RegionalManager.
	 */
	public int getMinimumTask() {
		return minimumTask;	
	}
	/**
	 * Setter for the minimumTask private variable
	 * @param minimumTask - The lowest task priority of the RegionalManager.
	 */
	public void setMinimumTask(int minimumTask) {
		this.minimumTask = minimumTask;
	}
	/**
	 * Format a string for output.
	 * Note: After EVERY colon (:) there MUST be a single space after it.
	 * Note: There must be NO newline (\n) at the very end of the entire string.
	 * Note: That the each Task is formatted exactly described in the Task’s toString method.
	 * @return output: A string with employee's name, ID, and task. 
	 */
	public String toString(){
		// Creates the string output will contain all of the information of the AssistantRegionalManager
    	String output = "Assistant Regional Manager\nName: " + super.getName() + "\nID: " + super.getIDNumber();
    	output += "\nTask List: ";
    	// adds the task information for the AssistantRegionalManager through the Task's toString method
    	for (int i = 0; i < super.getTaskList().length; i++) {
    		Task[] toPrint = super.getTaskList();
    		output += "\n" + toPrint[i].toString();
    	}
    	// adds regional manager and minimum task level information to output string
    	output += "\nRegional Manager: " + manager.getName() + "\nMinimum Task Level: " + minimumTask;
    	
    	return output;
    }

	/**
	 * This method was provided complete.
	 * DO NOT EDIT!
	 * @param r Takes in a AssistantRegionalManager object.
	 * @return equal A boolean- true when everything matches. 
	 * @author Michael Arboleda
	 */
	public boolean equals(AssistantRegionalManager r){
		boolean equal = super.equals(r);
		equal = equal && (r.getMinimumTask() == minimumTask);
		equal = equal && (r.getManager().equals(manager));
		return equal;
	}
}