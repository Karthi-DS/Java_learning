package lab_exs_and_HW.String_HW;

import java.util.Scanner;

public class Prob3 {
    public static void main(String[] args) {
        String pwd = new Scanner(System.in).nextLine();
        // validation
        boolean isUpperCaseFound = false, isDigitFound = false;
        for(char x: pwd.toCharArray()){
            if(Character.isUpperCase(x)){
                isUpperCaseFound = true;
            }
            if(Character.isDigit(x)){
                isDigitFound = true;
            }
        }

        if(isDigitFound && isUpperCaseFound) System.out.println("Strong Password");
        else System.out.println("Not a Strong Password");
    }
}
