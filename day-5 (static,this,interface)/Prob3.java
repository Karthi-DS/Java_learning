
public class Prob3 {
    int i;
    public void sol(){
        System.out.println(this.i);
    }

    public void sol1(){
        this.sol();
    }

    Prob3(){
        this(10);
    }

    Prob3(int j) {
        this.i = j;
    }


    public static void main(String[] args) {
        Prob3 p = new Prob3();
        p.sol1();
    }
}
