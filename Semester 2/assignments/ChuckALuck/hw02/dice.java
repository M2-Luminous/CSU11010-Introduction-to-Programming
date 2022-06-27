package hw02;

import java.util.Random;

public class dice {
	private int theFirstDice;
	private int theSecondDice;
	private int theThirdDice;

	public void rollTheDices()
	{
		Random generator = new Random(123);
		theFirstDice = 1 + generator.nextInt(6);
		theSecondDice = 1 + generator.nextInt(6);
		theThirdDice = 1 + generator.nextInt(6);
	}
	
	public int getFirstDice()
	{
		return theFirstDice;
	}
	
	public int getSecondDice()
	{
		return theSecondDice;
	}
	
	public int getThirdDice()
	{
		return theThirdDice;
	}
	
	public int getSum() 
	{
		int summary = theFirstDice + theSecondDice + theThirdDice;
		return summary;
	}
	/*
	 *public class dice {
	public int theFirstDice;
	public int theSecondDice;
	public int theThirdDice;

	public void rollTheDices()
	{
		Random generator = new Random(123);
		theFirstDice = 1 + generator.nextInt(6);
		theSecondDice = 1 + generator.nextInt(6);
		theThirdDice = 1 + generator.nextInt(6);
	}
	
	
	public int getSum() 
	{
		int summary = theFirstDice + theSecondDice + theThirdDice;
		return summary;
	}
	 */
}
