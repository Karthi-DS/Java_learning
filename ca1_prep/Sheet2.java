
import java.util.ArrayList;

public class Sheet2 {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();

        a.add(0,23);
        a.remove(0);
        a.add(100);
        a.remove(Integer.valueOf(100));
        a.add(200);
        a.set(0,300);
        a.get(0);
        System.out.println(a);
        System.out.println(a.size());
    }
}
