package pk_exs.bank.model;

public class Customer {
    private String name;
    private Account account;

    public Customer(String name, Account account) {

        this.name = name;
        this.account = account;
    }

    // protected String getName() {
    //     return name;
    // }

    public String getName() {
        return name;
    }

    public Account getAccount() {
        return account;
    }
}