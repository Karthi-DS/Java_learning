import java.io.Console;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.ArrayList;

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
        return this.loginId;
    }

    public void updatePhoneNumber(String pn) {
        this.phoneNumber = pn;
    }

    public String toString() {
        return "User Details:\nName: " + this.name + "\nLoginId: " + this.loginId + "\nAadharId: " + this.aadharId
                + "\nPhone Number: " + this.phoneNumber;
    }
}

public class filePs2_1 {
    ObjectInputStream ois;
    ObjectOutputStream oos;
    FileInputStream fis;
    FileOutputStream fos;

    public filePs2_1() {
        init(false);
    }

    public void init(boolean forAppend) {
        try {
            fis = new FileInputStream("user.dat");
            ois = new ObjectInputStream(fis);
            if (forAppend) {
                fos = new FileOutputStream("user.dat", true);
            } else {
                fos = new FileOutputStream("user.dat");
            }
            oos = new ObjectOutputStream(fos);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void writeData(User[] arr, boolean isAppend) {
        init(isAppend);
        try {
            for (User u : arr) {
                if (u != null)
                    oos.writeObject(u);
            }
            System.out.println("Users Successfully written");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void readData() {
        try {
            init(true);
            User[] users = (User[]) ois.readObject();
            for (User u : users) {
                if (u != null)
                    System.out.println(u);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void searchAndUpdateById(String id, boolean isUpdate, String phoneNumber) {
        init(true);
        try {
            User[] users = (User[]) ois.readObject();
            boolean isFound = false;
            for (User u : users) {
                if (u.getLoginId().equals(id)) {
                    if (!isUpdate) {
                        System.out.println("Found User with Id: " + id);
                        System.out.println(u);
                        isFound = true;
                    } else {
                        u.updatePhoneNumber(phoneNumber);
                        System.out.println("Phone number updated...");
                    }
                }
            }

            if (!isFound)
                System.out.println("User not found...");

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void deleteUserById(String id) {
        try {
            User[] users = (User[]) ois.readObject();
            boolean isFound = false;

            for (int i = 0; i < users.length; i++) {
                if (users[i].getLoginId().equals(id)) {
                    isFound = true;
                    users[i] = null;
                }
            }

            if (!isFound) {
                System.out.println("User not found...");
                return;
            }
            writeData(users, false);
            System.out.println("User Deleted successfully...");

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void menu() {
        System.out.println(
                "\n1. Insert User\n2. Read All User\n3. Read Single User By Id\n4. Update Phone Number By Id\n5. Delete User By Id\nEnter the choice\n");
    }

    public static User promptUser() {
        System.out.println(
                "Enter the details of the user in the following order: LoginId, Name, Password, AadharId, PhoneNumber");
        Scanner sc = new Scanner(System.in);
        String LoginId = sc.nextLine();
        String name = sc.nextLine();
        String password = sc.nextLine();
        String aadharId = sc.nextLine();
        String phoneNumber = sc.nextLine();
        return new User(name, LoginId, password, aadharId, phoneNumber);
    }

    public static void main(String[] args) {
        filePs2_1 obj = new filePs2_1();
        Scanner sc = new Scanner(System.in);
        int ch;
        ArrayList<User> users = new ArrayList<>();

        boolean isContinue = true;
        while (isContinue) {
            menu();
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    User u = promptUser();
                    users.add(u);
                    obj.writeData((User[]) users.toArray(), true);
                    break;
                case 2:
                    obj.readData();
                    break;
                case 3:
                    System.out.println("Enter the login id of the user to be searched");
                    String id = sc.next();
                    obj.searchAndUpdateById(id, false, "");
                    break;
                case 4:
                    System.out.println("Enter the login id of the user to be updated");
                    String idToUpdate = sc.next();
                    System.out.println("Enter the new phone number");
                    String phoneNumber = sc.nextLine();
                    obj.searchAndUpdateById(idToUpdate, true, phoneNumber);
                    break;
                case 5:
                    System.out.println("Enter the login id of the user to be deleted");
                    String idToDelete = sc.next();
                    obj.deleteUserById(idToDelete);
                    break;
                default:
                    System.out.println("Invalid choice...");
                    break;
            }
        }
    }

}