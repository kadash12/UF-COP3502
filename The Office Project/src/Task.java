/**
 * This class creates an Task object and formats it to a output string to be printed. 
 * Note: Task must be Immutable
 * @author Johnny Li and Colby Lathrop
 */
public class Task {
	//Declare private variables.
	private String name;
	private int level;

	/**
	 *Constructor
	 *@param name: The string name of the task.
	 *@param level: A int number of priority of task.
	 *@return Task: An object with the content of int IDNumber, String name, Task[] taskList.
	 */ 
	Task(String name, int level){
		this.name = name;
		this.level = level;
	}
	
	//Collection of Getters and Setters.
		/**
		 * Getter for name.
		 * @return name
		 */
		String getName (){
			return name;
		}
		/**
		 * Getter for level.
		 * @param level
		 */
		int getLevel(){
			return level;
		}
		
		/**
		 * Format a string for output.
		 * Note: After EVERY colon (:) there MUST be a single space after it.
		 * Note: There must be NO newline (\n) at the very end of the entire string.
		 * Note: That the each Task is formatted exactly described in the Task’s toString method.
		 * @return output: A string with employee's name, ID, and task. 
		 */
		public String toString(){
			// Creates the string that contains the formatted information for the task
			String output = "\tTask: " + getName() + "\tLevel: " + getLevel();
			return output;
		}

	/**
	 * This method was provided complete.
	 * DO NOT EDIT!
	 * @return: A boolean- true when everything matches. 
	 * @author Michael Arboleda
	 */
	public boolean equals(Task t){
		return ((t.getLevel() == level) && (t.getName().equals(name)));
	}
}