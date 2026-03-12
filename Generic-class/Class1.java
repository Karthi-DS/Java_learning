package Generic_class;

public class Class1<N> {
    public N val;

    Class1(N val){
        this.val = val;
    }

    void print(){
        System.out.println(this.val);
        //System.out.println(N.MIN_VALUE); // --gives error because Interger class cannot be loaded in run time..
    }

    <T>void print(T val){
        System.out.println(val);
    }

    
    void printTypes(){
        System.out.println("Letter\tMeaning\n" + //
                        "T\tType\n" + //
                        "E\tElement\n" + //
                        "K\tKey\n" + //
                        "V\tValue\n" + //
                        "N\tNumber\n" + //
                        "N\tAny custom type");
    }

    public static void main(String[] args) {
        Class1<Integer> c = new Class1<Integer>(3);
        c.print();
        c.printTypes();
    }
}
