import java.io.*;

interface testInterface{
    final int a = 10; // default public final will be added
}

public class Interface implements testInterface{
    public static void main(String[] args){
        Interface cls = new Interface();
        System.out.println(cls.a);
    }
}