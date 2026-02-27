package pk_exs.bank.util;

public class Validation {
    public static boolean isValidAmount(double amount) {
        return amount > 0;
    }

    public static boolean hasSufficientBalance(double balance, double withdrawAmount) {
        return balance >= withdrawAmount;
    }
}