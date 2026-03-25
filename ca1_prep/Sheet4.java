// package ca1_prep;

import java.util.Scanner;

public class Sheet4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] names = new String[3];

        for (int i = 0; i < 3; i++) {
            names[i] = sc.next();
        }

        for (String name : names) {
            System.out.println(name);
        }
    }
}
