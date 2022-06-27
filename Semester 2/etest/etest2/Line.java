package programming2test.etest2;

public class Line {
    private Point p1;
    private Point p2;
    Line(Point theFirstPoint, Point theSecondPoint){
        p1 = theFirstPoint;
        p2 = theSecondPoint;
    }
    public Point getP1(){
        return this.p1;
    }
    public Point getP2(){
        return this.p2;
    }
    Line(int x1, int y1, int x2, int y2){
        p1 = new Point(x1, y1);
        p2 = new Point(x2, y2);
    }
    public double getSlope(){
        if(p2.getX() == p1.getX()){
            throw new ArithmeticException("\nWrong! Parameter Undefined.");
        }
        else {
            return ((p2.getY() - p1.getY()) / (p2.getX() - p1.getX()));
        }
    }
}
