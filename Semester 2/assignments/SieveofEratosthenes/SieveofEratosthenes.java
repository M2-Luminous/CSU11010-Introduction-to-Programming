import java.util.Arrays;
import java.util.Scanner;

/* SELF ASSESSMENT 
   1.    createSequence:
Did I use the correct method definition?
Mark out of 5:5
Comment: Yes, I created this function using public static String in order to return a String that can present me from 2 to maximum number I typed in
Did I create an array of size n (passed as the parameter) and initialize it?
Mark out of 5:5
Comment: Yes, I let the user to input a maximum number and the function will automatically initialize a sequence as expected
Did I return the correct item?
Mark out of 5:5
Comment:Yes, I return the sequence as a string
   2.    crossOutMultiples
Did I use the correct method definition?
Mark out of 5:5
Comment:Yes, I created this function using public static int[] which takes in an array and a number and return a new crossed out array
Did I ensure the parameters are not null and one of them is a valid index into the array
Mark out of 2:2
Comment:Yes, I made good use of all the parameter that I created and one of them is using as a valid index into the array called "index"
Did I loop through the array using the correct multiple?
Mark out of 5:5
Comment:Yes, I wrote an extra function to make sure I am crossing out the correct number's higher multiples
Did I cross out correct items in the array that were not already crossed out?
Mark out of 3:3
Comment: Yes, I crossed out those items correctly and I can use further program to add those elements back
   3.    sieve   
Did I have the correct function definition?
Mark out of 5:5
Comment:Yes, I created this function using public static int[] which takes in an array and then return all the prime numbers in the range
Did I make calls to other methods?
Mark out of 5:5
Comment: Yes, I made use of createSequence and crossOutHigherMultiples in order to get my final result     
Did I return an array with all non-prime numbers are crossed out?
Mark out of 2:2
Comment: Yes, I crossed out all the required elements and got the final result
   4.    sequenceTostring  
Did I have the correct function definition?
Mark out of 5:5
Comment:Yes, I created this function using public static String in order to change the sequence to string and detect the missing numbers,
add them back to the string and then give those missing numbers square brackets
Did I ensure the parameter to be used is not null?
Mark out of 3:3
Comment: Yes, I made good use of all the parameters that I created
Did I Loop through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets? 
Mark out of 10:10
Comment: Yes, I change the sequence to string and detect the missing numbers, add them back to the string and then give those missing numbers square brackets
   5.    nonCrossedOutSubseqToString  
Did I have the correct function definition
Mark out of 5:5
Comment:  Yes, I created this function using public static String to get the rest of the numbers into string     
Did I ensure the parameter to be used is not null?  
Mark out of 3:3
Comment:Yes, I made good use of all the parameters that I created
Did I loop through the array updating the String variable with just the non-crossed out numbers? 
Mark out of 5:5
Comment:Yes, I made a comparison with the crossed out array and the original array to detect what are the numbers that did not get deleted
   6.    main  
Did I ask  the user for input n and handles input errors?  
Mark out of 5:5 
Comments:Yes, I ask the user to input a  maximum number and then the program will return all steps of the calculation
Did I make calls to other methods (at least one)?
Mark out of 5:5
Comment:  Yes, I made use of all the function that I created.
Did I print the output as shown in the question?  
Mark out of 5:5
Comment:  Yes, I print out the output correctly just like the sample one
   7.    Overall
Is my code indented correctly?
Mark out of 4:4
Comments:Yes, I tried to follow the coding standard and indent the code I need to indent
Do my variable names make sense?
Mark out of 4:4
Comments:Yes, I name my variable carefully using lowerCamelCase in order to make myself have a better look of the code I am writing
Do my variable names, method names and class name follow the Java coding standard
Mark out of 4:4
Comments:Yes, I tried myself best to follow all the rules of the coding standard.
      Total Mark out of 100 (Add all the previous marks):100 
*/

public class SieveofEratosthenes {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner input = new Scanner( System.in );
	    System.out.print("Enter int >= 2 : ");
	    int maximumNumber = input.nextInt();                             //input the maximum array and then initialize it 
	    int[] initialArray = createSequence(maximumNumber);              //use the createSequence method to generalize an array start from 0 and ends at the 
	    																 //maximum number
	    System.out.println((Arrays.toString(initialArray)).substring(1, Arrays.toString(initialArray).length() - 1));
	    //If I don't use a "substring" command, you will find that after convert an array into string, the most left part and the right part of the
	    //string will automatically generate a pair of square bracket. And this is what I don't expect.So I use a substring command to let the Array.toString
	    //method starts to transform from index 1(apart from 0) and ends in index array.length - 1(apart from array.length) 
	    
