//Do not edit this imports
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Scanner;

/**
 * Project Summary: The program will decode poems that are written in hexadecimal in a post-apocalyptic era.
 * The program will break a string of hex digits to pairs of hexadecimal then convert them to decimal form
 * which will be reference back to an ASCII table in order to obtain an alphabet letter. After decoding the hex string 
 * into a string of English letters, the program will returns all words of length 4, 5, and 6 that occur in the string 
 * of English letters by matching a combination of letters to those that exist in a given dictionary. A "sliding window", 
 * same characters may be members of more than one word, is considered. Then the program formats a poem with the words found 
 * according to Poetry Movement specifications of having at most one word of each length per line. 
 * @author Johnny Li
 * COP 3502 Section Number: 149A
 *
 */
public class PoetryDecoder {
	
	/**
	 * This main method asks the user to enter input. Then, it calls
	 * the decode method on that input. 
	 * DO NOT EDIT this main method. 
	 * Note: This is the only method that has System.out output. 
	 * @param args This main method does not take command line args. 
	 * by Dr. Kristy Boyer
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Prompt the user enter an input of hexadecimal.
		System.out.println("Please enter your input: ");
		String hex = sc.nextLine();

		//Display poem. 
		System.out.print(decode(hex));
		
		sc.close();
	}

	/**
	 * This decode methods calls other methods and rely the formated poem to the main method to be printed.
	 * Returns the formatted poem.
	 * @param hex The string of hex digits that is to be decoded.
	 * @return A String representing an entire decoded poem of English words. 
	 * Note: The returned string includes line breaks and spacing.
	 * by Dr. Kristy Boyer
	 */
	public static String decode(String hex) {

		//Translate the hex string into English characters. 		
		String englishLetters = toEnglishLetters(hex);

		//If word length is less than 4 letters return nothing.
		String[] shortest;
		if (englishLetters.length() < 4){
			shortest = findWordsOfLength(englishLetters,0);
		}
		else{
			//Search the string to extract all four-letter words and store them in one array. 
			shortest = findWordsOfLength(englishLetters,4);
		}

		//If word length is less than 5 letters return nothing.
		String[] medium;
		if (englishLetters.length() < 5){
			medium = findWordsOfLength(englishLetters,0);
		}
		else{
			//Search the string to extract all five-letter words and store them in one array. 
			medium = findWordsOfLength(englishLetters,5);
		}
		
		//If word length is less than 6 letters return nothing.
		String[] longest;
		if (englishLetters.length() < 6){
			longest = findWordsOfLength(englishLetters,0);
		}
		else{
			//Search the string to extract all six-letter words and store them in one array. 
			longest = findWordsOfLength(englishLetters,6);
		}

		//Return formatted poem.
		return formatPoem(shortest, medium, longest);
	}

	/**
	 * This method takes a String of hex characters and, chunking them two at a time (forming sets of two),
	 * finds a corresponding English letter according to the ASCII table. If the String of 
	 * hex characters is of odd length, the final hex character is IGNORED. 
	 * The program convert hexadecimal to decimal values and then convert decimals to English letters
	 * If the decimal value is not inside the ASCII range for letters, the decimal value will be mod the value by 26 
	 * and mapped to an ASCII letter based on the result.	
	 * Returns a string of English letters.
	 * @param String hex: String of hex characters. If the String is of odd length, the final hex
	 * character is ignored and not translated.	 
	 * @return String: the String of English letters. Each letter came from a pair of hex
	 * digits in the original input String. 
	 * by Dr. Kristy Boyer
	 */
	public static String toEnglishLetters(String hex){
		//Array for storing letters. Size of the array is half the length of hex string because the characters are paired together.
		char [] letterList=new char [hex.length()/2] ;

		//Initial variable value for array.
		int count = 0; 

		//Variable for length of hex string.
		int length;

		//If string contains an even number of hexadecimal value then use the hexadecimal string length.
		if (hex.length()%2 ==0 ){
			length = hex.length();
		}
		//If string contains an odd number of hexadecimal value then ignore last hexadecimal in string.
		else {
			length = hex.length()-1;
		}

		//Separate string of hexadecimal into pairs.
		for (int i = 0; i < length; i+=2) {
			String hexValue = hex.substring(i, i+2);

			//Convert hexadecimal to its decimal form.
			int decimalValue = Integer.parseInt(hexValue, 16);

			//Check if the decimal is within ASCII range. 
			//Capital case letter range between 65-90. Lower case letter range between 97-122.
			//Setup: Not inside capital case range or inside lower case range. 
			if (!((65 <= decimalValue && decimalValue <= 90) || (97 <= decimalValue && decimalValue <=122))){
				//If not in capital case letter range or lower case letter range mod by 26.
				//Addition of 97 makes it equivalent to 
				decimalValue = decimalValue%26 + 97;
			}

			//Convert decimal to its character form and storing letters in a array.
			letterList[count] = (char) decimalValue;

			//Increment variable value for array.
			count++;
		}
		//String for storing the letters.
		String toEnglishLetters = String.valueOf(letterList);

		return toEnglishLetters;
	}

