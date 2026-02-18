package lab_exs_and_HW.String_HW;

import java.util.Scanner;

public class Prob2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String msg = sc.nextLine();
        // cleaning logic

        msg = msg.toLowerCase();
        msg = msg.replace("bad", "good");
        System.out.println(msg);
    }
}
