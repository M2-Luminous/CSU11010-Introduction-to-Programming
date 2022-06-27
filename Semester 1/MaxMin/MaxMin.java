import java.util.Scanner;

public class MaxMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter your list of numbers separated by spaces:");
		Scanner input = new Scanner( System.in );
		Scanner inputLine = new Scanner( input.nextLine() );
		if (inputLine.hasNextDouble())
		{
			double minimumNumber = inputLine.nextDouble();
			double maximumNumber = minimumNumber;
			while (inputLine.hasNextDouble())
			{
				double currentNumber = inputLine.nextDouble();
				if (currentNumber < minimumNumber)
					
					minimumNumber = currentNumber;
				
				if (currentNumber > maximumNumber)
					
					maximumNumber = currentNumber;
			}
			System.out.println("The numbers you entered are between " +
				             	minimumNumber + " and " + maximumNumber );
		}
		else
		{
			System.err.println("Error: No numbers provided.");
		}

	}

}
/*
		Scanner input = new Scanner( System.in );
		Scanner inputLine = new Scanner( input.nextLine() );
		double max = inputLine.nextDouble();
		double min = inputLine.nextDouble();
		while(inputLine.hasNextDouble())
		{
			double temp = inputLine.nextDouble();
			
			if(temp > max)
			{
				max = temp;
			}
		}
		while(inputLine.hasNextDouble())
		{
			double temp1 = inputLine.nextDouble();
			
			if(temp1 < min)
			{
				min = temp1;
			}
		}
		System.out.print(max+"and"+min);
*/