import java.util.Scanner;

public class CharacterCreator {

	public static void main(String[] args){
		int pet = 0;	//variable holder for pet selection
		String season = "  ";	// string holder for season
		int code = 0;	//variable holder for program selection

		System.out.println("What is your character's gender?");
		Scanner input = new Scanner(System.in);
		String gender = input.next();	// storing user input of gender

		System.out.println("What color is your character wearing?");
		String color = input.next();	//storing user input of color

		System.out.println("How long is your character hair? Enter an integer.");
		int length = input.nextInt();	//storing user input of hair length

		
		if (gender.equalsIgnoreCase("male") && color.equalsIgnoreCase("red")){ //This if statement checks for gender male and color red
			System.out.println("Does your character prefer cats or dogs? Enter 1 for cats or 2 for dogs.");
			pet = input.nextInt();
		}

		else{ //This runs if gender is not male or color is not red
			System.out.println("Does your character prefer winter or summer?");
			season = input.next();
		}
		
		if(gender.equalsIgnoreCase("female") && color.equalsIgnoreCase("green")) {//Checks female gender and if color is red
		}

		else if(gender.equalsIgnoreCase("female") || color.equalsIgnoreCase("green")){//this checks if either color is green or gender is female, and ask what code they prefer
			System.out.println("Does your character prefer coding in java or c++? Enter 1 for java or 2 for c++.");
			code = input.nextInt();
		}

		
		System.out.println("Your character is "+gender);
		System.out.println("Your character is wearing an awesome " + color+ " shirt.");

		if(length<5){ // checks hair length is less than 5 and runs a print 
			System.out.println("Your character has short hair.");
		}
		else if(length<10){//checks if hair length is less than 10 then prints the statement
			System.out.println("Your character has medium hair.");
		}
		else{// runs if the other if statements were false and prints long hair
			System.out.println("Your character has long hair.");
		}

		if (pet == 1){ // if user input for pets is 1 then print cats statement
			System.out.println("Your character really loves cats." );
		}
		else if(pet == 2){ //if user input is 2 then print dog statement
			System.out.println("Your character really loves dogs.");
		}

		if(season.equalsIgnoreCase("winter")){// checks to see if the season is winter and then prints that the character enjoys winter
			System.out.println("Your character really enjoys winter.");
		}
		else if(season.equalsIgnoreCase("summer")){// checks if the season is summer and then prints the character enjoys winter
			System.out.println ("Your character really enjoys summmer.");
		}
		if(code == 1){// if the picked java then the statement prints 
			System.out.println("Your character loves coding in java.");
		}
		else if(code == 2){//checks if they said c++
			System.out.println ("Your character loves coding in c++.");
		}

		if(color.equalsIgnoreCase("orange") || color.equalsIgnoreCase("blue")){// checks to see if the color is one of the gator colors
			System.out.println("Go Gators!");
		}

	}
}