	/**
	 * This method searches an input String of English letters, and returns all words of 
	 * the specified length that occur in the String. A "sliding window" will be considered, so 
	 * a given character could occur in more than one word that is found. 
	 * 
	 * The size of the array returned is the number of possible words that can be made from the string,
	 * based on the size of the string passed and the word size to be found. 
	 * 
	 * The method uses isWord to check if the word is a actual word in the dictionary and store the word or null if it is 
	 * not a actual word in the array. The output array fills up in the order that the valid words of that length are
	 * encountered. Example: So the first word found goes to index 0, second word goes to index 1, etc.  
	 * The remaining elements of the array, invalid words, set to null.
	 * Returns a string of word and null in each element.

	 * @param String letters: A string of English letters
	 * @param String wordSize: The size of words to be extracted from the input String
	 * @return String[]: Contains a word in each element. Elements can be null if no words are found. 
	 * by Dr. Kristy Boyer 
	 */
	public static String[] findWordsOfLength(String letters, int wordSize) {
		
		String [] findWordsOfLength;
		
		//Return nothing if the number of letters is less than the wordSize. 
		if (wordSize == 0){
			return findWordsOfLength("", 1);
		}
		else{
		//Size of the array for all words of the specified length that occur in the String
		//equals the length of the string subtracted by one less the number of letters in the word.
		findWordsOfLength = new String [letters.length() - (wordSize - 1)];
		}
		
		//Initial variable value for output array.
		int j =0;
		int count=0;

		//Searches the string of English letters, and stores all words of 
		//the specified length that occur in the string, by shifting to next length of letters 
		//of set of 4,5 or 6.
		for (int i = 0; i < (letters.length() - (wordSize - 1)); i++){
			findWordsOfLength[i] = letters.substring(i,(wordSize)+i);

			//Check if the word stored is an actual word in the dictionary. 
			//Return null for words that are not in the dictionary.
			if(isWord(findWordsOfLength[i]) == false){
				findWordsOfLength[i] = null;
				count++;
			}	
		}
		//Output array 
		String [] actualWordsOfLength = new String [findWordsOfLength.length];

		//Check if the word stored is an actual word (not null). 
		//Store the word in order of appearance in output array.
		for (int i = 0; i < (letters.length() - (wordSize - 1)); i++){
			//Adds nulls to output array
			actualWordsOfLength[i] = null;
			if (!(findWordsOfLength[i] == null)){
				j += 1;
				actualWordsOfLength[j-1] = findWordsOfLength[i];
			}
		}
		return actualWordsOfLength;
	}

