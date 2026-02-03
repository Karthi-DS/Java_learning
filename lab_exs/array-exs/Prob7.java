import java.util.Arrays;
import java.util.Scanner;

public class Prob7 {
    public static void main(String[] args) {
        float arr[][];
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n for square matrix: ");
        n = sc.nextInt();
        arr = new float[n][n];
        System.out.println("Enter the elements: ");
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextFloat();
            }
        }

        for(int i=0;i<n;i++){
            Arrays.sort(arr[i]);
        }
        System.out.println("Sorted Array: ");
        for(int i=0;i<n;i++){
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
