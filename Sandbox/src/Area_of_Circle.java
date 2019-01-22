import java.util.Scanner;

public class Area_of_Circle {

	public static void main(String[] args) {
		//Input radius of circle with only two decimal place.
		Scanner input = new Scanner(System.in); 
		System.out.print ("Type a radius for the circle: ");
		double Radius= input.nextDouble();

		double Area = Math.pow(Radius,2)*Math.PI; 

		Area *=100;
		Area = (int)Area;
		Area /= 100;

		System.out.println ("The area of circle is: " + Area);

	}

}
