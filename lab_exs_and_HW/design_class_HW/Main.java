package lab_exs_and_HW.design_class_HW;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();  

        Prob1[] students = new Prob1[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for student " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            int[] marks = new int[3];
            System.out.println("Enter 3 subject marks:");
            for (int j = 0; j < 3; j++) {
                marks[j] = sc.nextInt();
            }
            sc.nextLine(); 

            students[i] = new Prob1(name, marks);
        }

        for (int i = 0; i < n; i++) {
            students[i].display();
        }

        System.out.println("\nTotal objects created: " + Prob1.count);

        sc.close();
    }
}
