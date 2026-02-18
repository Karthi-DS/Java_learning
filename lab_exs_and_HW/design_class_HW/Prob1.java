package lab_exs_and_HW.design_class_HW;
import java.util.Arrays;

import pk.Array;

public class Prob1 {
    private String name;
    private int marks[];
    private int total;
    private float perc;
    static int count;

    Prob1(){
        System.out.println("Subject 1: English\n Subject 2: Maths\n Subject 3: Science");
    }
    
    Prob1(String name,int marks[]){
        count++;
        this.name = name;
        this.marks = marks;
    }

    public void editMarks(){
        System.out.println("Edit marks for all subjects!!");
        Array.get1DArray(marks);
    }

    public void display(){
        System.out.println("Student name: "+this.name+" marks: "+Arrays.toString(this.marks));
    }


}
