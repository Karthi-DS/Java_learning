
public class Prob1 {
    static int i = 10;
    static class InnerClass{
        static int j = 10;
        void show(){
            System.out.println(i+j);
        }
    }

    public static void main(String[] args) {
        Prob1.InnerClass obj = new Prob1.InnerClass();
        obj.show();
        System.out.println(i);
    }
}
