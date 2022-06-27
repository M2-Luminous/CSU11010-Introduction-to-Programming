/*
public class TwelveDays {

	public static void main(String[] args) {

		final int NUMBER_OF_DAYS = 12;
		for (int dayNumber=1; (dayNumber<=NUMBER_OF_DAYS); dayNumber++)
		{
			String dayNumberName = (dayNumber==12) ? "twelfth" :
				       (dayNumber==11) ? "eleventh" : (dayNumber==10) ? "tenth" : 
				       (dayNumber==9) ? "ninth" : (dayNumber==8) ? "eighth" :
				       (dayNumber==7) ? "seventh" : (dayNumber==6) ? "sixth" :
                       (dayNumber==5) ? "fifth" : (dayNumber==4) ? "fourth" :
                       (dayNumber==3) ? "third" : (dayNumber==2) ? "second" : "first";
			System.out.println("On the " + dayNumberName + " day of Christmas,\nMy true love sent to me:");不知道为什么老师这么喜欢这种结构
			switch (dayNumber)
			{
			case 12:
				System.out.println( "12 Drummers Drumming," );
			case 11:
				System.out.println( "11 Pipers Piping," );
			case 10:
				System.out.println( "10 Lords a Leaping," );
			case 9:
				System.out.println( "9 Ladies Dancing," );
			case 8:
				System.out.println( "8 Maids a Milking," );
			case 7:
				System.out.println( "7 Swans a Swimming," );
			case 6:
				System.out.println( "6 Geese a Laying," );
			case 5:
				System.out.println( "5 Golden Rings," );
			case 4:
				System.out.println( "4 Calling Birds," );
			case 3:
				System.out.println( "3 French Hens," );
			case 2:
				System.out.println( "2 Turtle Doves," );
			case 1:
				if (dayNumber!=1)
					System.out.print("and ");
				System.out.println( "a Partridge in a Pear Tree.\n" );
			default:
			}
		}
	}
	
	public static String ordinalString(int number) 用了function结构 超纲了啊~~
	{
		String ordinalNumberName = (number==12) ? "twelfth" :
		       (number==11) ? "eleventh" : (number==10) ? "tenth" : 
		       (number==9) ? "ninth" : (number==8) ? "eighth" :
		       (number==7) ? "seventh" : (number==6) ? "sixth" :
            (number==5) ? "fifth" : (number==4) ? "fourth" :
            (number==3) ? "third" : (number==2) ? "second" : "first";

		return ordinalNumberName;
	}
}
 */
public class TwelveDaysofChristmas {
	public static final int DAYS= 12;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	for(int present = 1; present <= DAYS; present++)
	{
		String nameOfEachDay = "";
		switch (present)
		{
		case 12 :
			nameOfEachDay = "twelfth";
			break;
		case 11 :
			nameOfEachDay = "eleventh";
			break;
		case 10 :
			nameOfEachDay = "tenth";
			break;
		case 9 :
			nameOfEachDay = "ninth";
			break;
		case 8 :
			nameOfEachDay = "eighth";
			break;
		case 7 :
			nameOfEachDay = "seventh";
			break;
		case 6 :
			nameOfEachDay = "sixth";
			break;
		case 5 :
			nameOfEachDay = "fifth";
			break;
		case 4 :
			nameOfEachDay = "fourth";
			break;
		case 3 :
			nameOfEachDay = "third";
			break;
		case 2 :
			nameOfEachDay = "second";
			break;
		case 1 :
			nameOfEachDay = "first";
		    break;
		}
		System.out.print("On the " + nameOfEachDay +" day of Christmas" +
				"my true love sent to me:\n");
		switch (present)
		{
		case 12 :
			System.out.println("12 drummers drumming, \n");
		case 11 :
			System.out.println("11 pipers piping, \n");
		case 10 :
			System.out.println("10 lords a-leaping, \n");
		case 9 :
			System.out.println("9 ladies dancing, \n");
		case 8 :
			System.out.println("8 maids a-milking, \n");
		case 7 :
			System.out.println("7 swans a-swimming, \n");
		case 6 :
			System.out.println("6 geese a-laying, \n");
		case 5 :
			System.out.println("5 gold rings, \n");
		case 4 :
			System.out.println("4 calling birds, \n");
		case 3 :
			System.out.println("3 french hens, \n");
		case 2 :
			System.out.println("2 turtle doves, \n");
			System.out.println("and a partridge in a pear tree.\n");
			break;
		case 1 :
			System.out.println("a partridge in a pear tree.\n");
		    break;
			}
		}
	}
}

