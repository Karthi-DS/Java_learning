package pk_exs.bank.service;

import pk_exs.bank.model.Account;
import pk_exs.bank.util.Validation;

public class AccountService {

    public void deposit(Account account, double amount) {

        if (Validation.isValidAmount(amount)) {
            account.setBalance(account.getBalance() + amount);
            System.out.println("Deposit Successful!");
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(Account account, double amount) {

        if (!Validation.isValidAmount(amount)) {
            System.out.println("Invalid withdrawal amount!");
            return;
        }

        if (Validation.hasSufficientBalance(account.getBalance(), amount)) {
            account.setBalance(account.getBalance() - amount);
            System.out.println("Withdrawal Successful!");
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    public void checkBalance(Account account) {
        System.out.println("Current Balance: " + account.getBalance());
    }
}