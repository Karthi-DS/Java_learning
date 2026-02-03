package lab_exs.array_exs1;

import pk.Array;

public class Prob7 {
    public static void main(String[] args) {
        char arr[] = Array.get1DArray(true);
        boolean isPalindrome = true;
        for(int i=0; i<arr.length/2; i++){
            if(arr[i] != arr[arr.length-1-i]){
                isPalindrome = false;
                System.out.println("Provided Character array is not a palindrome");
            }
        }

        if(isPalindrome){
            System.out.println("Provided Character array is a palindrome");
        }
    }
}
