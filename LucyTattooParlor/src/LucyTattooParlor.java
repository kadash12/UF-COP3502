import java.util.Scanner; 

/**
 *Project Summary: The program will allow for input of customer's name, tattoo, and wait time and at the end of the night, 
 *when enter a special customer name, "Print Waitlist",the program to print out the waitlists of all tattoo artists on the
 * screen, and then the program will end.  
 * @author Johnny Li
 * COP 3502 Section Number: 149A
 */
public class LucyTattooParlor {	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		//Create storage for the number of artists and wait list size
		int numbTattooArtists = Integer.parseInt(args[0]);
		int waitlist = Integer.parseInt(args[1]);

		TattooCustomer[][] tattooArtist = new TattooCustomer [numbTattooArtists][waitlist];

		while(true){
			TattooCustomer customer = TattooCustomer.getInfo(); 
			//User input  of Print Waitlist.
			String getName = customer.getName();

			//Command to end program.
			if(getName.equalsIgnoreCase("Print Waitlist")){
				display(tattooArtist);
			}

			//Ask the customer is they  wants a specific tattoo technician, or
			//if the customer just wants us to add them to the shortest wait list among all the technicians.
			System.out.println("Does the customer want a specific tattoo technician? Yes or No");
			String technician = input.next();
			if(technician.equalsIgnoreCase("yes")){
				System.out.println("Which specific tattoo technician does the customer want: (Enter a number)");
				int artistNum = input.nextInt();
				if(addCustomer(tattooArtist, customer, artistNum) == true){
					System.out.println("Customer was added to technician: " + artistNum);
				}
				else if (addCustomer(tattooArtist, customer, artistNum) == false){
					System.out.println("Customer was not added to technician: " + artistNum);
				}
			}
			else if(technician.equalsIgnoreCase("no")){
				if(addCustomer(tattooArtist, customer) == true){
					System.out.println("Customer was added to waitlist.");
				}
				else if (addCustomer(tattooArtist, customer) == false){
					System.out.println("Customer was not added to the waitlist.");
				}
			}
		}
	}
	/** 
	 *	Computes how many minutes of work the specified tattoo artist has.  
	 *	@param The array of customers for one particular tattoo artist 
	 */ 
	public static int computeMinutesOfWork(TattooCustomer [] a) { 
		//Computes the total time for artist.
		int totalTime =0;
		for (int i=0; i<a.length; i++){
			if(a[i] != null){
				totalTime += a[i].getMinutes();
			}
		}
		return totalTime; 
	} 

	/** 
	 *	Adds customer to the waitlist for a specific artist.  
	 *	If the artist is at capacity (in terms of number of customers or minutes) 
	 *	Then the customer is not added and the method returns false 
	 *	If the customer is successfully added the method returns true 
	 *	@param  
	 */ 
	public static boolean addCustomer(TattooCustomer [][] a, TattooCustomer c, int artistNum) { 
		//Check if artist is a capacity. Return false if at capacity and return true if not at capacity.
		boolean test = false;
		int artistMinutes = computeMinutesOfWork(a[artistNum]);
		int currentTime = c.getMinutes();
		if ((artistMinutes + currentTime)<=480){
			for(int i =0; i<a[artistNum].length; i++){
				//Place customer onto artist list.
				if(a[artistNum][i]== null){
					a[artistNum][i] = c;
					test = true;
					break;
				}
			}	
		}
		return test;
	} 

	/** 
	 *	Adds customer to the shortest waitlist in terms of minutes. If some artists have equal length waitlists  	
	 * then the customer is added to the lowest numbered artist. If no artist has space then the method does not  	
	 * add the customer, and returns false.   	
	 * TODO - finish this javadoc 
	 *	@return true if the customer was added to the waitlist, false otherwise (if all artists were full)  
	 */ 
	public static boolean addCustomer(TattooCustomer [][] a, TattooCustomer c) { 
		//Check if artist is a capacity. Return false if at capacity and return true if not at capacity.
		boolean test = false;
		int currentTime = c.getMinutes();
		int shortest =computeMinutesOfWork(a[0]);
		int artistNum=0;
		int artistMinutes=0;
		for(int i = 0; i<a.length; i++){
			artistMinutes = computeMinutesOfWork(a[i]);
			//Check for shortest time.
			if (shortest>=artistMinutes){
				shortest = artistMinutes;
				artistNum = i;
			}
		}
		//Check total time
		if (shortest + currentTime<=480){
			//Places customer onto waitlist.
			for(int w = 0; w<a[artistNum].length; w++){	
				if(a[artistNum][w] == null){
					a[artistNum][w] = c;
					test = true;
					break;
				}
			}
		}
		return test;
	}
	/**
	 * Formats output for display and prints it.
	 * @return customerTattoo: Formatted output string for the the array to store.
	 */
	public static void display(TattooCustomer [][] tattooArtist){
		for(int a = 0; a<tattooArtist.length; a++){
			for(int b = 0; b<tattooArtist[a].length; b++){
				//Format output string and prints.
				if (tattooArtist[a][b] != null){
					System.out.println("Artist: " + a);
					String customerTattoo ="Customer name: " + tattooArtist[a][b].getName() + ", Tattoo design: " + 
							tattooArtist[a][b].getTattoo() + ", Expected time: " + tattooArtist[a][b].getMinutes() + " minutes";
					System.out.println(customerTattoo);
				}
			}
		}
		//Ends program.
		System.exit(0);
	}
}
