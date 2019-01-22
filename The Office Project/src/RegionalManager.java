/**
 * This class creates an RegionalManager object and formats it to a output string to be printed. 
 * @author Johnny Li and Colby Lathrop
 */
public class RegionalManager extends Employee {
	//Declares private variables
	private int RegionNum;
	private Employee[] subordinates;
	private int minimumTask; 

	/**
	 * Constructor for a RegionalManager object that has an array of Employee objects that are subordinates to the 
	 * RegionalManagerObject
	 * @param IDNumber - The int number of the Employee
	 * @param name - The string name of the Employee 
	 * @param taskList - An array of tasks for the specific employee
	 * @param RegionNum - The int number that corresponds to the region that the Regional Manager manages
	 * @param subordinates - An array of employees that act as subordinates to the RegionalManager
	 * @param minimumTask - The lowest task priority that this RegionalManager has
	 */
	RegionalManager(int IDNumber, String name, Task[] taskList, int RegionNum, Employee[] subordinates, int minimumTask) {
		super.setIDNumber(IDNumber);
		super.setName(name);
		super.setTaskList(taskList);
		this.RegionNum = RegionNum;
		this.subordinates = subordinates;
		this.minimumTask = minimumTask;
	}

	/**
	 * Constructor for a RegionalManager object if the RegionalManager has no subordinates
	 * @param IDNumber - The int number of the Employee
	 * @param name - The string name of the Employee 
	 * @param taskList - An array of tasks for the specific employee
	 * @param RegionNum - The int number that corresponds to the region that the Regional Manager manages
	 * @param subordinates - An array of employees that act as subordinates to the RegionalManager
	 * @param minimumTask - The lowest task priority that this RegionalManager has
	 */
	RegionalManager(int IDNumber, String name, Task[] taskList, int RegionNum, int minimumTask) {
		super.setIDNumber(IDNumber);
		super.setName(name);
		super.setTaskList(taskList);
		this.RegionNum = RegionNum;
		this.minimumTask = minimumTask;
	}

	//Collection of Getters and Setters for private variables
	/**
	 * Getter for the RegionNum private variable
	 * @return RegionNum - The int number that corresponds to the region that the Regional Manager manages
	 */
	public int getRegionNum() {
		return RegionNum;
	}
	/**
	 * Setter for the RegionNum private variable
	 * @param RegionNum - The int number that corresponds to the region that the Regional Manager manages
	 */
	public void setRegionNum(int RegionNum) {
		this.RegionNum = RegionNum;
	}
	/**
	 * Getter for the subordinates private variable
	 * @return subordinates - An array of employees that act as subordinates to the Regional Manager
	 */
	public Employee[] getSubordinates() {
		return subordinates;
	}
	/**
	 * Setter for the subordinates private variable
	 * @param subordinates - An array of employees that act as subordinates to the RegionalManager
	 */
	public void setSubordinates(Employee[] subordinates) {
		this.subordinates = subordinates;
	}
	/**
	 * Getter for the minimumTask private variable
	 * @return minimumTask - The lowest task priority that this RegionalManager has
	 */
	public int getMinimumTask() {
		return minimumTask;	
	}
	/**
	 * Setter for the minimumTask private variable
	 * @param minimumTask - The lowest task priority that this RegionalManager has
	 */
	public void setMinimumTask(int minimumTask) {
		this.minimumTask = minimumTask;
	}

	//    Formats 
	/**
	 * Format a string for output.
	 * Note: After EVERY colon (:) there MUST be a single space after it.
	 * Note: There must be NO newline (\n) at the very end of the entire string.
	 * Note: That the each Task is formatted exactly described in the Task’s toString method.
	 * @return output: A string with employee's name, ID, and task. 
	 */
	public String toString() {
		// Creates the string output will contain all of the information of the Regional Manager and its subordinates
		String output = "Regional Manager\nName: " + super.getName() + "\nID: " + super.getIDNumber();
		output += "\nTask List: ";

		// adds the task information for the RegionalManager through the Task's toString method
		for (int i = 0; i < super.getTaskList().length; i++) {
			Task[] toPrint = super.getTaskList();
			output += "\n" + toPrint[i].toString();
		}
		
		// adds region number and minimum task level to output string
		output += "\nRegion Number: " + RegionNum + "\nMinimum Task Level: " + minimumTask + "\nEmployees: ";
		
		// adds the information of all the subordinates from the toString method of each employee inside the subordinates array
		for (int i = 0; i < subordinates.length; i++) {
			Employee[] toPrint = subordinates;
			output += "\n" + toPrint[i].toString();
		}
		return output;
	}

/**
 * This method was provided complete.
 * DO NOT EDIT!
 * @param r Takes in a RegionalManager object.
 * @return equal A boolean- true when everything matches. 
 * @author Michael Arboleda
 */
public boolean equals(RegionalManager r){
	boolean equal = super.equals(r);
	equal = equal && (r.getRegionNum() == RegionNum);
	equal = equal && (r.getMinimumTask() == minimumTask);
	for(int i = 0; i < subordinates.length; i++){
		equal = equal && (subordinates[i].equals(r.getSubordinates()[i]));
	}
	return equal;
}
}