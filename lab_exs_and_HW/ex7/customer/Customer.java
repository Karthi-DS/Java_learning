package lab_exs_and_HW.ex7.customer;

import lab_exs_and_HW.ex7.bank.BankAccount;
import java.util.Scanner;

public class Customer {
    String name;
    BankAccount bk;
    private int flag;
    private Scanner sc = new Scanner(System.in);
    
    public Customer(BankAccount bk){
        this.bk = bk;
    }

    public void updateName(String s){
        bk.updateName(s);
    }

    public void performTransaction(){
        System.out.println("Withdraw - 1/ Deposit -2");
        flag = sc.nextInt();
        System.out.println("Enter amount");
        int amount = sc.nextInt();
        if(flag==1){
            bk.withdraw(amount);
        }else if(flag==2){
            bk.deposit(amount);
        }else{
            System.out.println("Please enter correct option");
        }
    }
}
