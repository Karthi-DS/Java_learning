package lab_exs_and_HW.String_HW;

import java.util.Scanner;

public class Prob7 {
    public static void main(String[] args) {
        String[] songs = {"A", "B", "C"};

        Scanner sc = new Scanner(System.in);
        String key = sc.nextLine();

        boolean found = false;

        for (String song : songs) {
            if (song.equalsIgnoreCase(key)) {
                found = true;
                break;
            }
        }

        if (found) System.out.println("Song found");
        else System.out.println("Song not found");
    }
}
