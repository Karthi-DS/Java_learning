import java.util.ArrayList;

class Shared {
    ArrayList<String> arr = new ArrayList<>();
    int turn = 1; 
}

class MyThread extends Thread {
    Shared s;
    int id;

    MyThread(Shared s, int id) {
        this.s = s;
        this.id = id;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            synchronized (s) {
                try {
                    while (s.turn != id) {
                        s.wait(); 
                    }

                    s.arr.add("T" + id + "-" + i);
                    System.out.println("Thread " + id + " added value");

                    s.turn = (s.turn % 3) + 1;
                    s.notifyAll(); 

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Shared s = new Shared();

        MyThread t1 = new MyThread(s, 1);
        MyThread t2 = new MyThread(s, 2);
        MyThread t3 = new MyThread(s, 3);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("\nFinal ArrayList:");
        System.out.println(s.arr);
    }
}