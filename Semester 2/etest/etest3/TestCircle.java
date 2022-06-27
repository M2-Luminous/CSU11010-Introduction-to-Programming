package programming2test.etest3;

public class TestCircle {
    public static void main(String[] args){
        GeometricObject c = new Circle(1);
        System.out.println("Perimeter of circle is " + c.getPerimeter());
        System.out.println("Area of circle is " + c.getArea());
    }
}
