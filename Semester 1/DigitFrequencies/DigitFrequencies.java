import java.util.Scanner;

/*
 * Write a program which determines the frequency of digits.  The user is 
 * allowed to repeatedly enter integers and the program determines how many
 * times each digit has appeared.  For example:
 *   Enter a number> 155
 *   Digit frequencies:  1(1) 5(2)
 *   Enter a number> 5215
 *   Digit frequencies:  1(2) 2(1) 5(4)
 *   Enter a number>
 * As part of your solution you must write and use the following routines:
 *  - printDigitFrequencies() which takes an array containing the frequencies
 *  and prints out the frequencies to System.out (but only for the digits
 *  which have occurred).
 *  - countDigitFrequencies() which takes a number and an array of frequencies
 *  and updates the array of frequencies depending on the letter which appear
 *  in the number.
 */
public class DigitFrequencies {

	public static final int NUMBER_OF_DIGITS = 10;
	public static void main(String[] args) {
		// Initialize frequencies
		int[] digitFrequencies = new int[NUMBER_OF_DIGITS];
		for (int index=0; index<NUMBER_OF_DIGITS; index++)
			digitFrequencies[index]=0;
		while (true)
		{
			Scanner input = new Scanner( System.in );
			System.out.print("Enter a number> ");
			if (input.hasNextInt())
			{
				int number = input.nextInt();
				countDigitFrequencies( number, digitFrequencies );
				printDigitFrequencies( digitFrequencies );
			}
			else input.next();
		}
	}
	
	public static void printDigitFrequencies( int[] frequencies )
	{
		System.out.print("Digit Frequencies: ");
		if (frequencies != null)
		{
			boolean commaNeeded = false;
			for (int index=0; index<NUMBER_OF_DIGITS; index++)
				if (frequencies[index] > 0)
				{
					System.out.print( (commaNeeded ? ", ":"") + index + "(" + frequencies[index] + ")" );
					commaNeeded = true;
				}
		}
		System.out.println();
	}
	
	public static void countDigitFrequencies( int number, int[] frequencies )
	{
		int remainingNumber = Math.abs(number);
		do
		{
			int digit = remainingNumber%10;
			remainingNumber /= 10;
			frequencies[digit]++;
		} while (remainingNumber > 0);
	}

}