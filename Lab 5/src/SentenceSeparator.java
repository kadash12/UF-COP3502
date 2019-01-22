import java.util.Scanner; 

public class SentenceSeparator {

	public static void main(String[] args) {
	
		System.out.println("Enter your sentence");
		Scanner input = new Scanner(System.in);
		String sentence = input.nextLine(); 
		
		//Working code
		for (String retval: sentence.split(" ")){
		System.out.println(retval);
		}		
		
		}
	}


