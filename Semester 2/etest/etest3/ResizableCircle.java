package programming2test.etest3;

public class ResizableCircle extends Circle implements Resizable{
    ResizableCircle(double radius){
        super(radius);
    }
    public void resize(int percentage) {
        double multiplier = 1 + (double)percentage / 100;
        radius = (double)radius * multiplier;
    }
    public double getPerimeter(){
        return radius*2*Math.PI;
    }
    public double getArea(){
        return Math.PI*Math.pow(radius, 2);
    }
}

