import java.util.Scanner; 

public class Calculator {
	public static void main(String[] args) { 

		Scanner input = new Scanner(System.in);

		System.out.println("What number would you like to stop at (as an integer)?");
		int totalNum = input.nextInt();


		System.out.println("Enter a starting number:");
		double sumNum = input.nextDouble();

		String func = null;

		while (totalNum > Math.abs(sumNum)){

			/*while(!(func.equals('*')) || !(func.equals('/')) || !(func.equals('+')) || !(func.equals('-'))){
				System.out.println("Invalid operation!");
				System.out.println("What operation would you like to do? Multiplication(*), Division(/), Subtraction(-), or Addition(+)");
				func = input.next();
			}*/
			
			System.out.println("What operation would you like to do? Multiplication(*), Division(/), Subtraction(-), or Addition(+)");
			func = input.next();
			
			
			int newNum = 0;

			switch(func){
			case "*": { 
				System.out.println("Enter your new number: ");
				newNum = input.nextInt();
				sumNum = sumNum * newNum;  
				System.out.println ("Your running total is " + (double)Math.round(sumNum));
			break;}
			case "/": {
				System.out.println("Enter your new number: ");
				newNum = input.nextInt();
				sumNum = sumNum / newNum;  
				System.out.println ("Your running total is " + (double)Math.round(sumNum));
			break;}
			case "-": {
				System.out.println("Enter your new number: ");
				newNum = input.nextInt();
				sumNum = sumNum - newNum;  
				System.out.println ("Your running total is " + (double)Math.round(sumNum)); 
			break;}
			case "+": { 
				System.out.println("Enter your new number: ");
				newNum = input.nextInt();
				sumNum = sumNum + newNum;  
				System.out.println ("Your running total is " + (double)Math.round(sumNum));
			break;}
			default:{
				System.out.println("Invalid operation!");
			break;}
			}
		}
		System.out.println("Your final result is " + sumNum);
	}
}