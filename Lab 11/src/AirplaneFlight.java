//Not complete
import java.util.Scanner;

public class AirplaneFlight {
	String departDest;
	String arrivalDest;
	double etd;
	double eta;


	//Constructor
	public AirplaneFlight(String departDest, String arrivalDest, double etd, double eta){
		this.arrivalDest= arrivalDest;
		this.etd = etd;
		this.eta = eta;
		this.departDest = "Gainesville, Florida";
	}

	public static void main(String[] args) {}
	
	public void displayFlight(){
		System.out.println("Departing Destination:\t" + departDest);
		System.out.println("Arrival Destination:\t" + arrivalDest);
		System.out.println("Est Time of Departure:\t" + formatTime(etd));
		System.out.println("Est Time of Arrival:\t" + formatTime(eta));
	}

	public static AirplaneFlight createFlight(){
		//Ask for Param.
		Scanner input = new Scanner(System.in);
		System.out.println("Please Enter Flight Information:");
		System.out.println("What is the Arrival Destination:");
		String arrivalDest=input.nextLine();
		System.out.println("What is Estimated Time of Departure:");
		double etd =input.nextDouble();
		System.out.println("What is Estimated Time of Arrival:");
		double eta =input.nextDouble();
		String departDest = "Gainesville, Florida";

		return new AirplaneFlight(departDest, arrivalDest, etd, eta);
	}
	public  AirplaneFlight changeFlight(){
		//Ask for new Param.
				Scanner input = new Scanner(System.in);
				System.out.println("Please Enter Flight Information:");
				System.out.println("What is the new Arrival Destination:");
				String arrivalDest=input.next();
				System.out.println("What is new Estimated Time of Departure:");
				double etd =input.nextDouble();
				System.out.println("What is new Estimated Time of Arrival:");
				double eta =input.nextDouble();
				String departDest = "Gainesville, Florida";

				return new AirplaneFlight(departDest, arrivalDest, etd, eta);
	}

	public String formatTime(double time){
		time = ((int)(time*100))/100.0;
		
		String y;
		//Check for AM or PM
		if(time>=12){
			y = "PM";
		}
		else {
			y = "AM";
		}
		
		//format time to string
		String x = Double.toString(time);
		x.replaceAll(".", ":");
		
		String time1 = x + " " + y;
		
		return time1;
	}

}
