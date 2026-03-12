class Util{
    Util(int a){
        System.out.println("integer a is "+a);
    }
}

public class Prob2 extends Util {
    Prob2(){
        super(10);
    }
    public static void main(String[] args) {
        System.out.println("hello");
    }
}
