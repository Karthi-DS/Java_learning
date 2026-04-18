import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

class InventoryManager<T> {
    LinkedList<T> ll;
    Scanner sc;

    InventoryManager() {
        ll = new LinkedList<>();
        sc = new Scanner(System.in);
    }


    void addEle(T ele) {
        ll.add(ele);
        System.out.println("product added");
    }

    void deleteEle(T ele) {
        if (ll.contains(ele))
            ll.remove(ele);
        else
            System.out.println("Product not found");
    }

    void deleteEle(int index) {
        if (index <= ll.size())
            ll.remove(index);
        else
            System.out.println( "Product not found");
    }

    void updateEle(int index, T ele) {
        ll.set(index, ele);
        System.out.println("Product updated");
    }

    void updateEle(int index) {
        if (index > ll.size()) {
            System.out.println("Index out of bounds");
            return;
        }

        T ele = ll.get(index);
        boolean isContinue = true;
        while (isContinue) {
            System.out.println("1. Update Name\n2. Update Quantity\n3. Update Price\n4. Exit\n");
            int c = sc.nextInt();
            switch (c) {
                case 1:
                    ((Product)ele).updateName();
                    break;
                case 2:
                    ((Product)ele).updateQuantity();
                    break;
                case 3:
                    ((Product)ele).updatePrice();
                    break;
                case 4:
                    isContinue = false;
                    break;
                default:
                    System.out.println("Enter valid choice");
            }
        }

        ll.set(index, ele);
        System.out.println("Product updated");
    }
}

class Product {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private Scanner sc;

    public int getId(){
        return this.id;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public Double getPrice(){
        return this.price;
    }
    public String getName(){
        return this.name;
    }

    Product(int i, String n, int q, double p) {
        this.id = i;
        this.name = n;
        this.quantity = q;
        this.price = p;
        sc = new Scanner(System.in);
    }

    public String toString() {
        return "Id: " + this.id + "\nName: " + this.name + "\nQuantity: " + this.quantity + "\nPrice: " + this.price
                + "\n";
    }

    void updateName() {
        this.name = sc.nextLine();
        System.out.println("Product name updated");
    }

    void updateQuantity() {
        this.quantity = sc.nextInt();
        sc.nextLine();
        System.out.println("Product Quantity updated");
    }

    void updatePrice() {
        this.price = sc.nextDouble();
        sc.nextLine();
        System.out.println("Product Price updated");
    }
}

public class Main {
    DataInputStream dis;
    DataOutputStream dos;
    InventoryManager<Product> im;
    Scanner sc;
    Stack<String> opr;
    Stack<Product> items;
    int lastUpdatedIndex;

    Main() {
        Init();
        InitLL();
        sc = new Scanner(System.in);
        opr = new Stack<>();
        items = new Stack<>();
    }

    private void Init() {
        try {
            dis = new DataInputStream(new FileInputStream("files/students.dat"));
            dos = new DataOutputStream(new FileOutputStream("files/students.dat",true));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void saveIntoFile(){
        Init();
        try {
            for (Product p : im.ll) {
                dos.writeInt(p.getId());
                dos.writeUTF(p.getName());
                dos.writeInt(p.getQuantity());
                dos.writeDouble(p.getPrice());
            }
            System.out.println("Successfully written into file");
        } catch (Exception e) {
             System.out.println("Error: "+e.getMessage());
        }
    }

    private void InitLL() {
        Init();
        im = new InventoryManager<>();
        try {
            while (true) {
                int id = dis.readInt();
                String name = dis.readUTF();
                int quantity = dis.readInt();
                double price = dis.readDouble();

                Product p = new Product(id, name, quantity, price);
                im.ll.add(p);
            }
        } catch (EOFException e) {

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void menu() {
        System.out.println("1. Display All Product\n2. Add Product\n3. Delete Product\n4. Update Product\n5. Undo Last Operation\n6. Save into file\n");
    }

    public void undo(){
        String op = opr.pop();


        switch (op) {
            case "add":
                im.deleteEle(items.pop());
                System.out.println("Undone: Add Operation");
                break;
            case "delete":
                im.addEle(items.pop());
                System.out.println("Undone: Delete Operation");
                break;
            case "update":
                im.updateEle(lastUpdatedIndex,items.pop());
                System.out.println("Undone: update Operation");
                break;
            case "savev":
                items.pop();
                try {
                    
                new FileOutputStream("files/students.dat").close();
                } catch (Exception e) {
                    // TODO: handle exception
                }
                break;
            default:
                break;
        }
    }

    public void MenuHelper() {
        boolean isContinue = true;
        int c;
        while (isContinue) {
            menu();
            c = sc.nextInt();
            switch (c) {
                case 1:
                    display();
                    break;
                case 2:
                    System.out.println("Enter Id");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter name");
                    String name = sc.nextLine();
                    System.out.println("Enter quantity");
                    int quantity = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter price");
                    double price = sc.nextDouble();
                    Product ele = new Product(id, name, quantity, price);
                    im.addEle(ele);

                    opr.push("add");
                    items.push(ele);
                    break;
                case 3:
                    System.out.println("Enter index");
                    int i = sc.nextInt();
                    i-=1;

                    opr.push("delete");
                    items.add(im.ll.get(i));

                    im.deleteEle(i);
                    break;
                case 4:
                    System.out.println("Enter index");
                    int ind = sc.nextInt();
                    ind-=1;

                    opr.push("update");
                    lastUpdatedIndex = ind;
                    items.push(im.ll.get(ind));

                    im.updateEle(ind);
                    break;
                case 5:
                    undo();
                    break;
                case 6:

                    opr.push("save");
                    items.push(null);

                    saveIntoFile();
                    break;
                default:
                    break;
            }
        }
    }

    public void display() {
        byte[] arr = new byte[100];
        int ch;
        if(im.ll.isEmpty()){
            System.out.println("no product found...");
            return;
        }
        try {
            System.out.println("Product Displaying...");
            for (Product p : im.ll) {
                System.out.println(p);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.MenuHelper();
    }
}