package pk_exs.bank.model;

public class Test {

    public static void main(String[] args) {
        System.out.println("proctected methods can able to use inside package without inheritance");
        Customer c = new Customer("karthi", null);
        System.out.println(c.getName());
    }
}
