import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Project Summary:
 * @author Johnny Li and Colby Lathrop 
 * COP 3502 Section Number: 149A
 */
public class TheOffice {
	//Declare private variable.
	private Employee[] workers;

	// Collection of Getters and Setters
	/**
	 * Getter for the manager private variable 
	 * @return workers - The Employee object array that contain Employee.
	 */
	public Employee[] getWorkers() {
		return workers;
	}
	/**
	 * Setter for the workers private variable
	 * @param workers
	 */
	public void setWorkers(Employee[] workers) {
		this.workers = workers;
	}
	/**
	 * Setter for the manager private variable
	 * @param workers - The Employee object array that contain Employee.
	 */
	public void setWorks(Employee[] workers) {
		this.workers = workers;
	}

	/**
	 * Constructor with no argument.
	 */
	TheOffice(){}

	/**
	 * This method was provided partial complete.
	 * DO NOT EDIT!
	 * @author Michael Arboleda
	 */
	TheOffice(String fileLoc) throws TaskLevelException{
		//This is used to read a file.
		Scanner fs = null;
		File f = null;

		//Try Catch on file
		try{ 
			f = new File(fileLoc); 
			fs = new Scanner(f); 
		}
		catch(FileNotFoundException e){ 
			System.out.println("FileNotFoundException: The file \""+ fileLoc + "\" could not be found.");
		}

		//First Line is number of employees
		int size = Integer.parseInt(fs.nextLine());
		workers = new Employee[size];

		//This might be useful, feel free to delete, or not use these		
		RegionalManager manager = null;
		int supremum = 0;
		AssistantRegionalManager assistantManager = null;
		SalesAssociate sales = null;
		Receptionist recep = null;
		int ATRM = 0; 

		//Loops through file
		for(int i = 0; i < size; i++){
			//Sets temp variables for all possible member variables
			int IDNumber = -1;
			String name = null;
			Task[] taskList = null; 
			int RegionNum = -1; 
			int minimumTask = -1;
			int numClients = -1;
			String[] products = null;
			int maxTaskComplexityLevel = -1;

			//Check which type of employee
			String type = fs.nextLine().trim();

			//Get Standard information (id, name)
			IDNumber = Integer.parseInt(fs.nextLine().trim());
			name =  fs.nextLine();

			//Gets number of tasks and makes a task array based on the size
			int tasks = Integer.parseInt(fs.nextLine().trim());
			taskList = new Task[tasks];

			//Fills up Task List
			for(int j = 0; j < tasks; j++){
				//Gets information for task
				String work = fs.nextLine();
				int num = Integer.parseInt(fs.nextLine().trim());

				//Sets task at array spot
				taskList[j] = new Task(work, num); 
			}

			//Scanner read for Regional Manager. Use this as an example to do the other 3 types
			if(type.equals("RegionalManager")){
				//Gets Region Number and Minimum Task Level
				RegionNum = Integer.parseInt(fs.nextLine().trim());
				minimumTask = Integer.parseInt(fs.nextLine().trim());

				//Loop through the Task list
				for(int j = 0; j < taskList.length; j++ ){
					//If a task is below the minimum task level, throw exception
					if(taskList[j].getLevel() < minimumTask){
						throw new TaskLevelException(taskList[j].getLevel());
					}
				}			

				//set manager to new regional manager
				manager = new RegionalManager(IDNumber, name, taskList, RegionNum, minimumTask);

				//set workers[i] to regional manager
				workers[i] = manager;

				//Set supremum (Might be useful)
				supremum = minimumTask;
			}
			else if(type.equals("AssistantRegionalManager")){
				//Get Minimun Task Level
				minimumTask = Integer.parseInt(fs.nextLine().trim());

				//Checks if a assistant manager has been called and if so the assistant manager is updated to the value of 
				//current employee being checked
				if (ATRM == 0){
					ATRM++;
					assistantManager = (AssistantRegionalManager) workers[i];
				}

				//Copied code from Michael Arboleda original code fo RegionalManager.
				//Loop through the Task list
				for(int j = 0; j < taskList.length; j++ ){
					//If a task is below the minimum task level, throw exception
					if(taskList[j].getLevel() < minimumTask){
						throw new TaskLevelException(taskList[j].getLevel());
					}
				}

				//set assistantManager to new assistant regional manager
				assistantManager = new AssistantRegionalManager( IDNumber, name, taskList, manager, minimumTask);
				//set workers[i] to assistant regional manager
				workers[i] = assistantManager;
			}
			else if(type.equals("SalesAssociate")){
				//Get Number of Clients
				numClients = Integer.parseInt(fs.nextLine().trim());
				int y = Integer.parseInt(fs.nextLine().trim());

				//Copied code from Michael Arboleda original code of RegionalManager.
				//Loop through the Task list
				for(int j = 0; j < taskList.length; j++ ){
					//If a task is below the minimum task level, throw exception
					if(taskList[j].getLevel() < minimumTask){
						throw new TaskLevelException(taskList[j].getLevel());
					}
				}
				//set products in sales associate
				products = new String [y];
				for(int t = 0; t<y; t++){
					products[t] = fs.nextLine();
				}
				//set sales to new assistant sales associate
				sales = new SalesAssociate(IDNumber, name, taskList, numClients, products, manager);
				//set workers[i] to sales associate
				workers[i] = sales;
			}
			else if(type.equals("Receptionist")){
				//Get Max Task Complexity Level
				maxTaskComplexityLevel = Integer.parseInt(fs.nextLine().trim());

				//Copied code from Michael Arboleda original code of RegionalManager.
				//Loop through the Task list
				for(int j = 0; j < taskList.length; j++ ){
					//If a task is below the minimum task level, throw exception
					if(taskList[j].getLevel() < minimumTask){
						throw new TaskLevelException(taskList[j].getLevel());
					}
				}
				//set recep to new Receptionist
				recep = new Receptionist(IDNumber, name, taskList, assistantManager, maxTaskComplexityLevel);
				//set workers[i] to recep
				workers[i] = recep;
			}
		}

		//Set up Employee Arrays for regional manager
		Employee[] a = new Employee[size -1];
		for(int i = 0, j = 0; i < workers.length; i++){
			if(!(workers[i] instanceof RegionalManager)){
				a[j++] = workers[i];
			}
		}

		//If there is a manager, set the subordinate array
		if(manager != null){
			manager.setSubordinates(a);
		}

		//Check if there is an AssistantManager and changes the supervisor of every Receptionist object in the workers
		//array to the first AssistanceManager
		if(assistantManager != null){
			for(int i =0 ; i<workers.length; i++){
				if(workers[i] instanceof Receptionist){
					recep = (Receptionist) workers[i];
					recep.setSupervisor(assistantManager);}
			}
		}
	}


