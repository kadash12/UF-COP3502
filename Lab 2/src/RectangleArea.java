 import java.util.Scanner; 
 
	public class RectangleArea { 
	public static void main(String[] args) { 
		
	Scanner input = new Scanner(System.in); 
	System.out.print ("Length of the rectangle: ");
	int Length= input.nextInt();
	
	Scanner input2 = new Scanner(System.in); 
	System.out.print ("Width of the rectangle: ");
	int Width= input2.nextInt();
	
	int Area = Width * Length; 
	
	System.out.println ("The area of rectangle is: " + Area);
}
}