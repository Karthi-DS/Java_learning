import java.util.Arrays;
import java.util.Scanner;

public class Prob6 {
    static boolean isPrime(int n){
        for(int i=1; i<n/2; i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    static void splitArray(int[] arr,int[] comp, int[] prime){
        int i=0,j=0;
        for(int k=0; k<arr.length; k++){
            if(isPrime(arr[k])){
                prime[i++] = arr[k];
            }else{
                comp[j++] = arr[k];
            }
        }
    }
    public static void main(String[] args) {
        int n;
        int arr[], comp[], prime[];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of elements: ");
        n = sc.nextInt();
        arr = new int[n];
        comp = new int[n];
        prime = new int[n];
        System.out.println("Enter the elements: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        splitArray(arr, comp, prime);

        System.out.println("Prime Numbers: "+ Arrays.toString(prime));
        System.out.println("Composite Numbers: "+ Arrays.toString(comp));
    }
}
