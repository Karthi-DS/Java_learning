import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class filePs2 {
    BufferedReader br;
    InputStreamReader isr;
    StringBuilder sb;

    public filePs2() {
        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);
        sb = new StringBuilder();
    }

    public void readInput() {
        System.out.println("Enter text (type STOP to end):");

        try {
            String line;
            while (true) {
                line = br.readLine();
                line += "\n";
                if (line.toLowerCase().contains("stop")) {
                    break;
                }
                sb.append(line);
            }
            writeIntoFile();
            analyzeFile();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void writeIntoFile() {
        try (FileWriter fw = new FileWriter("input.txt");) {
            fw.write(sb.toString().toCharArray());
            System.out.println("File written successfully...");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void analyzeFile() {
        int noc = 0, nov = 0, now = 0, nol = 0, nou = 0, nod = 0;
        try (FileReader fr = new FileReader("input.txt"); FileWriter fw = new FileWriter("summary.txt")) {
            int ch;
            while ((ch = fr.read()) != -1) {
                char c = (char) ch;
                if (Character.isAlphabetic(ch)) {
                    if (Character.isUpperCase(c))
                        nou++;
                    else
                        nol++;
                    c = Character.toLowerCase(c);
                    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                        nov++;
                    noc++;
                }
                if (Character.isWhitespace(c))
                    now++;
                if (Character.isDigit(c))
                    nod++;
            }

            String summary = "No of characters: " + noc + "\nNo of vowels: " + nov + "\nNo of words: " + now
                    + "\nNo of Digits: " + nod + "\nNo of Uppercase Letters: " + nou + "\nNo of Lowercase Letters: "
                    + nol;
            fw.write(summary);
            System.out.println("File written successfully...");
        } catch (Exception e) {

        }
    }

    public void writeEmployee() {
        try (RandomAccessFile raf = new RandomAccessFile("employee.txt", "rw");) {
            Scanner sc = new Scanner(System.in);

            int id = 1;
            System.out.println("Enter the name: ");
            String name = sc.nextLine();
            System.out.println("Enter the Department: ");
            String dept = sc.nextLine();
            System.out.println("Enter the salary: ");
            Double salary = sc.nextDouble();
            boolean isActive = false;

            raf.writeInt(id);
            raf.writeUTF(name);
            raf.writeUTF(dept);
            raf.writeDouble(salary);
            raf.writeBoolean(isActive);

            System.out.println("Employee Written into file...");
            searchById(id);
            updateById(id);
            System.out.println("Search by id: " + id);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void searchById(int id) {
        try (RandomAccessFile raf = new RandomAccessFile("employee.txt", "r");) {
            while (true) {
                int eid = raf.readInt();
                String name = raf.readUTF();
                String dept = raf.readUTF();
                double salary = raf.readDouble();
                boolean status = raf.readBoolean();
                System.out.println("Id: " + eid);
                if (eid == id) {
                    String s = status ? "Active" : "Not Active";

                    System.out.println("Employee Id: " + eid);
                    System.out.println("Employee Name: " + name);
                    System.out.println("Employee Dept: " + dept);
                    System.out.println("Employee Salary: " + salary);
                    System.out.println("Employee Status: " + s);
                    return;
                }
            }
        } catch (EOFException e) {

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void updateById(int id) {
        Scanner sc = new Scanner(System.in);
        try (RandomAccessFile raf = new RandomAccessFile("employee.txt", "rw");) {
            while (true) {
                int eid = raf.readInt();
                if (eid == id) {
                    System.out.println("Update employee Status:\n Active for y and In Active for n\n");
                    raf.readUTF();
                    raf.readUTF();
                    raf.readDouble();
                    long fp = raf.getFilePointer();
                    raf.readBoolean();
                    raf.seek(fp);
                    String c = sc.nextLine();

                    if (c.equals("y"))
                        raf.writeBoolean(true);
                    else
                        raf.writeBoolean(false);
                }
            }
        } catch (EOFException e) {

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        filePs2 fPs2 = new filePs2();
        // fPs2.readInput();
        fPs2.writeEmployee();
    }

}