	/**
	 * Format a string for output.
	 * Note: After EVERY colon (:) there MUST be a single space after it.
	 * Note: There must be NO newline (\n) at the very end of the entire string.
	 * Note: That the each Task is formatted exactly described in the Task’s toString method.
	 * @return output: A final string with complete content. 
	 */
	public String toString(){
		//Create string to store output
		String output = "";

		//Loop through the entire office and adds the information of the employee
		for(int i=0; i<workers.length; i++){
			if (workers[i] instanceof RegionalManager){
				output += workers[i].toString();
			}
		}
		return output;
	}

	/**
	 * This method will make and return a string that has employees’ name and their minimum task level. 
	 * Note: that there must be NO newline (\n) at the very end of the entire string. 
	 * Note: The display is not done inside this method.
	 * @return output A string that has employees’ name and their minimum task level.
	 */
	public String levelDisplay (){
		//variable to store format output string.
		String output = "";
		//Creates a counter to prevent extra line for Regional Manager.
		int workersCounter = 0;
		
		for(int i=0; i<workers.length; i++){
			//This first if-statement was created with the assistance of TA Kevin Marin.
			//Check if the employee is a regional manager.
			if(workers[i] instanceof RegionalManager){
				//Format output.
				if (workersCounter == 0){
					output += "Name: "+ workers[i].getName() + "\tLevel: " + ((RegionalManager)workers[i]).getMinimumTask();
					workersCounter++;
				}
				else {
					output += "\nName: "+ workers[i].getName() + "\tLevel: " + ((RegionalManager)workers[i]).getMinimumTask();
				}
			}
			//Check if the employee is a assistant regional manager. 
			if(workers[i] instanceof AssistantRegionalManager){
				//Format output.
				if (workersCounter == 0) {
					output += "Name: "+ workers[i].getName() + "\tLevel: " + ((AssistantRegionalManager)workers[i]).getMinimumTask();
					workersCounter++;
				}
				else{
					output += "\nName: "+ workers[i].getName() + "\tLevel: " + ((AssistantRegionalManager)workers[i]).getMinimumTask();
				}
			}
			//Check if the employee is a assistant regional manager. 
			if((workers[i] instanceof SalesAssociate) || (workers[i] instanceof Receptionist)){
				//Format output.
				if (workersCounter == 0) {
					output += "Name: "+ workers[i].getName() + "\tLevel: " + 1;
					workersCounter++;
				}
				else{
					output += "\nName: "+ workers[i].getName() + "\tLevel: " + 1;
				}
			}			
		}
		return output;
	}
	/**
	 * This method was provided complete.
	 * DO NOT EDIT!
	 * @author Michael Arboleda
	 * @param args A command line argument input.
	 */
	public static void main(String[] args) throws TaskLevelException{
		//Gets location for file
		TheOffice o = new TheOffice((args[0]+".txt"));

		//Prints office, then the current level display
		System.out.println(o + "\n\n\n" + o.levelDisplay());

		//Sorts(by name) the employee array
		Sorter.sort(o.getWorkers());

		//Prints the sorted(by name) level display
		System.out.println("\n\n\n" + o.levelDisplay());
	}

}