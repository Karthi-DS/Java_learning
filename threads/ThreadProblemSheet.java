import java.util.Random;

class NumberProcessor {
    int[] numbers;

    NumberProcessor(int size) {
        numbers = new int[size];
        Random rand = new Random();

        // Generate random numbers (-50 to 50)
        for (int i = 0; i < size; i++) {
            numbers[i] = rand.nextInt(101) - 50;
        }
    }

    void printNumbers() {
        System.out.print("Generated Numbers: ");
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}

// Thread to find negative numbers
class NegativeThread extends Thread {
    int[] numbers;

    NegativeThread(int[] numbers) {
        this.numbers = numbers;
    }

    public void run() {
        System.out.print("Negative Numbers: ");
        for (int n : numbers) {
            if (n < 0) {
                System.out.print(n + " ");
            }
        }
        System.out.println();
    }
}

// Thread to find positive even numbers
class PositiveEvenThread extends Thread {
    int[] numbers;

    PositiveEvenThread(int[] numbers) {
        this.numbers = numbers;
    }

    public void run() {
        System.out.print("Positive Even Numbers: ");
        for (int n : numbers) {
            if (n > 0 && n % 2 == 0) {
                System.out.print(n + " ");
            }
        }
        System.out.println();
    }
}

class PositiveOddThread extends Thread {
    int[] numbers;

    PositiveOddThread(int[] numbers) {
        this.numbers = numbers;
    }

    public void run() {
        System.out.print("Positive Odd Numbers: ");
        for (int n : numbers) {
            if (n > 0 && n % 2 != 0) {
                System.out.print(n + " ");
            }
        }
        System.out.println();
    }
}

class Prob5 {
    public static void main(String[] args) {
        NumberProcessor np = new NumberProcessor(20);

        np.printNumbers();

        // Create threads
        Thread t1 = new NegativeThread(np.numbers);
        Thread t2 = new PositiveEvenThread(np.numbers);
        Thread t3 = new PositiveOddThread(np.numbers);

        // Start threads (concurrent execution)
        t1.start();
        t2.start();
        t3.start();
    }
}


class Prob1{
    
    static class t1 extends Thread{
        public void run(){
            System.out.println("running t1");
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println("Error occured");
            }
        }
    }

    static class t2 implements Runnable{
        public void run(){
            System.out.println("running t2");
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println("Error occured");
            }
        }
    }

    public static void main(String[] args) {
        t1 Thread1 = new t1();
        t2 Thread2 = new t2();

        new Thread(Thread2).start();
        Thread1.start();
    }
}


class Prob2 extends Thread{
    public void run(){
        try {
            for(int i=0; i<5; i++){
                try {  
                    Thread.sleep(1000);
                    System.out.println("Good Morning");
                    Thread.sleep(2000);
                    System.out.println("Hello");
                    Thread.sleep(3000);
                    System.out.println("Welcome");
                } catch (Exception e) {
                    System.out.println("error occured");
                }
            }
        } catch (Exception e) {
            
        }
    }

    public static void main(String[] args) {
        Prob2 p = new Prob2();
        p.run();
    }
}


class Prob3 extends Thread{

    public Prob3() {
        super();
    }
    
    @Override
    public void run(){
        System.out.println("running");
    }

    public static void main(String[] args) {
        Prob3 p = new Prob3();
        p.run();
    }
}

class Prob4 {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();

        System.out.println("Thread Reference: " + t);
        System.out.println("Thread Name: " + t.getName());
        System.out.println("Thread Priority: " + t.getPriority());
    }
}

public class ThreadProblemSheet{
    public static void main(String[] args) {
        // Prob1.main(args);
        // Prob2.main(args);
        // Prob3.main(args);
        // Prob4.main(args);
        Prob5.main(args);
    }

}