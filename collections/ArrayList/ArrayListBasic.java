
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListBasic {
    ArrayList<Integer> arr = new ArrayList<>();
    ArrayList<ArrayList<Integer>> arr2d = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    ArrayListBasic(Integer val1, Integer val2) {
        arr.add(val1);
        arr.add(val2);
    }

    ArrayList tmpArr() {
        ArrayList<Integer> tmp = new ArrayList<>();
        System.out.println("Enter elements type q to quit");
        while (sc.hasNextInt()) {
            int val = sc.nextInt();
            tmp.add(val);
        }
        sc.next();
        System.out.println("arr" + tmp);
        return tmp;
    }

    void init2d() {
        System.out.println("How many list you need?");
        int n = sc.nextInt();
        sc.nextLine();
        while (n > 0) {
            arr2d.add(tmpArr());
            n--;
        }
        System.out.println("arr: " + arr2d);
    }

    void print() {
        System.out.println(arr);
    }

    public static void main(String[] args) {
        ArrayListBasic c = new ArrayListBasic(3, 5);
        c.print();
        c.init2d();
    }
}
