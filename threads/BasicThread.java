public class BasicThread {
    public static void main(String[] args) {
        // Get the current thread
        Thread t = Thread.currentThread();
        System.out.println("Current Thread: " + t);

        // Change the name of the current thread
        t.setName("My main");
        System.out.println("After Name Change: " + t);

        try {
            for (int n = 5; n > 0; n--) {
                Thread.sleep(1000); // pause for 1 second
                System.out.println(n);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }
    }
}