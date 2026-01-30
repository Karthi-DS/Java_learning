import java.util.Scanner;
import java.util.Arrays;

class Prob1{
    public static void main(String[] args){
        int arr[];
        int n;
        int p;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array length");
        n = sc.nextInt();
        arr = new int[n];
        System.out.println("Enter array elements");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println("Enter index to check in the sorted array element");
        if(!(sc.hasNextInt() && (p = sc.nextInt()) >= 0 && p < n)){
            System.out.println("Invalid index");
            return;
        }
        System.out.println("The element at position " + p + " is: " + arr[p-1]);
        
    }
}