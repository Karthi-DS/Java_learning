interface A {
    default void method() {
        System.out.println("Interface method...");
    }
}

public class InterfaceProb implements A {

    public void method() {
        A.super.method();   
    }

    public static void main(String args[]) {
        InterfaceProb obj = new InterfaceProb();
        obj.method();
    }
}