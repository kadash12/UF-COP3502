import java.util.Scanner;

public class Hexabowling {

	public static void main(String[] args) {

				//Ask user questions about games/frames
				System.out.println("How Many Games would you like to bowl today?");
				Scanner input = new Scanner(System.in);
				int game;
				game = input.nextInt();
				System.out.println("How Many frames would you like to bowl?");
				int frame;
				frame = input.nextInt();

				//Nested Loops
				int m; 
				int n;
				
				for (m=0; m<game; m++) {

					System.out.println("Game " +(m+1)+ " Results:");

					for (n=0; n<frame; n++) {
						int throw1 = 0;
						int throw2 = 0;
						int throw3 = 0;
						throw1 = (int) ((Math.random()) * 16);
						
						if (15>throw1){
							throw2 = (int) ((Math.random()) * (16-(throw1)));
							}
						
						if(throw1+throw2<15){
							throw3 = (int) ((Math.random()) * (16-(throw1+throw2)));
						}
						
						//Initializing throw values to Hexadecimals
						String value1 = Integer.toHexString(throw1);
						String value2 = Integer.toHexString(throw2);	
						String value3 = Integer.toHexString(throw3);

						//Printing Game Results
						String strike = ""; 
						if (throw1==15) {
							strike = ("WAAAHOOO what a Strike!");
						}
						else if ((throw1+throw2+throw3) == 15){
							strike = "Nice Spare!";
						}
						
						else if ((throw1==0) || (throw2==0) || (throw3==0)) {
							strike = "Omg!!¦ a gutter ball";
						}
						System.out.println("Frame " +(n+1)+ '\t' + "|" + '\t' +value1+value2+value3+ '\t' +  "|" +
								'\t' + strike);
					}	
				}
						//Ending Statement
						System.out.println("What a day! Thank you for playing!");
			}
	}