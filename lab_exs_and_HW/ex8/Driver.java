package lab_exs_and_HW.ex8;

import lab_exs_and_HW.ex8.perAndSem1.*;
import lab_exs_and_HW.ex8.perAndSem1.Semester2.Sem2;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Student Name:");
        String name = sc.nextLine();

        System.out.println("Enter Roll Number:");
        String roll = sc.nextLine();

        System.out.println("Enter Sem1 Subject1 Grade:");
        double s1 = sc.nextDouble();

        System.out.println("Enter Sem1 Subject2 Grade:");
        double s2 = sc.nextDouble();

        System.out.println("Enter Sem2 Subject3 Grade:");
        double s3 = sc.nextDouble();

        System.out.println("Enter Sem2 Subject4 Grade:");
        double s4 = sc.nextDouble();

        Sem1 sem1 = new Sem1(s1, s2);
        sem1.set(name, roll);

        Sem2 sem2 = new Sem2(s3, s4);
        sem2.set(name, roll);

        sem1.printGrade();
        sem2.printGrade();

        double overallCGPA = (sem1.CGPA() + sem2.CGPA()) / 2;

        System.out.println("Overall CGPA: " + overallCGPA);
    }
}