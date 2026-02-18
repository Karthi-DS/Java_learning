package lab_exs_and_HW.array_exs1;

import pk.Array;
import java.util.Scanner;

public class Prob1 {
    static Scanner sc = new Scanner(System.in);

    public static int[] rowSum(int arr[][]) {
        int a[] = new int[arr.length];
        int r = arr.length;
        int c = arr[0].length;
        for (int i = 0; i < r; i++) {
            int sum = 0;
            for (int j = 0; j < c; j++) {
                sum += arr[i][j];
            }
            a[i] = sum;
        }

        return a;
    }

    public static int[] colSum(int arr[][]) {
        int a[] = new int[arr.length];
        int r = arr.length;
        int c = arr[0].length;
        for (int i = 0; i < c; i++) {
            int sum = 0;
            for (int j = 0; j < r; j++) {
                sum += arr[j][i];
            }
            a[i] = sum;
        }

        return a;
    }

    public static void main(String[] args) {
        int r, c;
        int arr[][];
        System.out.println("Enter row num: ");
        r = sc.nextInt();
        System.out.println("Enter col num: ");
        c = sc.nextInt();
        arr = new int[r][c];
        Array.get2DArray(arr);

        int rowSumArr[] = rowSum(arr);
        int colSumArr[] = rowSum(arr);

        int[][] newArr = new int[r + 1][c + 1];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                newArr[i][j] = arr[i][j];
            }
        }

        for (int i = 0; i < r; i++) {
            newArr[i][c] = rowSumArr[i];
        }

        for (int j = 0; j < c; j++) {
            newArr[r][j] = colSumArr[j];
        }

        int total = 0;
        for (int x : rowSumArr)
            total += x;
        newArr[r][c] = total;

        System.out.println("Final matrix:");
        for (int i = 0; i <= r; i++) {
            for (int j = 0; j <= c; j++) {
                System.out.print(newArr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
