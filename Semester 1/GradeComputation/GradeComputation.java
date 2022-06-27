import java.util.Scanner;

public class GradeComputation {
	public static final String[] MODULE_CODES   = { "CSU11001", "CSU11010", "CSU11013", "CSU11021", "CSU11022", "CSU11026", "CSU11031", "CSU11081", "CSU12002", "STU11002" };
	public static final int[]    MODULE_CREDITS = {  5,          10,         5,          5,          5,          10,         5,          5,          5,          5         };
	public static void main(String[] args) {
			// TODO Auto-generated method stub
		boolean quitout=false;
		Scanner input=new Scanner(System.in);
		System.out.println("Welcome to the first year grade assessor.");
		while(!quitout)
		{
			boolean quit = false;
			double marks[] = new double[MODULE_CODES.length];
			int length = 0; 
			do
			{
				System.out.print("Enter the student mark for " + (MODULE_CODES[length]) + 
						" (or enter quit):");
				boolean inputFormatCorrect = false;
				if(input.hasNext("quit"))
				{
					quitout = true;
					inputFormatCorrect = true;
					quit = true;
					input.next();
				}
				else if(input.hasNextDouble())
				{
					double gradeNumber = input.nextDouble();
					if(gradeNumber > 100 || gradeNumber < 0)
					{
						inputFormatCorrect = false;
					}
					else if((gradeNumber <= 100 && gradeNumber >= 0))
					{
						inputFormatCorrect = true;
				    	marks[length] = gradeNumber;
					    length++;
					}
				}
				else
				{
					input.next();
				}
				
				
				if(!inputFormatCorrect)
				{
					System.out.println("Error - Enter a number between 0.0 and 100.0 or quit.");
				}
				if(length == marks.length)
				{
					quit = true;
					System.out.print("Result = " + determineOverallGrade(marks));
					System.out.printf(" with an overall mark of %.0f", weightedAverageMark(marks));
					System.out.print("%.");
					System.out.println();
					String classGrade = determineOverallGrade(marks);
					if(classGrade == "FAIL")
					{
						System.out.println("  " + creditsBelowSpecifiedMark(marks , 40) + " credits were failed.");
					}
					System.out.println();
					System.out.println();
				}
			}while(!quit);
		}
		input.close();
	}


	public static  int creditsBelowSpecifiedMark( double[] marks, int specifiedMinimumMark )
	{
		int result = 0;
		int length = marks.length;
		for(int index = 0;(index < length);index++)
		{
			double mark = Math.round(marks[index]);
			if(mark < specifiedMinimumMark)
			{
				result = result + MODULE_CREDITS[index];
			}
		}
		return Math.round(result);	
	}

    public static double weightedAverageMark(double[] marks)
    {
     double totalCredits = 0;
     double average = 0;
     int count = 0;
     while(count < MODULE_CREDITS.length)
     {
    	 double singleCredit = MODULE_CREDITS[count];
    	 totalCredits += singleCredit;
    	 count++;
     }
     for(int length = 0;(length < MODULE_CREDITS.length);length++)
     {
    	 double weight = MODULE_CREDITS[length];
    	 average += marks[length] * weight;
     }
     	average /= totalCredits;

     	return average;
     }
 
	   public static String determineOverallGrade( double[] marks ) 
	   {
		   String gradeClass = "";
		   double average = weightedAverageMark(marks);
		   double roundedAverage = Math.round(average);
		   if(roundedAverage < 40
			||creditsBelowSpecifiedMark(marks, 40) > 10
			||creditsBelowSpecifiedMark(marks, 35) > 0)
			{
			   gradeClass = "FAIL";
			}
			else if(average < 50)
			{
				gradeClass = "III"; 
			}	   
			else if(average < 60)
			{
				gradeClass = "II.2";
			}
			else if(average < 70)
			{
				gradeClass = "II.1";
			}
			else
			{
				gradeClass = "I";
			}
		   return gradeClass;
	   }
}