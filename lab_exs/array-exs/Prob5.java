import java.util.Arrays;
import java.util.Scanner;

public class Prob5 {
    static boolean firstOccurrence(int[] arr, int index) {
        for (int i = 0; i < index; i++) {
            if (arr[i] == arr[index]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int n;
        int arr[];
        int repeatedArr[];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of elements: ");
        n = sc.nextInt();
        arr = new int[n];
        repeatedArr = new int[n];
        System.out.println("Enter array elements: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int idx = 0;
       for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count > 1 && firstOccurrence(arr, i)) {
                repeatedArr[idx++] = arr[i];
            }
        }

        System.out.println("No of Repeated Elements: "+idx);
        System.out.println("Repated Elements: "+ Arrays.toString(repeatedArr));
    }
}
