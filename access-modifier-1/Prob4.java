class util {
    int n;

    util(){
        int n = 10;
        this.n = n;
        // this(n); -- need java version 25
    }

    util(int n){
        this.n = n;
    }

    int util(){
        return this.n;
    }
}

public class Prob4{
    public static void main(String[] args){
        util u1 = new util(100);
        System.out.println(u1.n);
        System.out.println(u1.util());
    }
}