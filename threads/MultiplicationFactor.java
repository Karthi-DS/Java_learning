
class Factors extends Thread{
    int n;
    Factors(int n){
        this.n = n;
    }

    void compute(int n){
       System.out.println("Factors: ");
       for(int i=1; i<n/2; i++){
        if(n%i==0){
            System.out.print(i+ " ");
        }
       }
    }

    public void run(){
            compute(n);
    }
}


class Multiplication extends Thread{
    int n;
    Multiplication(int n){
        this.n = n;
    }

    void compute(int n){
       System.out.println("Multiplication Table till 10 times");

       for(int i=1; i<10; i++){
        System.out.println(i*n);
       }
    }

    public void run(){
        compute(n);
    }
}


public class MultiplicationFactor {
    static Multiplication c = new Multiplication(11);
    static Factors g = new Factors(11);

    public static void main(String[] args) {
        c.start();
        g.start();
    }
}
