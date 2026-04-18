
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class filePs {

    FileReader fr;
    File file;
    Scanner sc;

    public filePs() {
        try {
            file = new File("Test.java");
            fr = new FileReader(file);
            sc = new Scanner(System.in);
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
    }

    public void getLength() {
        System.out.println("Byte Length: " + file.length());
    }

    public void countVowels() {
        int ch;
        int vowel = 0;
        try {
            fr = new FileReader(file);

            while ((ch = fr.read()) != -1) {
                char c = Character.toLowerCase((char) ch);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowel++;
                }
            }
            System.out.println("Vowel count: " + vowel);
        } catch (Exception e) {
            System.err.println("Exception found...");
        }
    }

    public void convertUpperCase() {
        char[] arr = new char[100];
        try {
            fr = new FileReader(file);

            int i;
            while ((i = fr.read(arr)) != -1) {
                System.out.println(new String(arr, 0, i).toUpperCase());
            }
        } catch (Exception e) {
            System.err.println("Error Occurred");
        }
    }

    public void readFirstNBytes() {
        System.out.println("How many byte you want to read");
        int n = sc.nextInt();
        char[] arr = new char[n];
        sc.nextLine();
        int i;
        try {
            fr = new FileReader(file);

            if ((i = fr.read(arr)) != -1) {
                System.out.println(new String(arr, 0, i));
            }

        } catch (Exception e) {
            System.out.println("Exception found: "+e.getMessage());
        }
    }

    public void reverse() {
        char[] arr = new char[100];
        StringBuilder s = new StringBuilder();
        try {
            fr = new FileReader(file);

            int i;
            while ((i = fr.read(arr)) != -1) {
                s.append(new String(arr, 0, i));
            }
            System.out.println(s.reverse());
        } catch (Exception e) {
            System.err.println("Error Occurred");
        }
    }

    public void compareTwoFiles() {
        try {
            fr = new FileReader("Test.java");
            FileReader fr1 = new FileReader("Test2.java");
            int f1i = 0, f2i = 0;
            boolean isEqual = true;
            while (true) {
                f1i = fr.read();
                f2i = fr1.read();
                if (f1i != f2i) {
                    isEqual = false;
                    break;
                }
                if(f1i==-1 && f2i==-1){
                    break;
                }
            }


            if (isEqual) {
                System.out.println("File Contents are same");
            } else {
                System.out.println("File Contents are not same");
            }
        } catch (Exception e) {
            System.out.println("Exception found");
        }
    }

    public void countLines() {
        try {
            int i, lineCount = 0;
            fr = new FileReader(file);

            while ((i = fr.read()) != -1) {
                if ((char) i == '\n') {
                    lineCount++;
                }
            }

            System.out.println("Total Line count: " + lineCount);
        } catch (Exception e) {
            System.err.println("Error Occurred");
        }
    }

    public static void main(String[] args) {
        filePs obj = new filePs();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== FILE OPERATIONS MENU =====");
            System.out.println("1. Get File Byte Length");
            System.out.println("2. Count Vowels");
            System.out.println("3. Convert to Uppercase");
            System.out.println("4. Read First N Characters");
            System.out.println("5. Reverse File Content");
            System.out.println("6. Compare Two Files");
            System.out.println("7. Count Lines");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    obj.getLength();
                    break;
                case 2:
                    obj.countVowels();
                    break;
                case 3:
                    obj.convertUpperCase();
                    break;
                case 4:
                    obj.readFirstNBytes();
                    break;
                case 5:
                    obj.reverse();
                    break;
                case 6:
                    obj.compareTwoFiles();
                    break;
                case 7:
                    obj.countLines();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        sc.close();

    }
}
