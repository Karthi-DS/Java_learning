package lab_exs_and_HW.String_HW;

import java.util.*;

class NameFormatter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine().trim().replaceAll("\\s+", " ");

        String upper = name.toUpperCase();

        String[] words = upper.split(" ");

        StringBuilder initials = new StringBuilder();
        for (String w : words) {
            initials.append(w.charAt(0)).append(".");
        }

        System.out.println(upper + " | Initials: " + initials);
    }
}

