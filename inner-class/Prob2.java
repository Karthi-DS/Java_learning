public class Prob2 {
    int i = 10;
    class InnerClass{
        InnerClass(int j){
            i+=j;
        }

        void show(){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Prob2 p = new Prob2();
        Prob2.InnerClass p1 = p.new InnerClass(100);
        p1.show();
    }
}
