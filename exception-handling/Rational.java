import java.util.Scanner;

class Rational{
    private int num;
    private int den;

    private Scanner sc = new Scanner(System.in);

    void checkException(int d) throws ArithmeticException{
        if(d==0){
            throw new ArithmeticException("Denominator cannot be zero...");
        }
    }

    Rational(int n,int d){
        while(true){
            try {
                checkException(d);
                this.num = n;
                this.den = d;
                break;
            } catch (Exception e) {
                System.out.println(e.getClass());
                System.out.println("Message: "+e.getMessage());
                System.out.println("Enter denominator again:");
                d = sc.nextInt();

            }
        }
    }

    public static void main(String[] args) {
        Rational r = new Rational(4,0);

    }
}