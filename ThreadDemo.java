import java.io.*;
import java.util.Scanner;
public class ThreadDemo {
    // Task to read file
    static class FileTask implements Runnable {
        public void run() {
            try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
                String line;
                System.out.println("File thread: Reading file");
                while ((line = br.readLine()) != null) {
                    System.out.println("File: " + line);
                    Thread.sleep(500); // Slow down to see concurrency
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Task to read user input
    static class InputTask implements Runnable {
        public void run() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input thread: Enter your name:");
            String name = scanner.nextLine();
            System.out.println("Input: Hello, " + name + "!");
        }
    }

    public static void main(String[] args) {
        // Create sample file
        try (PrintWriter pw = new PrintWriter("data.txt")) {
            pw.println("Hello from file!");
            pw.println("This is line 2.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Start two threads: one for file, one for input
        Thread fileThread = new Thread(new FileTask());
        Thread inputThread = new Thread(new InputTask());

        fileThread.start();
        inputThread.start();

        // Wait for both to finish
        try {
            fileThread.join();
            inputThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Both tasks done!");
    }
}
