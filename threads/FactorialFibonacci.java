
class Generate extends Thread{
    int n;
    Generate(int n){
        this.n = n;
    }

    int compute(int n){
        if(n<=1){
            return n;
        }
                
        return compute(n-1) + compute(n-2);
    }

    public void run(){
        for(int i=0; i<n; i++){
            System.out.print(compute(i)+" ");
        }
    }
}


class Compute extends Thread{
    int n;
    Compute(int n){
        this.n = n;
    }

    int compute(int n){
        if(n==1){
            return 1;
        }
        int res = n*compute(n-1);

        return res;
    }

    public void run(){
        System.out.println("Computed Factorial: "+compute(n));
    }
}


public class FactorialFibonacci {
    static Compute c = new Compute(11);
    static Generate g = new Generate(10);

    public static void main(String[] args) {
        c.start();
        g.start();
    }
}
