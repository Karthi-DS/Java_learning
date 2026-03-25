// package ca1_prep;

public class Sheet3 {

    public static void main(String[] args) {

        int[][] a = new int[][] { { 1, 2, 3 }, { 5, 6, 7, 8, 10 }, { 0 } };

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
