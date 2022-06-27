/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use easy-to-understand meaningful and properly formatted variable names?
       Mark out of 5: 5  
       Comment: Yes, I used so many meaningful names such as enterednNumber,
       binaryNumber, testNumber and mode. I formatted these names too in 
       lowerCamelCase. 
    2. Is my code easy to follow/understand?
       Mark out of 5:  5 
       Comment: Yes, I indented my codes properly in order to make 
       my code easy to understand. What's more, I provided another version
       of the function call to help reader learn. 
   3. Did I use the functions as required?
       Mark out of 10: 10  
       Comment:Yes, I used all the function required including  getBinaryString, 
       isPernicious, countBinaryOnes, isPrime.
       Total Mark out of  20 (Add all the previous marks): 20 
*/

import java.util.Scanner;
public class PerniciousNumbers {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner input = new Scanner( System.in );
		System.out.print( "Enter the maximum number you want to consider:" );
		if (input.hasNextInt())
		{
			int enteredNumber = input.nextInt();
			for (int startNumber = 2; (startNumber <= enteredNumber); startNumber++)
			{
				if(isPernicious(startNumber))
				{
						System.out.println(startNumber + " is a pernicious"
								+ " number as it contains "+ countBinaryOnes(startNumber) 
						+ " ones in it's binary representation ("+getBinaryString(startNumber)+")");
				}
			}	
		}
			
	}
	
/*	public static String getBinaryString (int input)
	{
		int index=input;
		String binaryNumber ="";
		if(input == 0)
		{
			binaryNumber = "0";
		}
		else if (input != 0)
		{
			while(input != 0)
			{
				binaryNumber = (((input % 2) == 0)? "0" : "1") 
												+ binaryNumber;
				input = input / 2;
			}
		}
		return ((index>=0) ? binaryNumber : ("-" + binaryNumber));
	}
*/

 	public static String getBinaryString (int input)
 	{
 		String binary = "";
 			if(input < 0)
 			{
 				input = 0 - input;
 				binary = "-" + Integer.toBinaryString(input);
 			}
 			else
 				binary = Integer.toBinaryString(input);
 	  return binary;
 }	

	
	
	public static boolean isPernicious(int input)
	{	
			int countOfOnesInBinary = countBinaryOnes(input);
		return isPrime(countOfOnesInBinary);	
	}

/*	public static int countBinaryOnes(int input)
	{
		String binaryString = getBinaryString(input);
		int binaryNumber = Integer.parseInt(binaryString);
		int count = 0;
		if(binaryNumber > 0)
		{
			while(binaryNumber>0)
			{
				int singleNumber = binaryNumber % 10;
				binaryNumber /= 10;
				if(singleNumber == 1)
				{
					count = count + 1;
				}
			}
		}
			return count;
	}
*/	
	public static int countBinaryOnes(int input)
    {
        if(input < 0)
        {
        	input = 0 - input;	
        }
        	String binaryNumber = getBinaryString(input);
        	int count = 0;
        	for (int figure = 0; figure < binaryNumber.length(); figure++)
        	{
        		if (binaryNumber.substring(figure, figure+1).equals("1"))
        		{
        			count = count + 1;
        		}
        	}
        return count;
    }

	public static boolean isPrime(int count)
	{
		if(count < 2)
		{
			return false;	
		}
		int testNumber = 2;
		while(count > testNumber)
		{
			int mode = count % testNumber;			
			if(mode == 0)
			{
				return false;	
			}
			testNumber++;
		}
		return true;
	}
}
	
