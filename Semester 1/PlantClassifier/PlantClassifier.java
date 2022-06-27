/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use easy-to-understand meaningful variable names?
       Mark out of 10:10   
       Comment: Yes, I used organisedFunctionalStructure,vascularTissues,dispersedBySeeds,seedEnclosed to describe each
       step of my code goes
   2. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 5:5   
       Comment:Yes, all the variable names(organisedFunctionalStructure,vascularTissues,dispersedBySeeds,seedEnclosed) obeyed
       the rules in lowerCamelCase  
   3. Did I indent the code appropriately?
       Mark out of 15: 15  
       Comment: Yes, each if statement has an indent to make my code clearer.
      Total Mark out of  30 (Add all the previous marks):  30
*/
import java.util.Scanner;

public class PlantClassifier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 	Scanner userinput = new Scanner(System.in);
		System.out.print("Does the plant have cells and tissues which are organised into functional structures (Yes/No)?");
		boolean organisedFunctionalStructure = userinput.next().equalsIgnoreCase("Yes");
		if (organisedFunctionalStructure) {
			System.out.print("Does the plant have vascular tissues(Yes/No)?");
			boolean vascularTissues = userinput.next().equalsIgnoreCase("Yes");
			if(vascularTissues) {
				System.out.print("Is the plant dispersed by seeds (Yes/No)?");
				boolean dispersedBySeeds = userinput.next().equalsIgnoreCase("Yes");
				if(dispersedBySeeds) {
					System.out.print("Are the seeds enclosed (Yes/No)?");
					boolean seedEnclosed = userinput.next().equalsIgnoreCase("Yes");
					if(seedEnclosed) {
						System.out.print("The plant is an ANGIOSPERMS.");
					}else
						System.out.print("The plant is a GYMNOSPERM.");
				}else
					System.out.print("The plant is a PTERIDOPHYTE.");
			}else
				System.out.print("The plant is a BRYOPHYTE.");
		}else
			System.out.print("The plant is an ALGAE.");
	userinput.close();
        
        
	}
}
/*	    ANOTHER VERSION
		System.out.print("Does the plant have cells and tissues which are organised into "
                + "functional structures (Yes/No)?");
        Scanner userInputReader1 = new Scanner(System.in);
        String userInput1 = userInputReader1.next();
        if (userInput1.equalsIgnoreCase("No")) {
            System.out.print("The plant is an ALGAE.");
        } else {
            System.out.print("Does the plant have vascular tissues(Yes/No)?");
            Scanner userInputReader2 = new Scanner(System.in);
            String userInput2 = userInputReader2.next();
            if (userInput2.equalsIgnoreCase("No")) {
                System.out.print("The plant is a BRYOPHYTE.");
            } else {
                System.out.print("Is the plant dispersed by seeds (Yes/No)?");
                Scanner userInputReader3 = new Scanner(System.in);
                String userInput3 = userInputReader3.next();
                if (userInput3.equalsIgnoreCase("No")) {
                    System.out.print("The plant is a PTERIDOPHYTES.");
                } else {
                    System.out.print("Are the seeds enclosed (Yes/No)?");
                    Scanner userInputReader4 = new Scanner(System.in);
                    String userInput4 = userInputReader4.next();
                    if (userInput4.equalsIgnoreCase("No")) {
                        System.out.print("The plant is an GYMNOSPERM.");
                    } else {
                        System.out.print("The plant is an ANGIOSPERMS.");
                    }
                }
            }
       }	   
*/	    
	    


