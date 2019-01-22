import java.util.Scanner; 
 
	public class DigitSeparator { 
	public static void main(String[] args) { 
		
	Scanner input = new Scanner(System.in); 
	System.out.print ("Please Input a numer: ");
	int Value = input.nextInt();
	
	System.out.println("The thousands digit is "+ Value/1000);
	System.out.println("The hundreds digit is "+ (Value/100)%10);
	System.out.println("The tens digit is " + (Value/10)%10);
	System.out.println("The ones digit is "+Value%10);
	}
	}