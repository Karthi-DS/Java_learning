package lab_exs_and_HW.ex5;

public class Prob1 {
    private int num;
    private int den;

    Prob1(){
        this.num = 10;
        this.den = 2;
    }

    Prob1(int num, int den){
        this.num = num;
        this.den = den;
    }

    public String sum(Prob1 p){
        int n1 = Integer.valueOf(p.toString().split("/")[0]);
        int d1 = Integer.valueOf(p.toString().split("/")[1]);
        int fn = n1+this.num;
        int fd = d1+this.den;
        return fn+"/"+fd;
    }

    public static int findGCD(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public String divide(Prob1 p){
        int n1 = Integer.valueOf(p.toString().split("/")[0]);
        int d1 = Integer.valueOf(p.toString().split("/")[1]);
        
        int fn = this.num*d1;
        int fd = this.den*n1;
        int gcd = findGCD(fn, fd);
        while((fn%gcd==0 && fd%gcd==0)){

            fn/=gcd;
            fd/=gcd;
        }
        return fn+"/"+fd;
    }


    public String toString(){
        return this.num+"/"+this.den;
    }

   public String toString(int p) {
    float res = (float) this.num / this.den;
    res = Math.abs(res);
    String r = String.valueOf(res);
    
    if (!r.contains(".")) {
        return "Rational number numerator/denominator is " + r;
    }

    String[] parts = r.split("\\."); 
    String integerPart = parts[0];
    String fractionalPart = parts[1];
    
    String precisionPart = fractionalPart.substring(0, Math.min(p, fractionalPart.length()));
    
    String c = integerPart + "." + precisionPart;
    return "Rational number numerator/denominator is " + c;
}

    
    public static void main(String[] args){
        Prob1 p1 = new Prob1(6,3);
        Prob1 p2 = new Prob1(6,9);

        String d = p1.divide(p2);
        String s = p1.sum(p2);
        System.out.println(d);
        System.out.println(s);
    }
}
