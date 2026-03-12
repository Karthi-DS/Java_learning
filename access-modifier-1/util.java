public class util {

    void main(){
        System.out.println("overloaded method 1");
    }

    void main(int n){
        System.out.println(n);
        System.out.println("overloaded method 2");
    }
    public static void main(String[] args) {
        util u1 = new util();
        u1.main();
        u1.main(2);
        System.out.println("main main method");
    }
}
