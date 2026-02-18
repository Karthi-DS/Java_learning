package lab_exs_and_HW.array_exs1;

import java.util.Arrays;

import pk.Array;

public class Prob6 {
    public static void main(String[] args) {
        char arr[] = Array.get1DArray(true);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 'a' && arr[i] <= 'z') {
                arr[i] = (char) (arr[i] - 32);
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
