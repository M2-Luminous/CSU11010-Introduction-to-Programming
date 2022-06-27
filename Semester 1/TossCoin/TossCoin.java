/*
 * Write a program to determine simulate the toss of a coin.  For 10,000 tosses
 * determine how many heads and how many tails are tossed.  Also indicate what the
 * last toss was (tails or heads).
 * 
 * To simulate a coin toss we just need to obtain a random number with is either 0
 * (tails) or 1 (heads).
 */
import java.util.Random;
public class TossCoin {
	public static final int NUMBER_OF_THROWS = 10000;
	public static final int POSITIVE = 1;
	public static final int NEGATIVE = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean headsShownOnCoin = false;
		int headsCount = 0;
		Random  generator = new Random(2333);
		
		for (int throwCount=0; throwCount < NUMBER_OF_THROWS; throwCount++)
		{
			headsShownOnCoin = (generator.nextInt(2) == POSITIVE);// 0 和 1
			headsCount += (headsShownOnCoin) ? 1 : 0;//如果是随机出来是1的话就加1,否则就加0
		}

		System.out.println( "POSITIVE: " + headsCount +
				"\nNEGATIVE: " + (NUMBER_OF_THROWS-headsCount) +
				"\nLAST: " + ((headsShownOnCoin) ? "POSITIVE" : "NEGATIVE"));

	}

}
