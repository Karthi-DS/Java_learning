class Util{
    Util(){
        System.out.println("From parent");
    }
}


public class Prob1 extends Util {

    Prob1(){
        System.out.println("in child");
    }

    public static void main(String args[]){
        System.out.println("inside child main");
        Prob1 p = new Prob1();
    }
}
