/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use easy-to-understand meaningful variable and constant names?
       Mark out of 10: 10  
       Comment: I did use easy-to-understand such as totalNumber, enteredNumber to make my code easy to understand. 
   2. Did I format the variable and constant names properly (in lowerCamelCase and UPPERCASE)?
       Mark out of 5:  5 
       Comment: I formatted all the variable(totalNumber, enteredNumber) and even the constant names(AVERAGEVALUE) properly.
   3. Did I indent the code appropriately?
       Mark out of 10:  10 
       Comment: I indented for the "if" statement and "for" statement to make my code seems clearly.
   4. Did I implement a for loop to read the input as required?
       Mark out of 10:  10 
       Comment: As you see, I used a "for" statement to read the input as "number" to calculate the sum of all the input.
      Total Mark out of  35 (Add all the previous marks): 35 
*/
import java.util.Scanner;

public class TotalAverageCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int times = 1;
		int totalNumber = 0;
			System.out.print( "How many integers do you want to enter? " );
			Scanner userinput = new Scanner( System.in );
			double enteredNumber = userinput.nextDouble();
				if (enteredNumber >= 2 && enteredNumber <= 10)
				{
					for(times = 1;(times <= enteredNumber); times++)
					{
						System.out.print( "Enter integer " + times + ":");
						int number = userinput.nextInt();
						totalNumber = totalNumber + number; 
					}	
					double AVERAGEVALUE = totalNumber / enteredNumber;
					System.out.print("The sum of your integers is " + totalNumber);
					System.out.printf(" and the average is %.2f" , AVERAGEVALUE);
				}	
				else
				{
					System.out.print("Error:  This program is constrained to only "
				+ "compute the total & average of between 2 & 10 integers.");
				}
											}	
									}
