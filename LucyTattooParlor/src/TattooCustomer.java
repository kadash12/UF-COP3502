import java.util.Scanner; 
/**
 * Secondary class: Tattoo Customer 
 * Ask for customer information and return the information.
 * @author Johnny Li
 */
public class TattooCustomer {
	//Declare private variable.
	private String getName;
	private String getTattoo;
	private int getMinutes;

/**
 * Constructor
 * @param getName: Name of customer.
 * @param getTattoo: Design of Tattoo.
 * @param getMinutes: Time it takes for tattoo.
 */
	public TattooCustomer(String getName, String getTattoo, int getMinutes){
		this.getName = getName;
		this.getTattoo = getTattoo;
		this.getMinutes = getMinutes;
	}


	public static void main(String[] args) {}

/**
 * Method of asking for customer information.
 * @return TattooCustomer(getName,getTattoo,getMinutes) as an object with the param of customer information.
 */
	public static TattooCustomer getInfo() {
		Scanner input = new Scanner(System.in);

		//User input  of customer name, tattoo design, and tattoo time (in hours).
		System.out.println("Please enter the customer's name:");
		String getName = input.nextLine();
		//
		//Return print waitlist to main class.
		if(getName.equalsIgnoreCase("Print Waitlist")){
			return new TattooCustomer(getName,null,0);
		}

		System.out.println("Please enter the tattoo design:");
		String getTattoo = input.next();

		System.out.println("Please enter the time (in minutes) it will take to complete the tattoo:");
		int getMinutes = input.nextInt();
		return new TattooCustomer(getName,getTattoo,getMinutes);
	}
	/**
	 * Return New input of additional time for artist to be added to total time.
	 * @return getMinutes: Additional time for artist.
	 */
	public int getMinutes(){
		return getMinutes;
	}
	/**
	 * * @return getName: Return name of customers.
	 */
	public String getName(){
		return getName;
	}
	/**
	 * @return getTattoo: Return design of tattoo.
	 */
	public String getTattoo(){
		return getTattoo;
	}	
}