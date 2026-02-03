package pk;

import java.util.Scanner;

public class Array {
    static Scanner sc = new Scanner(System.in);

    public static int[] get1DArray() {
        int arr[] = null;
        System.out.println("Enter the no of elements");
        int n = sc.nextInt();
        arr = new int[n];
        System.out.println("Enter values");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static char[] get1DArray(boolean isCharArray) {
        char arr[] = null;
        if (isCharArray) {
            System.out.println("Enter the no of elements");
            int n = sc.nextInt();
            arr = new char[n];
            System.out.println("Enter values");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.next().charAt(0);
            }
        } 
        return arr;
    }

    public static void get1DArray(int[] arr) {
        System.out.println("Enter values");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
    }

    public static void get2DArray(int[][] arr) {
        int r = arr.length;
        int c = arr[0].length;
        System.out.println("Enter values");

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

    }

    public static int[][] get2DArray(boolean askDimensions) {
        int arr[][] = null;
        if (askDimensions == true) {
            int r, c;
            System.out.println("Enter row num: ");
            r = sc.nextInt();
            System.out.println("Enter col num: ");
            c = sc.nextInt();
            arr = new int[r][c];
            get2DArray(arr);
        } else {
            get2DArray(arr);
        }
        return arr;
    }

    public static int[][] get2DArray(boolean askDimensions, boolean isJagged) {
        int arr[][] = null;
        if (isJagged && askDimensions) {
            int r, c;
            System.out.println("Enter row num: ");
            r = sc.nextInt();
            arr = new int[r][];

            for (int i = 0; i < arr.length; i++) {
                System.out.println("Enter col num");
                c = sc.nextInt();
                arr[i] = new int[c];
                get1DArray(arr[i]);
            }
        }
        return arr;
    }
}
