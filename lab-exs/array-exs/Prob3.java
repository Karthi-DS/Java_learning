import java.util.Scanner;

public class Prob3 {
    public static void main(String args[]){
        int arr[][];
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n for square matrix: ");
        n = sc.nextInt();
        arr = new int[n][n];
        System.out.println("Enter the elements two dimensional array: ");

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int sum = arr[0][0] + arr[0][n-1] + arr[n-1][0] + arr[n-1][n-1];
        System.out.println("The sum of diagonal is "+ sum);
    }
}
