import java.util.Scanner; 
 
	public class Division { 
	public static void main(String[] args) { 
		
	Scanner input = new Scanner(System.in); 
	System.out.print ("Please input the dividened: ");
	int Dividened= input.nextInt();
	
	Scanner input2 = new Scanner(System.in); 
	System.out.print ("Please input the divisor: ");
	int Divisor= input2.nextInt();
	
	System.out.print ("The quotient is " + Dividened/Divisor + " with a remainder of " + Dividened%Divisor);
	
}
}