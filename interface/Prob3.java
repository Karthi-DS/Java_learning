interface AnimalInterface{
    int age=0;
    static int animalCount=10;

    static void staticMethod(){

    } // like static methods in class

    default void method(){
        System.out.println("method from animal interface");
    }

    void show();
}

interface MammalInterface extends AnimalInterface{
    int animalCount = 20;

    void print();

    default void method(){
        System.out.println("method from mammal interface");
    }
}

public class Prob3 implements MammalInterface{

    public void print(){
        System.out.println("show method");
    }

    public void show(){
    }

    public void method(){
        MammalInterface.super.method();
    }

    public static void main(String args[]){
        Prob3 obj = new Prob3();
        obj.method();
        System.out.println("animal count: "+ obj.animalCount);
    }
}