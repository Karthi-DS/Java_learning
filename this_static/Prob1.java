
public class Prob1 {
    static int a[];
    public static void main(String[] args) {
        int address = System.identityHashCode(a);
        System.out.println(address); // 0
        func(a);
    }

    static void func(int a[]){
        a = new int[3];
        System.out.println(System.identityHashCode(a)); //622488023
    }
}
