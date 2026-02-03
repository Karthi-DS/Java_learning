package lab_exs.array_exs1;

import pk.Array;

public class Prob8 {
    public static void main(String[] args) {
        char arr1[] = Array.get1DArray(true);
        char arr2[] = Array.get1DArray(true);
        boolean isEqualArr = true;
        if (arr1.length == arr2.length) {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) {
                    isEqualArr = false;
                    System.out.println("Provided arrays are not equal");
                }
            }
        } else {
            System.out.println("Provided arrays are of diff lengths");
        }

        if (isEqualArr) {
            System.out.println("Provided arrays are equal");
        }
    }
}
