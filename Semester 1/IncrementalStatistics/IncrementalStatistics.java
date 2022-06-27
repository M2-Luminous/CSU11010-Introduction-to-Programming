/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use easy-to-understand meaningful variable names?
       Mark out of 5:  5 
       Comment: Yes, I used times, numbers , AVERAGE and VARIANCE 
       to make my code easy to understand.
   2. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 5:  5 
       Comment: Yes, I used formerAverage, latterAverage, formerVariance, 
       latterVariance in lowerCamelCase properly.
   3. Did I indent the code appropriately?
       Mark out of 5:  5 
       Comment: Yes, I indented the codes when I wrote do-while 
       statement and if-else statement.
   4. Did I implement a while loop or do-while loop as required?
       Mark out of 10: 10  
       Comment: Yes, I implemented a do-while loop.
      Total Mark out of  25 (Add all the previous marks): 25 
*/
import java.util.Scanner;

public class IncrementalStatistics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��do-while���֮ǰ����м���Ļ��ᵼ��while�����ĵط�һֱ����(����exit�ò�����Ҫ�Ľ��),�ײ�Ŷ
		int times = 1;
		double formerAverage = 0;
		double formerVariance = 0;
		boolean exit = false;
		System.out.print( "This program computes the average and variance of all numbers entered. " );
		Scanner input = new Scanner( System.in );
		System.out.print( "\nEnter a number (or type 'exit'):" );
		do
		{
			if (input.hasNextDouble())
			{
				double numbers = input.nextDouble();
				double numbersAverage = 
						numbers - formerAverage;
				double latterAverage = 
						formerAverage + numbersAverage / times;
				double part1 = 
						(times - 1) * formerVariance;
				double part2 = 
						(numbers - formerAverage) * (numbers - latterAverage);
				double latterVariance = 
						(part1 + part2) / times;
				formerAverage = latterAverage;
				formerVariance = latterVariance;
				times++;
				System.out.printf("So far the average is %.1f" , latterAverage );
				System.out.printf(" and the variance is %.1f" , latterVariance);
				System.out.print("\nEnter another number (or type 'exit'):");
			}
			else if (input.hasNext("exit"))//����ϵͳ���
			{
				exit = true;
			}
			else//��Ӧif����е� input.hasNextDouble() �Ӷ���� !input.hasNextDouble() �����
			{
				System.out.println("Error:  You must enter a real number (e.g. 12.5)");
				System.out.print("Enter another number (or type 'exit'):");
				input.next();
			}
			
		} while (!exit);//��exit����������޸�Ϊtrueʱ,��� !exit �������ֹͣϵͳ,���ڴ�ͬʱ���goodbye
		input.close();
		System.out.print("Goodbye.");
	}

}
