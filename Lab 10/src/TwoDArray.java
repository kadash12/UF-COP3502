public class TwoDArray {
	public static void main(String[] args){	

		int[][] conversion = convertArgs(args);
		printArray(conversion);

	}

	public static void printArray(int [][] array){

		//going through all possible rows in the 2D array given as parameter
		for(int row = 0; row < array.length; row++){

			//going through the all the columns in the current row
			for(int col = 0; col < array[row].length; col++){

				//print the element (a number (d) printed left justified (-) giving it 10 spaces (10))
				System.out.format("%-10d", array[row][col]);
			}

			//after we printed all the numbers in the current row, in other words, inner for loop is done at this point, 
			//we skip a line to print the next row on a new line
			System.out.println();
		}
	}

	public static int[][] convertArgs(String[] args){

		//let us have a variable longestLength that starts at 0
		int longestLength = 0;

		//going through all the words given to us in the command line arguments array
		for(int wordIndex = 0; wordIndex < args.length; wordIndex++){

			//if we encounter a word with a length bigger than the current longestLength
			if (args[wordIndex].length() > longestLength) {

				//longestLength will get updated with the length of that word
				longestLength = args[wordIndex].length();
			}
			//otherwise we can just go on to the next word if there is one, in other words, go on to next iteration in for loop
		}


		//allocate memory for a 2D array that can store all the words (number of rows/length of the command line arguments array) 
		//and the maximum number of letters longestLength (the length of the longest word in the command line arguments array)
		int[][] conversion = new int[args.length][longestLength];

		//going through all the words given to us in the command line arguments array
		for(int wordIndex = 0; wordIndex < args.length; wordIndex++){

			//we iterate over the maximum number of letters that the word at current wordIndex can have (that is the longest length)
			for(int charIndex = 0; charIndex < longestLength; charIndex++){

				//if the current character position is less than the length of the current word
				if(charIndex < args[wordIndex].length()){

					//we can grab that letter, convert it and store it at the corresponding row and column in the conversion 2D array
					conversion[wordIndex][charIndex] = (int)(args[wordIndex].charAt(charIndex));
				}

				//otherwise it means that the current position is greater than or equal to 
				//(remember that you cannot access a character at index length of the word, in other words -- "abc".charAt("abc".length()); will give you an exception
				//so we can just store a -1 at the corresponding row (current word index) and column (current character index) in the conversion 2D array
				else{
					conversion[wordIndex][charIndex] = -1;
				}
			}
		}

		//after we are done going through all words, and all possible letters, return the conversion 2D array
		return conversion;

	}
}