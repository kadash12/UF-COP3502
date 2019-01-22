import java.util.Scanner;

public class IdeaSpread {
	public static void main (String [] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("How many people will you share your "
				+ "majorly controversial idea with, risking loss of "
				+ "friendship and respect?");
		int followers = input.nextInt();
		
		double percent = Math.random();

		int multi = (int) (percent*1000);
		double post = (double) (multi/1000.0);
		System.out.println ("Assuming "+multi/10.0 + "% will share it with exactly the same number of friends that you did, and the same % will then agree with it..."); 
		int retweets = (int) (post*followers);
		System.out.println(retweets+" will share in the first round after you");
		double total = retweets*(Math.pow(retweets,4)-1)/(retweets-1);
		
		System.out.println("Projecting four rounds into the future...");
		System.out.println("There will be " + total + " shares after the fourth round.");



	}

}
