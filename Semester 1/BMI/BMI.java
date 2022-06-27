/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use easy-to-understand meaningful variable names?
       Mark out of 10:  10 
       Comment: I used the name squareheight to make my code easier to understand
   2. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 10:  10 
       Comment: I set up the variable names such as weight,height and squareheight with 'double' to finish my code work 
   3. Did I indent the code appropriately?
       Mark out of 10:  10 
       Comment: I indent the code properly to make my work have rules 
     Total Mark out of  30 (Add all the previous marks):  30
*/
import java.util.Scanner;

public class BMI {
	public static final double MIN_NORMAL_BMI	=	18.5;	
	public static final double MIN_OVERWEIGHT_BMI	=	25.0;	
	public static final double MIN_OBESE_BMI	=	30.0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     System.out.print("What is your weight in kg ?");//weight
     Scanner input = new Scanner (System.in);
     	double weight = input.nextDouble();
     System.out.print("What is your height in metres?");//height
     	double height = input.nextDouble();
     input.close();
     	double squareheight = height * height;//square the height
     	double bmi = weight / squareheight;//divide the height into the weight
     	String	weightClassification	=	"";	
     	if	(bmi < MIN_NORMAL_BMI)	
     	{	
     	weightClassification = "Underweight";	
     	}	
     	else if	(bmi < MIN_OVERWEIGHT_BMI)	
     	{	
     	weightClassification = "Normal";	
     	}	
     	else if	(bmi < MIN_OBESE_BMI)	
     	{	
     	weightClassification = "Overweight";	
     	}	
     	else		
     	{	
     	weightClassification = "Obese";	
     	}
     	System.out.println("Your BMI is " +bmi +	
     	" which is classified as " + weightClassification);
	}

}
/*
String	weightClassification	=	"Normal";	
if	(bmi	<	MIN_NORMAL_BMI)	
{	
weightClassification	=	"Underweight";	
}	
else if	((bmi	>=	MIN_OVERWEIGHT_BMI)	&&
			(bmi	<	MIN_OBESE_BMI))	
{	
weightClassification	=	"Overweight";	
}	
else	if	(bmi	>=	MIN_OBESE_BMI)
{	
weightClassification	=	"Obese";	
}
System.out.println("Your	BMI	is	"	+	bmi	+	
"	which	is	classified	as	"	+	weightClassification	);
}
}	
*/
