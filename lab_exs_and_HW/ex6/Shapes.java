package lab_exs_and_HW.ex6;

public class Shapes {
    public String color,name;
    public int sno;
    public static int count = 0;

    Shapes(){
        count++;
        this.sno = count;
    }

    void displayInfo(){
        System.out.printf("Sno: %d\nColor: %s\n Name: %s\n",this.sno,this.color,this.name);
    }

    static int countInfo(){
        return Shapes.count;
    }
}
