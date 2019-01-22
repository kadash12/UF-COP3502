//Not complete
import java.util.Scanner;

public class JavaAirlines {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Hello and Welcome to Java Airlines!\nWhat will be the flight schedule for today?\n");

		//Make the three airplane flights
		AirplaneFlight flight1 = AirplaneFlight.createFlight(); 
		AirplaneFlight flight2 = AirplaneFlight.createFlight(); 
		AirplaneFlight flight3 = AirplaneFlight.createFlight(); 

		while (true){
			System.out.println("\nMain Menu"); 
			System.out.println("1. View Plane Flight");  
			System.out.println("2. Change Flight Information");
			System.out.println("3. Exit");

			System.out.print("\nInput: ");
			int option = input.nextInt();
			System.out.println();

			AirplaneFlight plane =null;

			//Change flight
			System.out.print("\nEnter Flight Number: ");
			int flight = input.nextInt();
			System.out.println();
		
			if(flight==1){
				plane =  flight1;
			}
			else if (flight==2){
				plane =  flight2;
			}
			else if (flight == 3){
				plane =  flight3;
			}

			//View Plane Flight
			if (option==1){
				plane.displayFlight();

			}

			//Change Flight
			else if (option==2){
				plane.changeFlight();
			}

			//Exit
			else if (option == 3){
				break;
			}
		}
		System.out.println("Thank you for flying with Java Airlines!");
	}
}
