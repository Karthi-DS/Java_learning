// package ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Prob2 {
    ArrayList<String> students = new ArrayList();
    ArrayList<String> employees = new ArrayList<>();
    ArrayList<Integer> ratings = new ArrayList<>();
    ArrayList<String> books = new ArrayList<>();
    ArrayList<Long> phones = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void findStudent() {
        students.add("25mx212");
        students.add("25mx114");
        students.add("25mx221");

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i) == "25mx212") {
                System.out.println("found 25mx212");
            }
        }
    }

    public void updateEmployees() {
        employees.add("karthi-male");
        employees.add("kavin-male");
        employees.add("shairaaj-male");

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).contains("male")) {
                employees.set(i, "Mr. " + employees.get(i).split("-")[0]);
            } else {
                employees.set(i, "Ms. " + employees.get(i).split("-")[0]);
            }
        }

        System.out.println(employees);
    }

    public void getFrequency() {
        int[] frequency = new int[5];

        for (int i = 0; i < 30; i++) {
            ratings.add((i) % 5 == 0 ? 1 : (i) % 5);
        }

        for (int i = 0; i < 30; i++) {
            frequency[ratings.get(i)]++;
        }

        System.out.println("max rated : " + Arrays.stream(frequency).max().getAsInt());
    }

    public void getTitle(String s) {
        books.add("java book - 1");
        books.add("maths books -1");

        for (String x : books) {
            if (x.contains(s))
                System.out.println(x);
        }
    }

    public void getProvisions(Long number) {
        phones.add(8987897982L);
        phones.add(9787878971L);

        for (int i = 0; i < phones.size(); i++) {
            Long p = phones.get(i);
            if (p != null && p.equals(number)) {
                System.out.println("Number found.\n1. Edit\n2. Delete");
                int option = sc.nextInt();
                if (option == 1) {
                    Long newNumber = sc.nextLong();
                    phones.set(i, newNumber);
                    System.out.println("Updated");
                } else {
                    phones.remove(i);
                    System.out.println("Deleted");
                }
                break;
            }
        }
    }

    public void markAnalyzer() {
        ArrayList<Integer> scores = new ArrayList<>();

        System.out.println("Enter number of students:");
        int n = sc.nextInt();

        System.out.println("Enter scores (0-100):");
        for (int i = 0; i < n; i++) {
            scores.add(sc.nextInt());
        }

        int sum = 0;
        for (int x : scores) {
            sum += x;
        }
        double avg = (double) sum / n;

        int less50 = 0;
        int range50_60 = 0;
        int range60_70 = 0;
        int range70_100 = 0;

        for (int x : scores) {
            if (x < 50) {
                less50++;
            } else if (x <= 60) {
                range50_60++;
            } else if (x <= 70) {
                range60_70++;
            } else {
                range70_100++;
            }
        }

        System.out.println("\n--- Mark Analysis ---");
        System.out.println("Average Score: " + avg);

        System.out.println("\nScore Distribution:");
        System.out.println("< 50          : " + less50);
        System.out.println("50 - 60       : " + range50_60);
        System.out.println("61 - 70       : " + range60_70);
        System.out.println("71 - 100      : " + range70_100);
    }

    public static void main(String[] args) {
    Prob2 obj = new Prob2();

    obj.markAnalyzer();

    obj.findStudent();
    obj.updateEmployees();
    obj.getFrequency();
    obj.getTitle("java");
    obj.getProvisions(8987897982L);
}

}
