

interface testInterface{
    final int a = 10; // default public final will be added
}

public class Interface{
    public static void main(String[] args){
        System.out.println(testInterface.a);
    }
}