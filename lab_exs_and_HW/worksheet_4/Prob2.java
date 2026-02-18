package lab_exs_and_HW.worksheet_4;


import java.util.Scanner;
import java.util.Arrays;

public class Prob2
{
    String mname,cname;
    StringBuilder seat = new StringBuilder();
    static String seatings[] = new String[100];
    static int count;
    Scanner sc = new Scanner(System.in);
    
    Prob2(String mname, String cname,String seat){
        this.mname = mname;
        this.cname = cname;
        this.seat.append(seat);
        seatings[count] = this.seat.toString();
    }
    
    public void summary(){
        System.out.println("------Details-------");
        System.out.println("Customer name: "+cname);
        System.out.println("Movie name: "+mname);
        System.out.println("your seat: "+this.seat.toString());
        
    }
    
    public void display(){
        System.out.println("Seatings: "+Arrays.toString(seatings));
    }
    
	public static void main(String[] args) {
	    Main m = new Main("Kandhan Karunai","Karthi","A1");
	    m.summary();
	    m.display();
	}
}

