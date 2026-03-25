// package ca1_prep;

import java.util.Arrays;

public class Sheet1 {


    public static void main(String[] args) {

    String s1 = new String("java");
    String s2 = new String("kava");
        System.out.println(s1.equals(s2));
        System.out.println(s1.charAt(0));
        System.out.println(s2.contains("ava"));
        System.out.println(s2.indexOf("a"));
        System.out.println("  karthi ".trim());
        System.out.println(Arrays.toString("hello i am karthi".split(" ")));
        System.out.println(s1.toString());
        String myStr = "Hello";
        System.out.println(myStr.replace('l', 'p'));
        System.out.println(myStr.substring(2,4));
    }
}
