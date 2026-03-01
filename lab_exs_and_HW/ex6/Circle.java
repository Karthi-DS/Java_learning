package lab_exs_and_HW.ex6;

public class Circle extends TwoDShapes {
    public double radius;
    private final float pie = 22.7f;
    Circle(String name, String color, double radius){
        this.name = name;
        this.color = color;
        this.radius = radius;
    }

    double getArea(){
        this.displayInfo();
        return this.pie*Math.pow(radius, 2);
    }
}
