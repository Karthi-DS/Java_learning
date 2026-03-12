package lab_exs_and_HW.ex7;

import lab_exs_and_HW.ex7.bank.BankAccount;
import lab_exs_and_HW.ex7.customer.Customer;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of customers: ");
        int n = sc.nextInt();
        sc.nextLine();

        BankAccount[] accounts = new BankAccount[n];
        Customer[] customers = new Customer[n];

        for(int i = 0; i < n; i++) {

            System.out.println("\nCustomer " + (i+1));

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Initial Balance: ");
            int balance = sc.nextInt();
            sc.nextLine();

            accounts[i] = new BankAccount(name, balance);

            customers[i] = new Customer(accounts[i]);

            customers[i].performTransaction();
        }

        System.out.println("\n------ Account Details ------");

        for(int i = 0; i < n; i++) {
            accounts[i].showAccInfo();
            System.out.println();
        }

        sc.close();
    }
}