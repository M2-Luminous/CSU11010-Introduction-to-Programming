package programming2test.etest3;

public class Circle implements GeometricObject{
    double radius;
    Circle(double radius){
        this.radius = radius;
    }
    public double getPerimeter(){
        return radius*2*Math.PI;
    }
    public double getArea(){
        return Math.PI*Math.pow(radius, 2);
    }
}
