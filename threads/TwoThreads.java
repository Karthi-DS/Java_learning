class Thread1 implements Runnable {
    
    public void run(){
        for(int i=0; i<10; i++){
            System.out.println("t1: "+i);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}

class Thread2 extends Thread{

    public void run(){
        for(int i=0; i<5; i++){
            System.out.println("t2: "+i);
        }
        try {
                Thread.sleep(300);
            } catch (Exception e) {
                // TODO: handle exception
            }
    }
}
 
public class TwoThreads{
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();

        // starting both threads...
        new Thread(t1).start();
        t2.start();
    }
}