	/**
	 * This method formats a poem according to Poetry Movement specifications. 
	 * Return formatted poem.
	 * @param Takes three arrays of Strings of shortest, medium, and longest lengths. 
	 * @return Returns a String with line breaks and tabs as needed for poetic formatting. 
	 * by Dr. Kristy Boyer
	 */
	public static String formatPoem(String[] shortest, String[] medium, String[] longest){
		//Remove extra null size

		//Initial variable value for loop.
		boolean done = false;
		int i =0;

		//Output string
		String formatPoem="";

		//Format poems according to Poetry Movement specifications.
		while(!done){

			//Calculate number of tabs.
			if ((i < shortest.length) && !(shortest[i] == null) || (i < medium.length) && !(medium[i] == null) ||
					(i < longest.length) && !(longest[i] == null)){
				for(int j=0; j<i; j++){
					formatPoem += "\t";	
				}
			}
			//Check for any words with 6 letters and stores them in a string. Removes nulls.
			if ((i < longest.length) && !(longest[i] == null)){
				formatPoem += longest[i];
				if ((i < medium.length) && !(medium[i] == null) || ((i < shortest.length) && !(shortest[i] == null))) {
					formatPoem += " ";
				}
			}
			//Check for any words with 5 letters and stores them in a string. Removes nulls.
			if ((i < medium.length) && !(medium[i] == null)){
				formatPoem += medium[i];
				if ((i < shortest.length) && !(shortest[i] == null)) {
					formatPoem += " ";
				}
			}
			//Check for any words with 4 letters and stores them in a string. Removes nulls.
			if ((i < shortest.length) && !(shortest[i] == null)){
				formatPoem += shortest[i];
			}
			//Move the next output to next line.
			if ((i < shortest.length) && !(shortest[i] == null) || (i < medium.length) && !(medium[i] == null) ||
					(i < longest.length) && !(longest[i] == null)){
					formatPoem += "\n";	
			}

			//Increment i to check next set of words.
			i++;

			//When all words have been used, end the loop.
			if ((i >= longest.length) && (i >= medium.length) && (i >= shortest.length)){
				done = true;
			}
		}
		return formatPoem;
	}

	/* *******************************************************************************
	STUDENTS -- BELOW THIS POINT ARE METHODS PROVIDED FOR YOU. DO NOT EDIT THEM. 
	USE THEM AS INDICATED IN THEIR DESCRIPTIONS. 
	by Dr. Kristy Boyer
	 ********************************************************************************/

	/**
	 * This method checks whether the given String occurs in a dictionary of English.
	 * DO NOT MODIFY THIS METHOD IN ANY WAY.
	 * This method will terminate the program if it is unable to access the remote URL.
	 * Must be online for this code to work. 
	 * @param possWord The word to be checked.
	 * @return boolean Returns true if the word given is an English word, false otherwise.
	 * by Dr. Kristy Boyer
	 */
	private static boolean isWord(String possWord) {
		boolean isWord = true;
		try {
			//connect to the URL. 
			String s = getUrl(possWord);
			Document d = Jsoup.connect(s).timeout(6000).get();
			Elements tdTags = d.select("h3");

			// Loop over all tdTags, in this case: the h3 tag 
			for( Element element : tdTags ){
				String check = element.toString();

				//Wordnet has a special h3 tag that appears only if the word is not in the dictionary
				//We search for this tag. If it is found, then the word searched is not in the dictionary
				if(check.equals("<h3>Your search did not return any results.</h3>") ){
					isWord = false;
				}
			}
		}
		catch (IOException e) {
			System.err.print("CHECK INTERNET CONNECTION. Could not connect to jsoup URL.");
			System.exit(0);
		}
		return isWord;
	}

	/**
	 * DO NOT EDIT THIS METHOD.
	 * This method will terminate your program if it is unable to access the remote URL.
	 * Must be online for this code to work. 
	 * @param String: search 
	 * @return A string containing the URL for the wordnet search.
	 * by Dr. Kristy Boyer
	 */
	private static String getUrl(String search) {
		//Standard URL for wordnet to search
		String url = "http://wordnetweb.princeton.edu/perl/webwn?s=";
		String newURL = null;
		try {
			//Get new page from word wordnet and get its location
			Document doc = Jsoup.connect(url + search).timeout(6000).get();
			newURL = doc.location().toString();
		}
		catch (IOException e) {
			System.err.print("CHECK INTERNET CONNECTION. Could not connect to jsoup URL.");
			System.exit(0);
		}
		//Return the string of the new URL. 
		return (newURL);
	}
}

