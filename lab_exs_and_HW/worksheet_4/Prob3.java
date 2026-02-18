package lab_exs_and_HW.worksheet_4;

import java.util.Arrays;
import java.util.Scanner;

import lab_exs_and_HW.array_exs1.Prob4;

public class Prob3 {
    String sname, cname;
    StringBuilder goal = new StringBuilder();
    String modules[] = new String[100];
    Scanner sc = new Scanner(System.in);

    Prob3(String sname, String cname){
        this.sname = sname;
        this.cname = cname;
    }

    void resetGoals(String goal){
        this.goal.append(goal);
    }

    void addModules(){
       
        System.out.println("Enter no of modules: ");
        int n = sc.nextInt();
        sc.nextLine(); 
        for(int i=0; i<n; i++){
            modules[i] = sc.nextLine();
        }
    }

    void display(){
        System.out.println(this.goal);
        System.out.println("modules: "+Arrays.toString(modules));
    }

    public static void main(String[] args) {
        Prob3 p = new Prob3("karthi","java");
        p.resetGoals("to get placed in maang");
        p.addModules();
        p.display();
    }
}
