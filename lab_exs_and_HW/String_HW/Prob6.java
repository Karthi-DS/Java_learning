package lab_exs_and_HW.String_HW;

import java.util.Scanner;

public class Prob6 {
    public static void main(String[] args) {
        String email = new Scanner(System.in).nextLine();
        // validation
        System.out.println(email.indexOf("@")+ " "+email.indexOf(".") );
        if(email.indexOf("@")<email.indexOf(".") ) System.out.println("true");
        else System.out.println("false");
    }
}
