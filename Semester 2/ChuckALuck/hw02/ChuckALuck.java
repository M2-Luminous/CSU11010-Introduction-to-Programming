package hw02;

import java.util.Scanner;

public class ChuckALuck {
    public static void main(String[] args) {
        boolean quit = false;
        wallet wallet = new wallet();
        Scanner input = new Scanner(System.in);
        System.out.print("Welcome to the Chuck-A-Luck Dice game");
        System.out.print("\nEnter your total amount of money:");
        wallet.setMoney(input.nextDouble());
        
        while (!quit) {
            System.out.print("\nChoose your type of bet: ");
            String betType = input.next();
            if (betType.equals("quit"))
            {
                quit = true;
            	
            }
            else
            {
                ResolveBet(betType, wallet);
            }
            System.out.print("\nYour remaining money is: " + wallet.getMoney());
            if (wallet.getMoney() == 0)
            {
                quit = true;
            	System.out.println("\nYou don't have money now!!");
            }
        }
    }

/*
		boolean quit = false;
        wallet wallet = new wallet();
		Scanner input = new Scanner( System.in );
        System.out.print("Welcome to the Chuck-A-Luck Dice game");
        System.out.print("\nEnter your total amount of money:");
		do
		{
			System.out.print( "\nEnter a number (or enter quit):" );
			if (input.hasNextDouble()) 
			{	
		    	System.out.print("Choose your type of bet: ");
            	String betType = input.next();
                ResolveBet(betType, wallet);
            	System.out.println("Your remaining money is: " + wallet.getMoney());
            	if (wallet.getMoney() == 0)
            	{
                	quit = true;
            		System.out.println("You don't have enough money now!!");
            	}
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
 */
    
    public static void ResolveBet(String betType, wallet wallet) {
        System.out.print("Place your bets: ");
        Scanner input = new Scanner(System.in);
        double betAmount = input.nextDouble();
        double money = wallet.getMoney();
        boolean isTriple = false;
        dice dice = new dice();
        if (betAmount > money) 
        {
        	System.out.print("You don't have enough money, please try again.");
        }
        else if(betAmount <= money)
        {
            dice.rollTheDices();
            wallet.subtract(betAmount);
            
            if (dice.getFirstDice()==dice.getSecondDice()
             && dice.getSecondDice()==dice.getThirdDice()
             && dice.getThirdDice()==dice.getFirstDice()
             && dice.getFirstDice()!=1
             && dice.getFirstDice()!=6)
            {
                isTriple = true;
            }
            
            if (betType.equalsIgnoreCase("Triple")) {
                if (isTriple)
                    wallet.add(betAmount*31);
            }
            else if (betType.equalsIgnoreCase("Field")) {
                if (dice.getSum()<8 || dice.getSum()>12)
                    wallet.add(betAmount*2);
            }
            else if (betType.equalsIgnoreCase("High")) {
                if (dice.getSum()>10 && !isTriple)
                    wallet.add(betAmount*2);
            }
            else if (betType.equalsIgnoreCase("Low")) {
                if (dice.getSum()<11 && !isTriple)
                    wallet.add(betAmount*2);
            }
        }
        else
        {
            System.out.println("Invalid Numbers");
        }
    }
}
