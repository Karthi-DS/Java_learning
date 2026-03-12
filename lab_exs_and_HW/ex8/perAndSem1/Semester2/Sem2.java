package lab_exs_and_HW.ex8.perAndSem1.Semester2;

import lab_exs_and_HW.ex8.perAndSem1.*;
import lab_exs_and_HW.ex8.*;

public class Sem2 extends Student implements Header {

    static final int credit3 = 3;
    static final int credit4 = 4;

    double sub3, sub4;

    public Sem2(double x, double y){
        sub3 = x;
        sub4 = y;
    }

    public double CGPA(){
        return ((sub3 * credit3) + (sub4 * credit4)) / (credit3 + credit4);
    }

    public void printGrade(){

        headPrint();

        System.out.println("Student Name: " + name);
        System.out.println("Roll No: " + rollno);
        System.out.println("Semester 2");

        System.out.println("Subject 3: " + sub3);
        System.out.println("Subject 4: " + sub4);

        System.out.println("CGPA of this Semester: " + CGPA());
        System.out.println();
    }

}