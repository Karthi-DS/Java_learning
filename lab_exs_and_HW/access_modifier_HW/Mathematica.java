import java.util.Scanner;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;

public class Mathematica {
    int number;
    Scanner sc = new Scanner(System.in);
    private Set<Integer> visitedNumbers = new HashSet<>();

    Mathematica() {
        System.out.println("Enter number:");
        if (sc.hasNextInt()) {
            this.number = sc.nextInt();
        }
    }

    Mathematica(int n) {
        this.number = n;
    }

    Long fact() {
        if (this.number < 0) {
            System.out.println("Factorial undefined for negative numbers.");
            return -1L;
        }
        int copyNum = this.number;
        long factNum = 1L;

        while (copyNum > 0) {
            factNum *= copyNum;
            copyNum--;
        }
        return factNum;
    }

    boolean isPerfect() {
        if (this.number <= 0) return false;

        int sum = 0;
        for (int i = 1; i <= this.number / 2; i++) {
            if (this.number % i == 0) {
                sum += i;
            }
        }
        return sum == this.number;
    }

    void setNum() {
        Random rand = new Random();
        this.number = rand.nextInt(101);
    }

    void trignometricMethods() {
        System.out.printf("cos: %.2f, sin: %.2f, tan: %.2f%n",
                Math.cos(this.number), Math.sin(this.number), Math.tan(this.number));
    }

    private int sumOfSquares(int n) {
        int sum = 0;
        n = Math.abs(n);
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    boolean happyNumber() {
        visitedNumbers.clear();
        return isHappyRecursive(this.number);
    }

    private boolean isHappyRecursive(int n) {
        if (n == 1) return true;
        if (n <= 0 || visitedNumbers.contains(n)) return false;

        visitedNumbers.add(n);
        return isHappyRecursive(sumOfSquares(n));
    }

    public void menuDriver() {
        int choice = 0;
        do {
            System.out.println("\n===== MATHEMATICA MENU (Current Num: " + this.number + ") =====");
            System.out.println("1. Calculate Factorial");
            System.out.println("2. Check if Perfect Number");
            System.out.println("3. Check if Happy Number");
            System.out.println("4. Set Random Number (0-100)");
            System.out.println("5. Calculate Trigonometric Values");
            System.out.println("6. Enter New Number");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        long f = fact();
                        if (f != -1) System.out.println("Factorial: " + f);
                        break;
                    case 2:
                        System.out.println(this.number + (isPerfect() ? " is" : " is NOT") + " a Perfect Number");
                        break;
                    case 3:
                        System.out.println(this.number + (happyNumber() ? " is" : " is NOT") + " a Happy Number");
                        break;
                    case 4:
                        setNum();
                        System.out.println("Random number set to: " + this.number);
                        break;
                    case 5:
                        trignometricMethods();
                        break;
                    case 6:
                        System.out.print("Enter new number: ");
                        this.number = sc.nextInt();
                        break;
                    case 7:
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } else {
                System.out.println("Please enter a valid integer.");
                sc.next();
            }
        } while (choice != 7);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to start: ");
        int initial = scanner.hasNextInt() ? scanner.nextInt() : 0;

        Mathematica math = new Mathematica(initial);
        math.menuDriver();
        scanner.close();
    }
}
