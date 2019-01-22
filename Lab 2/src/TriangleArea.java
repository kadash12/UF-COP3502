import java.util.Scanner; 
 
	public class TriangleArea { 
	public static void main(String[] args) { 
		
	Scanner input = new Scanner(System.in); 
	System.out.print ("Base of the Triangle: ");
	int Base= input.nextInt();

	Scanner input2 = new Scanner(System.in); 
	System.out.print ("Height of the Triangle: ");
	int Height= input2.nextInt();
	
	
	double Area = 0.5 * Base * Height;
	System.out.println ("The area of Triangle is: " + Area);
}
}