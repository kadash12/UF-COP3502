import java.util.Scanner;

public class Tip_Calculator {

	public static void main(String[] args){
		// Import scanner object
		Scanner input = new Scanner(System.in);

		System.out.println("What is the amount for your bill?");		
		double billAmount = input.nextDouble();
			
		System.out.println("What percent do you want to tip for gratuity? (as an integer)");
		int percent = input.nextInt();

		System.out.println("What is your server's name?");
		String serverName = input.next();
		
		double tip = calculateTip(billAmount, percent);
		String message = tipMessage (tip, serverName);
		// Print out tip and message using methods
		System.out.println("Your tip is $" + tip + ". " + message );

	}
	
	// Method to calculate tip
	public static double calculateTip (double billAmount, int percent) {
		double tip = billAmount * (percent/100.0);
		return tip; // return tip value as a double
	}

	// Method to message server according to tip amount
	public static String tipMessage (double tip, String serverName) {
		String message = null; // initialize message variable

		// Conditions for what message to display
		if (tip<=5){
			message= "Thanks for your help, "+ serverName + ". :)"; 
		}
		else if (tip<10 && tip>5){
			message = "";
		}
		else if (tip>=10){
			// Determine number of exclamation marks
			String end = "";
			int i=0; 
			while (i< (int)(Math.random()*12)) {
				end = end+ "!";
				i++;
			}
			message = "Have a nice day, " + serverName + ". Don't spend it all in one place" + end;
			
		}
		return message;
	}
}
