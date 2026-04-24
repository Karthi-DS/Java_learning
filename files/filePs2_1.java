import java.io.*;
import java.util.*;

// ---------------- USER CLASS ----------------
class User implements Serializable {
    private String name;
    private String loginId;
    private String password;
    private String aadharId;
    private String phoneNumber;

    public User(String name, String loginId, String password, String aadharId, String phoneNumber) {
        this.name = name;
        this.loginId = loginId;
        this.password = password;
        this.aadharId = aadharId;
        this.phoneNumber = phoneNumber;
    }

    public String getLoginId() {
        return loginId;
    }

    public void updatePhoneNumber(String pn) {
        this.phoneNumber = pn;
    }

    public String toString() {
        return "User Details:\nName: " + name +
                "\nLoginId: " + loginId +
                "\nAadharId: " + aadharId +
                "\nPhone Number: " + phoneNumber + "\n";
    }
}

public class filePs2_1 {

    public ArrayList<User> readData() {
        ArrayList<User> list = new ArrayList<>();

        try {
            File file = new File("user.dat");

            if (!file.exists() || file.length() == 0) {
                return list; // empty list
            }

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            list = (ArrayList<User>) ois.readObject();
            ois.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void writeData(ArrayList<User> list) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.dat"));
            oos.writeObject(list);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertUser(User u) {
        ArrayList<User> users = readData();
        users.add(u);
        writeData(users);
        System.out.println("User added successfully!");
    }

    public void displayAll() {
        ArrayList<User> users = readData();

        if (users.isEmpty()) {
            System.out.println("No users found.");
            return;
        }

        for (User u : users) {
            System.out.println(u);
        }
    }

    public void searchById(String id) {
        ArrayList<User> users = readData();
        boolean found = false;

        for (User u : users) {
            if (u.getLoginId().equals(id)) {
                System.out.println("User Found:\n" + u);
                found = true;
            }
        }

        if (!found) {
            System.out.println("User not found.");
        }
    }

    public void updatePhone(String id, String phone) {
        ArrayList<User> users = readData();
        boolean found = false;

        for (User u : users) {
            if (u.getLoginId().equals(id)) {
                u.updatePhoneNumber(phone);
                found = true;
            }
        }

        if (found) {
            writeData(users);
            System.out.println("Phone number updated successfully!");
        } else {
            System.out.println("User not found.");
        }
    }

    public void deleteUser(String id) {
        ArrayList<User> users = readData();

        boolean removed = users.removeIf(u -> u.getLoginId().equals(id));

        if (removed) {
            writeData(users);
            System.out.println("User deleted successfully!");
        } else {
            System.out.println("User not found.");
        }
    }

    public static void menu() {
        System.out.println("\n1. Insert User");
        System.out.println("2. Read All Users");
        System.out.println("3. Search User By Id");
        System.out.println("4. Update Phone Number");
        System.out.println("5. Delete User");
        System.out.println("6. Exit");
        System.out.print("Enter choice: ");
    }

    public static User promptUser(Scanner sc) {
        sc.nextLine(); // clear buffer

        System.out.println("Enter LoginId:");
        String loginId = sc.nextLine();

        System.out.println("Enter Name:");
        String name = sc.nextLine();

        System.out.println("Enter Password:");
        String password = sc.nextLine();

        System.out.println("Enter AadharId:");
        String aadharId = sc.nextLine();

        System.out.println("Enter Phone Number:");
        String phoneNumber = sc.nextLine();

        return new User(name, loginId, password, aadharId, phoneNumber);
    }

    public static void main(String[] args) {
        filePs2_1 obj = new filePs2_1();
        Scanner sc = new Scanner(System.in);

        int ch;

        while (true) {
            menu();
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    User u = promptUser(sc);
                    obj.insertUser(u);
                    break;

                case 2:
                    obj.displayAll();
                    break;

                case 3:
                    System.out.print("Enter LoginId: ");
                    String id = sc.next();
                    obj.searchById(id);
                    break;

                case 4:
                    System.out.print("Enter LoginId: ");
                    String idUpdate = sc.next();
                    sc.nextLine(); // fix buffer
                    System.out.print("Enter new phone number: ");
                    String phone = sc.nextLine();
                    obj.updatePhone(idUpdate, phone);
                    break;

                case 5:
                    System.out.print("Enter LoginId: ");
                    String idDelete = sc.next();
                    obj.deleteUser(idDelete);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}