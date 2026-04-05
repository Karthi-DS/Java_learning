
import java.util.Arrays;


public class StreamBasics {

    int[] arr;

    void print(Object x){
        System.out.println(x);
    }

    void initArray(){
        arr = new int[]{2,3,4,5};

        Arrays.stream(arr).filter(x->x>2).map(x->x*2).forEach(this::print);
    }

    void objMethodStream(){
        String s[] = {"karthi","kavin","shairaaj"};

        Arrays.stream(s).map(String::toUpperCase).forEach(System.out::println);
    }

    public static void main(String[] args) {
        StreamBasics c = new StreamBasics();
        c.initArray();
        c.objMethodStream();
    }
}
