/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use easy-to-understand meaningful variable names?
       Mark out of 5:  5 
       Comment: Yes, I used enteredNumber to represent input ranks 
       and ranksGiven to show what my code is going to do.
   2. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 5:   
       Comment: Yes, I used enteredNumber and 
       ranksGiven in lowerCamelCase.
   3. Did I indent the code appropriately?
       Mark out of 5: 5  
       Comment: Yes, I indented my code in every level of
       my if statement.In the mean time, I indented carefully
       when I was writing switch-break statement.
   4. Did I implement a switch statement as required?
       Mark out of 10:  10 
       Comment: Yes, I implemented two switch statement 
       when I was writing the code and in need of finishing 
       the goals that I need to achieve.
       Total Mark out of  25 (Add all the previous marks):  25
*/

import java.util.Scanner;

public class Prizes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean exit = false;
		System.out.print( "This program tells competition "
				+ "participants what prize they have won." );
		Scanner input = new Scanner( System.in );
		do
		{
			System.out.print( "\nEnter your place "
					+ "number (or type 'exit'):" );
			if (input.hasNextInt())
			{
				int enteredNumber = input.nextInt();
				if(enteredNumber >= 1 && enteredNumber <=10)
				{	
				String ranksGiven = "";
				switch (enteredNumber)
					{
				case 1 :
					ranksGiven = "1st";
					break;
				case 2 :
					ranksGiven = "2nd";
					break;
				case 3 :
					ranksGiven = "3rd";
					break;
				case 4 :
					ranksGiven = "4th";
					break;
				case 5 :
					ranksGiven = "5th";
					break;
				case 6 :
					ranksGiven = "6th";
					break;
				case 7 :
					ranksGiven = "7th";
					break;
				case 8 :
					ranksGiven = "8th";
					break;
				case 9 :
					ranksGiven = "9th";
					break;
				case 10 :
					ranksGiven = "10th";
					break;
					}
				System.out.print("You came in " + ranksGiven
						+" place and hence won");
				switch (enteredNumber)
					{
				case 1 :
					System.out.print(" two theatre tickets + drinks "
							+ "during the interval + dinner "
							+ "before the show.");
					break;
				case 2 :
					System.out.print(" two theatre tickets + drinks "
							+ "during the interval.");
					break;
				case 3 :
					System.out.print(" two theatre tickets.");
					break;
				case 4 :
				case 5 :
					System.out.print(" a 10 Euro book token.");
					break;
				case 6 :
				case 7 :
				case 8 :
				case 9 :
				case 10 :
					System.out.print(" a 5 Euro book token.");
					break;
					}
				}
				else
				{
					System.out.print("Sorry.  You did not win a prize.");
				}
			}
			else if (input.hasNext("exit"))
			{
				exit = true;				
			}
		} while (!exit);
		input.close();
	}

}
