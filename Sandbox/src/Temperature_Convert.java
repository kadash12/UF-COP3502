import java.util.Scanner; 

public class Temperature_Convert {
	public static void main(String[] args) {
		//Fahrenheit to Celsius
		System.out.print ("Enter a temperature in Fahrenheit: ");
		Scanner input = new Scanner(System.in);
		double fah= input.nextDouble();
		System.out.print ("Temperature in Celsius is " + (5.0/9)*(fah-32));
	}
}