	    int[] crossOutNumbers = initialArray;                //assign a new unchanged array to crossOutNumbers
	    for (int multiples : sieve(maximumNumber))           //this is a new "for" version and we need to initialize an integer called multiples
	  //the usage of this version is to check all the possible multiples using the numbers that generate in the sieve function.
	  //After checking the first number in sieve function, it will jump to the next number automatically.You can try to write a normal "for" program
	  //to replace it
	    {
	        if(multiples <= Math.sqrt(maximumNumber))//check whether the multiples fits the situation or not
	        {
	        	crossOutNumbers = crossOutHigherMultiples(crossOutNumbers, multiples);//if it is correct, use crossOutHigherMultiples to cross out numbers
	        	//and in the same time give them a square bracket
	            System.out.println(sequenceToString(crossOutNumbers, initialArray));
	        }
	    }
	    System.out.println(nonCrossedOutSubseqToString(initialArray));
	    //use the sieve method to generate the last line of the output, which is only the prime numbers themselves
	}
 public static int[] createSequence (int maximumNumber )//generate an original array from 2 to the maximum number for further works to be done
 {
	 int[] array = new int[maximumNumber - 1]; 
	 for(int number = 2; (number < maximumNumber + 1); number++)
	 {
		array[number - 2] = number;		
	 }
	 return array;
 }
 
 public static int[] crossOutElement(int[]numbers, int removedIndex)// basic idea can be divide into several steps: first, locate the number that we are going
	{                                                               //to cross out. second, take this number as a barrier, copy down the left part of the array 
		int[]firstPart=new int[removedIndex];                       //and the right part of the array(except the cross out number itself) to a new array. and 
			System.arraycopy(numbers, 0, firstPart, 0, firstPart.length);//finally return this new array out.
		int[]secondPart=new int[numbers.length-1-removedIndex];
			System.arraycopy(numbers, removedIndex+1, secondPart, 0, secondPart.length);
		int[]result=new int[numbers.length-1];
			System.arraycopy(firstPart, 0, result, 0, firstPart.length);
			System.arraycopy(secondPart, 0, result, firstPart.length, secondPart.length);
		return result;
	}
 //here's an example: in the array:2,3,4,5,6,7 I want to cross out number "4", so I copy down its left side 2,3 and its right side 5,6,7.Then we put this two 
 //part into a new place in order to change the array into 2,3,5,6,7 
 
 public static int[] crossOutHigherMultiples (int[] arrayNumbers , int maximumNumber )
 {
	 int[]array=arrayNumbers;
	 for(int index = 0; index < array.length ; index++)
	 {
	 	int chosenNumber = array[index];
	 	if(chosenNumber % maximumNumber == 0 && chosenNumber != maximumNumber)    //use chosen number % number = 0 to check whether this chosen number is 
	 		                                                        //the maximum number's multiple or not. use chosen number != maximumNumber to make sure
	 		                                                        //the program won't cross out the prime number itself
	 	{
	 	 array = crossOutElement(array, index);//use this additional function to cross out the element.You can try to fit the additional part into this function
	 	}
	 }
		return array;
 }
 /*
  //this is another cross out function which is much more easier to understand and written by one of my Chinese friend
  public static int[] crossOutHigherMultiples (int[] arr, int n){
    int[] temp = new int[arr.length];
    int resultLength = 0;
    for (int i = 0; i < arr.length; i++)
    {
        if (arr[i] % n != 0 || arr[i] == n)
        {
            temp[resultLength] = arr[i];
            resultLength++;
        }
    }
    int[] result = new int[resultLength];
    System.arraycopy( temp, 0, result, 0, result.length );
    return result;
}
  */
 
  public static int[] sieve(int positiveN)
  {
	  int[] array = createSequence(positiveN);
	  for(int index = 0; index <= Math.sqrt(positiveN); index++)
	  {
		  array = crossOutHigherMultiples(array, array[index]);
	  }
	  return array;
  }
  //what the function here ask us to do is to write a function that can directly provide us the prime numbers
  
  
  //this is the most difficult part of the program because the professor ask us to input only one array and return an array with square brackets in it
  //but I found it was so hard to detect when I should stop the flow control with only one array, so I input two array to compare them with each other.
  //You can try to write one by yourself.
  //there is one of my friend he successfully wrote out a version that only obtain one function by using an array list.And this is unfamiliar to all of us
  public static String sequenceToString (int[] modified, int[] original){
      String result = "";
      boolean deleteNumbers;

      for(int index : original)               //check all the numbers in the original array
      {                        
    	  deleteNumbers = true;   
          for (int index1 : modified)          //check all the numbers in the modified array
          {
              if (index == index1)             //if the two numbers is the same, then change the boolean to false
            	  deleteNumbers = false;
          }
          if(deleteNumbers)
              result += "[" + index + "],";   //if the boolean is true, then it means this number has been crossed out in the modified array, and we need 
                                              //to add him a square bracket
          else
              result += index + ",";
      }
      return result.substring(0, result.length() - 1);
  }

  public static String nonCrossedOutSubseqToString(int[] arrayNumbers)
  {
	  int positiveN = arrayNumbers[arrayNumbers.length - 1];
	  arrayNumbers = sieve(positiveN);
	  String tempArray = Arrays.toString(arrayNumbers);
	  return tempArray.substring(1, tempArray.length() - 1);
  }
  //change the numbers in the sieve array into a string
  //be aware of the usage of substring.
}
 