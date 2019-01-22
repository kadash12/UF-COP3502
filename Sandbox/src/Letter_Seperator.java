import java.util.Scanner; 

public class Letter_Seperator {

	public static void main(String[] args) {
		//Read string input and print each letter on a separate line.
				String a; 
				System.out.println("Type in a message");
				Scanner input = new Scanner(System.in);
				a = input.nextLine(); 
				int n;
				for (n=0; n < a.length(); n++){
				System.out.println(a.charAt(n));
				}

	}

}
