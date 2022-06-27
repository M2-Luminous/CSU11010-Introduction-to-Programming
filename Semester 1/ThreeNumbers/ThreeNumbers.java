/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use easy-to-understand meaningful and properly formatted variable names?
       Mark out of 5: 5  
       Comment: Yes, I set easy-to-understand variable names. When I try to express that I have
       change my numbers from integer, I used doubled number 1,2,3 to show it. I also formatted
       variable names properly such as sumOfNumbers, doubledNumber into lowerCamelCase. 
    2. Did I indent the code appropriately?
       Mark out of 5: 5  
       Comment: Yes, I indented the codes when I wrote do-while 
       statement , if-else if-else statement and function statement 
       to make my code neater.
   3. Did I make use of the functions appropriately within main and the other functions?
       Mark out of 10: 10  
       Comment:Yes, I made use of the functions appropriately 
       within main function and the other functions( medianOf function, 
       averageOf function, countOfNumbersGreaterThanTheAverage function, 
       getFormattedOutputString function)
       Total Mark out of  20 (Add all the previous marks): 20 
*/
import java.util.Scanner;
public class ThreeNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	boolean quit = false;
	Scanner input = new Scanner( System.in );
	/*
	input.useDelimiter("(\\p{javaWhitespace}|\\/)+");
	int number1 = input.nextInt();
	int number2 = input.nextInt();
	int number3 = input.nextInt();
	*/
	do
	{
		System.out.print( "Please enter your three integers separated "
				+ "by spaces (or enter 'quit'):" );
		if (input.hasNextInt()) 
		{			
			int number1 = input.nextInt();
			if (input.hasNextInt()) 
			{
				int number2 = input.nextInt();
				if (input.hasNextInt()) 
				{
					int number3 = input.nextInt();
					int median = medianOf(number1, number2, number3);
					int count = countOfNumbersGreaterThanTheAverage(number1, number2, number3);
					System.out.println(getFormattedOutputString(median, count));
				}
			}
		}
		else if (input.hasNext("quit"))
		{
			quit = true;
		}
		else
		{
			System.out.println("Error:  You must enter an integer (e.g. 12)");
			System.out.print("Please enter your three integers "
					+ "separated by spaces (or enter 'quit'):");
			input.next();
		}
			
		}while (!quit);
		input.close();
	}


	public static int medianOf( int number1, int number2, int number3)
	{
	int median = 0;
		if((number1 >= number2 && number1 <= number3) ||
			(number1 >= number3 && number1 <= number2))
		{	
			median = number1;
		}
		else if((number2 >= number1 && number2 <= number3) ||
				( number2 >= number3 && number2 <= number1))
		{
			median = number2;
		}
		else if((number3 >= number1 && number3 <= number2) ||
				(number3 >= number2 && number3 <= number1))
		{
			median = number3;
		}
		return median;	
	}
	
	public static double averageOf( int number1, int number2, int number3)
	{
		double doubledNumber1 = number1;
		double doubledNumber2 = number2;
		double doubledNumber3 = number3;
		double average = 0;
		double sumOfNumbers = 0;
		sumOfNumbers = doubledNumber1 + doubledNumber2 + doubledNumber3;
		average = sumOfNumbers / 3;
		return average;		
	}
	
	public static int countOfNumbersGreaterThanTheAverage ( int number1, int number2, int number3)
	{
		int count = 0;
		double average = averageOf(number1, number2, number3);
	if(number1 <= average && number2 <= average && number3 <= average)
	{	
		count = 0;
	}
	else if((number1 > average && number2 <= average && number3 <= average) ||
			(number1 <= average && number2 > average && number3 <= average) ||
			(number1 <= average && number2 <= average && number3 > average))
	{
		count = 1;
	}
	else if((number1 <= average && number2 > average && number3 > average) ||
			(number1 > average && number2 <= average && number3 > average) ||
			(number1 > average && number2 > average && number3 <= average))
	{
		count = 2;
	}
		return count;
	}
	
	public static String getFormattedOutputString (int median, int count)
	{
		if (count < 2)
		{
		return "The median of your numbers is " + median 
				+ ", and " + count + " of them is greater than their average.";	
		}
		else
		{
		return "The median of your numbers is " + median 
					+ ", and " + count +" of them are greater than their average.";		
		}
	}

}
