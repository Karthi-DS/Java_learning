abstract class ab{
    abstract public void print();
}

public class AbstractClass extends ab{
    @Override
    public void print(){
        System.out.println("overriding abstract method...");
    }

    public static void main(String[] args){
        AbstractClass ab1 = new AbstractClass();
        ab1.print();
        System.out.println("hello");
    }
}