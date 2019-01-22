/**
 * This class creates an SalesAssociate object and formats it to a output string to be printed. 
 * Note: Sales Associates have a minimum task level of 1.
 * @author Johnny Li and Colby Lathrop
 */
public class SalesAssociate extends Employee{
	//Declare private variables.
	private int numClients;
	private String[] products;
	private RegionalManager supervisor;

	/**
	 *Constructor
	 *@param IDNumber The int number of the Employee.
	 *@param name The string name of the Employee.
	 *@param taskList A Task (object) array of tasks.
	 *@param numClients A int number of Clients.
	 *@param String[] products A string array of products.
	 *@param RegionalManger supervisor A RegionalManager (object) of the supervisor. 
	 *@return SalesAssociate int IDNumber, String name, Task[] taskList, int numClients, String[] products, RegionalManager supervisor.
	 */ 
	SalesAssociate(int IDNumber, String name, Task[] taskList, int numClients, String[] products, RegionalManager supervisor){
		super.setIDNumber(IDNumber);
		super.setName(name);
		super.setTaskList(taskList);
		this.numClients = numClients;
		this.products = products;
		this.supervisor = supervisor;
	}

	//Collection of Getters and Setters.
	/**
	 * Getter for numClients.
	 * @return numClients
	 */
	int getNumClients (){
		return numClients;
	}
	/**
	 * Setter for numClients.
	 * @param numClients
	 */
	void setNumClients(int numClients){
		this.numClients = numClients;
	}
	/**
	 * Getter for products.
	 * @return products
	 */
	String[] getProducts (){
		return products;
	}
	/**
	 * Setter for products.
	 * @param products
	 */
	void setProducts(String[] products){
		this.products = products;
	}
	/**
	 * Getter for supervisor.
	 * @return supervisor
	 */
	RegionalManager getSupervisor(){
		return supervisor;
	}
	/**
	 * Setter for supervisor.
	 * @param supervisor
	 */
	void setSupervisor (RegionalManager supervisor){
		this.supervisor = supervisor;
	}

	/**
	 * Format a string for output.
	 * Note: After EVERY colon (:) there MUST be a single space after it.
	 * Note: There must be NO newline (\n) at the very end of the entire string.
	 * Note: That the each Task is formatted exactly described in the Task’s toString method.
	 * @return output A string with title, employee's name, ID, task, Regional Manger, and number of clients. 
	 */
	public String toString(){
		// Creates the string output will contain all of the information of the SalesAssociate
		String output = "Sales Associate\nName: " + super.getName() + "\nID: " + super.getIDNumber() + "\nTask List: ";
		
		// adds the task information for the RegionalManager through the Task's toString method
    	for (int i = 0; i < super.getTaskList().length; i++) {
    		Task[] toPrint = super.getTaskList();
    		output += "\n" + toPrint[i].toString();
    	}
    	
    	// adds the supervisor and numClients information to the output string
    	output += "\nRegional Manager: " + supervisor.getName() + "\nNumber of clients: " + numClients + "\nProducts to sell: ";
    	
    	// adds the strings of products to output string
    	for (int i = 0; i < products.length; i++) {
    		String[] toPrint = products;
    		output += "\n\t" + toPrint[i].toString();
    	}
    	
		return output;
	}

	/**
	 * This method was provided complete.
	 * DO NOT EDIT!
	 * @param s Takes in a SalesAssociate object.
	 * @return equal A boolean- true when everything matches. 
	 * @author Michael Arboleda
	 */
	public boolean equals(SalesAssociate s){
		boolean equal = super.equals(s);
		equal = equal && (s.getNumClients() == numClients);
		equal = equal && (s.getSupervisor().equals(supervisor));

		for(int i = 0; i < products.length; i++){
			equal = equal && (products[i].equals(s.getProducts()[i]));
		}
		return equal;
	}

}