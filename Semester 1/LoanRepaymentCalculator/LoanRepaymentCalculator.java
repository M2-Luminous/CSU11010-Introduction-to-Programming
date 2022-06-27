/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use appropriate CONSTANTS instead of numbers within the code?
       Mark out of 5: 5   
       Comment:Yes, I used 'onePlus' and 'finishF' instead of numbers
   2. Did I use easy-to-understand, meaningful CONSTANT names?
       Mark out of 5: 5   
       Comment: Yes, I used 'onePlus' to demonstrate 1+r to make my code clearer.
        3. Did I format the CONSTANT names properly (in UPPERCASE)?
       Mark out of 5: 5 
       Comment: Yes, I used uppercase in constant names behind the lowercase. 
   4. Did I use easy-to-understand meaningful variable names?
       Mark out of 10: 10  
       Comment: 
   5. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 5: 5  
       Comment: Yes, I used 'onePlus' to demonstrate 1+r and 'finishF'
       to indicate my steps are finished to make my code clearer.In the meantime,
       I gave finishF another name with round to illustrate it experienced a format change
   6. Did I indent the code appropriately?
       Mark out of 10: 10  
       Comment: Yes, I indented the code thoughtfully to make my work look clearly. 
     Total Mark out of  40 (Add all the previous marks): 40 
*/
import java.util.Scanner;

public class LoanRepaymentCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter loan amount?");
		Scanner input = new Scanner (System.in);
			double number1 = input.nextDouble();
		System.out.print("Enter annual interest rate (e.g. 0.04)?");
			double number5 = input.nextDouble();
		System.out.print("Enter the term of the loan in years?");
			int number3 = input.nextInt();
		input.close();
			double number2 = number5 / 12;//monthly interest
			double number4 = number3*12;//n = year * 12
				double oneplus = 1 + number2;//1+r
				double onePlusx = Math.pow(oneplus,number4);//(1+r)^n
				double onePlusy = number2 * onePlusx;//r*(1+r)^n
				double onePlusz = onePlusx - 1;//(1+r)^n-1
					double onePlush = onePlusy / onePlusz;//r*(1+r)^n/(1+r)^n-1
					double finishF = number1 * onePlush;//P * r*(1+r)^n/(1+r)^n-1
						double roundofFinish = Math.round(finishF *100.00)/100.00;
						
		System.out.print("The monthly repayment for a " + number3);
		System.out.printf(" year loan of %.2f",number1);
		System.out.print(" at an annual interest rate of " + number5 + " would be " + 
		roundofFinish);
				   
	}

}
