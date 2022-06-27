import java.util.Scanner;

public class Median {

public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		boolean quit = false;
	    int length = 0;
		double inputNumbers[] = new double[length];
		Scanner input = new Scanner( System.in );
		System.out.print( "Welcome to the median & rolling average system." );
		do
		{
			System.out.print( "\nEnter a number (or enter quit):" );
			if (input.hasNextDouble()) 
			{	
				
				double inputNumber = input.nextDouble();
				double[] copiedArray = new double[inputNumbers.length+1];
				System.arraycopy( inputNumbers, 0, copiedArray, 0, inputNumbers.length );
				copiedArray[copiedArray.length-1] = inputNumber;
				inputNumbers = copiedArray;
				int count = inputNumbers.length;
				String notSortedArray = convertToString( inputNumbers );
				
				double medianNumber = computeMedian(inputNumbers);
				double rollingAverage = computeRollingAverage(inputNumbers , count);
				System.out.print("The median of " + notSortedArray); 
				System.out.printf( " is %.1f" , medianNumber);
				System.out.print(" and the rolling average of ");
				System.out.printf("the last 3 values is %.1f", rollingAverage);
				System.out.print(".");
			}
			else if (input.hasNext("quit"))
			{
				quit = true;
			}
			else
			{
				System.out.print("Error - Enter any real number or quit.");
				input.next();
			}
				
			}while (!quit);
			input.close();
	}

	public static double computeMedian( double[] input )
	{
		if (input == null)
		{
			return 0.0;
		}
		int length = input.length;
		double[] medianArray = input;
		double medianNumber = 0.0;
		medianArray = createSortedArray(medianArray);
		int firstMedian = length / 2;
		int extraMedian = length / 2 - 1;
		if (length % 2 == 0)
		{
			medianNumber = (medianArray[firstMedian] 
					+ medianArray[extraMedian]) / 2;
		}
		else
		{
			medianNumber = medianArray[firstMedian];
		}
		return medianNumber;
	}
	
	public static double[] createSortedArray(double[] input )
	{
		if (input == null) return null;
		double[] array1 = input;
		double[] array = array1.clone();
		if (array!=null)
		{
			for (int index=0; index<array.length-1; index++)
			{
				int minimumIndex = index;
				for (int index2=index+1; index2<array.length; index2++)
				{
					if (array[index2] < array[minimumIndex])
						minimumIndex = index2;
				}
				double temp = array[index];
				array[index] = array[minimumIndex];
				array[minimumIndex] = temp;
			}
		}
		return array;
	}
		
	public static double computeRollingAverage( double[] input , int number)
	{
		int length = input.length;
		double rollingAverage = 0.0;
		if(length >= 3)
		{	
			double firstNumber = input[number - 1];
			double secondNumber = input[number - 2];
			double thirdNumber = input[number - 3];
			rollingAverage = (firstNumber + secondNumber + thirdNumber)*1.0 / 3.0;
		}
		else if(length == 2)
		{
			double firstNumber = input[number - 1];
			double secondNumber = input[number - 2];
			rollingAverage = (firstNumber + secondNumber )*1.0 / 2.0;
		}
		else if(length == 1)
		{
			double firstNumber = input[number - 1];
			rollingAverage = firstNumber * 1.0;
		}
		return rollingAverage;
	}

/*    public static double computeRollingAverage(double[] input, int number) {
    	number = Math.min(number, input.length);
        if (input.length <= 3)
        {
        	number = input.length;
        }
        if (number == 0) 
        {
        	return 0.0;
        }
        double totalNumber = 0.0; 
        double averageNumber = 0.0;
        for (int index = 0; index < number; index++) 
        {
            totalNumber += input[input.length - index - 1];
        }
        averageNumber = totalNumber * 1.0 / number;
        return averageNumber;
    }
*/

	public static String convertToString( double[] input )
	{
		if(input != null)
		{
			int length = input.length;
			String sortedArrayString = "{ ";	
			for(int index = 0; index < length; index++) 
			{
				sortedArrayString += String.format("%.1f", input[index]);
				sortedArrayString += ( index != length-1)?", ":" ";
			}
			sortedArrayString += "}";
			return sortedArrayString;
		}
		else return "{ }";
	}
}



