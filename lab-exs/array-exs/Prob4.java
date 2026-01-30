import java.util.Scanner;

public class Prob4 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n to know the sum of elements: ");
        n = sc.nextInt();
        int sum = (n*(n+1))/2;
        System.out.println("Sum: "+ sum);
    }
}
