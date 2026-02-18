package lab_exs_and_HW.String_HW;

import java.util.*;

class Prob8 {
    public static void main(String[] args) {
        String text = new Scanner(System.in).nextLine();

        int vowels = 0, digits = 0, spaces = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // vowel check
            if ("aeiouAEIOU".indexOf(ch) != -1) {
                vowels++;
            }

            // digit check
            if (Character.isDigit(ch)) {
                digits++;
            }

            // space check
            if (ch == ' ') {
                spaces++;
            }
        }

        System.out.println("Vowels=" + vowels +
                " Digits=" + digits +
                " Spaces=" + spaces);
    }
}
