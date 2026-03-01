package lab_exs_and_HW.ex6;

import java.util.Scanner;

public class TestShape {
    static Scanner sc = new Scanner(System.in);

    public static Circle getCircle() {
        Circle c;
        String name, color;
        double radius;

        System.out.println("Enter circle name:");
        name = sc.nextLine();

        System.out.println("Enter circle color:");
        color = sc.nextLine();

        System.out.println("Enter circle radius (double value):");
        radius = sc.nextDouble();

        c = new Circle(name, color, radius);
        return c;
    }

    public static Cuboid getCuboid() {
        Cuboid c;
        String name, color;
        double length, width, height;

        System.out.println("Enter cuboid name:");
        name = sc.nextLine();

        System.out.println("Enter cuboid color:");
        color = sc.nextLine();

        System.out.println("Enter cuboid length:");
        length = sc.nextDouble();

        System.out.println("Enter cuboid width:");
        width = sc.nextDouble();

        System.out.println("Enter cuboid height:");
        height = sc.nextDouble();

        sc.nextLine(); // consume leftover newline

        c = new Cuboid(name, color, length, width, height);
        return c;
    }

    public static void main(String[] args) {
        int n;
        Shapes arr[];
        System.err.println("How many objects you want to create");
        n = sc.nextInt();
        arr = new Shapes[n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.err.println("Enter 0 for cuboid and 1 for circle?");
            int isCircle = sc.nextInt();
            sc.nextLine();
            if(isCircle==1){
                arr[i] = getCircle();
            }else{
                arr[i] = getCuboid();
            }
        }

        for (int i=0;i<n;i++){
            arr[i].displayInfo();
        }
    }
}
