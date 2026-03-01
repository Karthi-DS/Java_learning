package lab_exs_and_HW.ex6;

public class Cuboid extends ThreeDShapes {
    double length, width, height;
    Cuboid(String name,String color,double length, double width, double height){
        this.name = name;
        this.color = color;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    double getVolume(){
        return this.length*this.width*this.height;
    }
}
