package programming2test.etest2;

public class LineTest {
    public static void main(String[] args){
        Point theFirstPoint = new Point(6,5);
        Point theSecondPoint = new Point(7, 7);
        Line output1 = new Line(theFirstPoint, theSecondPoint);
        System.out.print("point1-x-axis " + output1.getP1().getX());
        System.out.print("\npoint1-y-axis " + output1.getP1().getY());
        System.out.print("\npoint2-x-axis " + output1.getP2().getX());
        System.out.print("\npoint2-y-axis " + output1.getP2().getY());
        Line output2 = new Line(6, 8, 7, 7);
        System.out.print("\nfirst slope data " + output1.getSlope());
        System.out.print("\nsecond slope data " + output2.getSlope());
        System.out.print("\nThe first output's end points are : ");
        System.out.print("\n[" + output1.getP1().getX() + " , " + output1.getP1().getY() + "]");
        System.out.print("\n[" + output1.getP2().getX() + " , " + output1.getP2().getY() + "]");
        System.out.print("\nThe second output's end points are : ");
        System.out.print("\n[" + "6" + " , " + "8" + "]");
        System.out.print("\n[" + "7" + " , " + "7" + "]");
        if(output1.getP1().getX() == output1.getP2().getX()){
            System.out.print("\nThis is a vertical line");
        }
    }
}
