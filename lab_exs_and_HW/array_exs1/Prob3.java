package lab_exs.array_exs1;

import java.util.Arrays;
import pk.Array;

public class Prob3 {
    public static void main(String[] args) {
        int arr[] = Array.get1DArray();
        int last = arr.length-1;
        for(int i=0; i<arr.length/2; i++){
            int temp = arr[i];
            arr[i] = arr[last-i];
            arr[last-i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
