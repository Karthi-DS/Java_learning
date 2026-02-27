// package Generic_class;

import java.util.HashMap;

public class Class2<K,V> {

    public HashMap<K,V> map = new HashMap<>();
    

    public void print(){
        System.out.println(map);
    }

    public static void main(String[] args) {
        Class2<Integer,String> c = new Class2<>();
        c.map.put(1, "hello");
        c.map.put(2, "hi");
        c.print();
    }
}
