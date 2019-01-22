import java.util.Scanner;
public class HiFive_HiEven {
	public static void main(String[] args) { 
		//If divide by 5 print HiFive, and if divide by 2 print HiEven
		Scanner input = new Scanner(System.in); 
		System.out.print ("Type a number: ");
		int x= input.nextInt();
		if (x % 5 == 0){
			System.out.println("HiFive");
		}
		else {
			if (x % 2 == 0){ 
				System.out.println("HiEven");
			}
		}
	}
}
