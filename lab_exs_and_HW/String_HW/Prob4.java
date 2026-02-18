package lab_exs_and_HW.String_HW;

import java.util.Arrays;

public class Prob4 {

    public static int[] compute(int[] marks){
        int res[] = {(int)Arrays.stream(marks).average().getAsDouble(),Arrays.stream(marks).max().getAsInt(),Arrays.stream(marks).min().getAsInt()};
        return res;
    }
    public static void main(String[] args) {
        int[] marks = new int[5];
        // calculation
        pk.Array.get1DArray(marks);
        int res[] = compute(marks);

        System.out.printf(" avg: %d max: %d min: %d",res[0],res[1],res[2]);
    }
}
