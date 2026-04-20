import java.io.Console;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


class User implements Serializable{
    private String name;
    private String loginId;
    private String password;
    private String aadharId;
    private String phoneNumber;

    public User(String name, String loginId, String password, String aadharId, String phoneNumber){
        this.name = name;
        this.loginId = loginId;
        this.password = password;
        this.aadharId = aadharId;
        this.phoneNumber = phoneNumber;
    }

    public String toString(){
        return "User Details:\nName: "+this.name+"\nLoginId: "+this.loginId+"\nAadharId: "+this.aadharId+"\nPhone Number: "+this.phoneNumber;
    }
}

public class filePs2_1 {
    Console cn;
    ObjectInputStream ois;
    ObjectOutputStream oos;
    FileInputStream fis;
    FileOutputStream fos;

    public filePs2_1() {
        cn = System.Console();
        init();
    }

    public void init() {
        fis = new FileInputStream("user.dat");
        ois = new ObjectInputStream(fis);
        fos = new FileOutputStream("user.dat", true);
        oos = new ObjectOutputStream(fos);
    }

    public void writeData(Users[] arr){
        try {
            for(User u: arr){
                oos.writeObject(u);
            }
            System.out.println("Users Successfully written");
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void readData(){

    }
}