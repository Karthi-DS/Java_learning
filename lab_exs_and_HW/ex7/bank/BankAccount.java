package lab_exs_and_HW.ex7.bank;

public class BankAccount {
    private String accountHolderName;
    private double balance;

    public BankAccount(){

    }
    public BankAccount(String acName, int balance){
        this.accountHolderName = acName;
        this.balance = balance;
    }

    public void showAccInfo(){
        System.out.println("Account holder info");
        System.out.println("Name: "+this.accountHolderName);
        System.out.println("Balance: "+this.balance);
    }

    public void updateName(String s){
        this.accountHolderName = s;
    }

    public void deposit(int amount){
        this.balance += amount;
        System.out.println("Amount: "+ amount+" added to "+this.accountHolderName);
    }

    public void withdraw(int amount){
        if(amount>this.balance) {
            System.out.println("amount exceeds balance");
            return;}
        this.balance -= amount;
        System.out.println("Amount: "+ amount+" debited from "+this.accountHolderName);
    }
}
