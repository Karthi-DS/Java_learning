// package collections;

import java.util.ArrayList;

public class ArrayListC<T extends Number> {
    ArrayList<T> arr = new ArrayList<>();
    ArrayListC(T val1, T val2){
        arr.add(val1);
        arr.add(val2);
    }

    void print(){
        System.out.println(arr);
    }

    public static void main(String[] args) {
        ArrayListC<Integer> c = new ArrayListC<>(3,5);
        c.print();
    }
}
