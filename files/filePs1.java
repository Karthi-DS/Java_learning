import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class filePs1 {
    Scanner sc;
    File fi;

    public filePs1(String name) {
        sc = new Scanner(System.in);
    }

    boolean createFile(String name) {
        try {
            fi = new File(name);
            return fi.createNewFile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    class Prob1 {
        FileOutputStream fos;
        DataOutputStream dos;
        FileInputStream fis;
        DataInputStream dis;

        void init(boolean b) {
            try {

                fis = new FileInputStream("students.dat");
                dis = new DataInputStream(fis);
                if (b) {
                    fos = new FileOutputStream("students.dat");
                    dos = new DataOutputStream(fos);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        void write() {

            File file = new File("students.dat");
            if (!file.exists()) {
                createFile("students.dat");
            }
            init(true);
            System.out.println("How many students you want to write");
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                try {
                    dos.writeInt(i + 1);
                    sc.nextLine();
                    System.out.println("Enter name");
                    String name = sc.nextLine();
                    dos.writeUTF(name);
                    System.out.println("Enter marks");
                    double mark = sc.nextDouble();
                    dos.writeDouble(mark);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        void display() {
            try {
                init(false);
                while (true) {
                    int id = dis.readInt();
                    String name = dis.readUTF();
                    Double mark = dis.readDouble();

                    System.out.printf("Id: %d name: %s mark %.2f%n", id, name, mark);
                }
            } catch (EOFException e) {

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        void searchById(int sid) {
            boolean found = false;
            try {
                init(false);
                while (true) {
                    int id = dis.readInt();
                    String name = dis.readUTF();
                    Double mark = dis.readDouble();

                    if (id == sid) {
                        found = true;
                        System.out.printf("Search Found - Id: %d name: %s mark %.2f%n", id, name, mark);
                    }
                }
            } catch (EOFException e) {
                if (!found) {
                    System.out.println("search not found...");
                }
            } catch (Exception e) {

            }
        }

        void updateMark(int searchId, double newMark) {
            try {
                RandomAccessFile raf = new RandomAccessFile("students.dat", "rw");

                while (raf.getFilePointer() < raf.length()) {

                    int id = raf.readInt();

                    raf.readUTF();
                    long pos = raf.getFilePointer();
                    raf.readDouble();
                    if (id == searchId) {
                        raf.seek(pos);
                        raf.writeDouble(newMark);
                        System.out.println("Record Updated!");
                        return;
                    }

                }

                System.out.println("Record not found!");

            } catch (Exception e) {

            }
        }
    }

    public static void Prob1Menu() {
        filePs1 fs1 = new filePs1("students.dat");
        Prob1 ps1 = fs1.new Prob1();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Write");
            System.out.println("2. Display");
            System.out.println("3. Search by ID");
            System.out.println("4. Update Mark");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    ps1.write();
                    break;

                case 2:
                    ps1.display();
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    int sid = sc.nextInt();
                    ps1.searchById(sid);
                    break;

                case 4:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();
                    System.out.print("Enter new mark: ");
                    double newMark = sc.nextDouble();
                    ps1.updateMark(uid, newMark);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    class Prob2 {
        FileInputStream fis;
        FileOutputStream fos;

        void init() {
            try {
                fis = new FileInputStream("test.txt");
                fos = new FileOutputStream("encryptedFile.txt", true);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        void writeEncryptedData() {
            byte[] arr = new byte[100];
            init();
            try {
                int pos;
                while ((pos = fis.read(arr)) != -1) {
                    for (int i = 0; i < pos; i++) {
                        arr[i] ^= 5;
                    }
                    fos.write(arr, 0, pos);
                }
                System.out.println("Data successfully encrypted");
            } catch (Exception e) {

            }
        }

        void readEncryptedData() {
            byte[] arr = new byte[100];
            try {
                FileInputStream fis1 = new FileInputStream("encryptedFile.txt");
                int pos;
                while ((pos = fis1.read(arr)) != -1) {
                    for (int i = 0; i < pos; i++) {
                        arr[i] ^= 5;
                    }
                    System.out.println(new String(arr, 0, pos));
                }
            } catch (Exception e) {

            }
        }
    }

    public static void Prob2Menu() {
        filePs1 fs1 = new filePs1("students.dat");
        Prob2 ps2 = fs1.new Prob2();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Encrypt");
            System.out.println("2. Decrypt");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    ps2.writeEncryptedData();
                    break;

                case 2:
                    ps2.readEncryptedData();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    class Prob3 {
        FileInputStream fis1;
        FileInputStream fis2;

        void init() {
            try {
                fis1 = new FileInputStream("identical1.txt");
                fis2 = new FileInputStream("identical2.txt");
            } catch (Exception e) {
                System.err.println("error occured");
            }
        }

        void checkIdenticals() {
            init();
            int firstMismatch = -1;
            try {
                int ch1, ch2,pos = 0, totatMismatch=0;
                while ((ch1=fis1.read()) != -1 && (ch2=fis2.read()) != -1) {

                    if(ch1!=ch2){
                        if(firstMismatch==-1) firstMismatch = pos;

                        totatMismatch++;
                    }
                    pos++;
                }

                if(firstMismatch==-1){
                    System.out.println("Files are identical");
                }else{
                    System.out.printf("\nFirst Mismatch Position: %d\nTotal Mismatches: %d\n",firstMismatch,totatMismatch);
                }
            } catch (Exception e) {
                System.out.println("Error occured");
            }
        }
    }

    public static void Prob3Menu() {
        filePs1 fs1 = new filePs1("students.dat");
        Prob3 ps3 = fs1.new Prob3();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. check is Identical");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    ps3.checkIdenticals();
                    break;

                case 2:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void main(String[] args) {
        Prob3Menu();
    }
}
