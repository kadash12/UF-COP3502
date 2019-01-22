import java.util.Scanner;
public class Hex2Dec
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		boolean isValid = false;
		String hexInput;
		do
		{
			System.out.println("Enter a valid hexadecimal:");
			hexInput = input.next();	//Type capital letters
			isValid = true;
			for (int i=0; i<hexInput.length(); i++)
			{
				String possible = "0123456789ABCDEF";
				if (possible.indexOf(hexInput.charAt(i))==-1)
				{
					isValid = false;
				}
			}
		} while (!isValid);
		int decOutput = 0;
		int decChar;
		for (int i = hexInput.length() -1; i >= 0; i--)
		{
			switch(hexInput.charAt(hexInput.length() -1 -i))
			{
				case '0': decChar = 0;break;
				case '1': decChar = 1;break;
				case '2': decChar = 2;break;
				case '3': decChar = 3;break;
				case '4': decChar = 4;break;
				case '5': decChar = 5;break;
				case '6': decChar = 6;break;
				case '7': decChar = 7;break;
				case '8': decChar = 8;break;
				case '9': decChar = 9;break;
				case 'A': decChar = 10;break;
				case 'B': decChar = 11;break;
				case 'C': decChar = 12;break;
				case 'D': decChar = 13;break;
				case 'E': decChar = 14;break;
				case 'F': decChar = 15;break;
				default: decChar = -1;break;
			}
			decOutput += decChar * (int)Math.pow(16, i);
		}
		System.out.println("Decimal value is " + decOutput);
		input.close();
	}
}
