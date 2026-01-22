import java.util.Arrays;
import java.util.Scanner;
import pk1.Getter;


public class Array{


    public static void main(String[] args){
       
        int num[];
        num = new int[5];
        //int num[] = new int[5];
        //Arrays.fill(num,-1); //-- to create your own default value
        System.out.println("default value: "+ num[0] );


        char word[]= new char[10];
        System.out.println("default value: "+ (int)word[0]); // '\u0000'


        double numd[] = {0.2d,0.5d};
        System.out.println("default value: "+ numd[0]);


        float numf[] = {0.0f,1.2f,1.3f};
        System.out.println("first value: "+ numf[0]);


        //integer array size defined by user


        int userInteger[];
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size for an array: ");
        n = scanner.nextInt();
        userInteger = new int[n];
        System.out.println("Default values of your array: "+ Arrays.toString(userInteger));
       
        System.out.println("------------ float array ------------");
        float userFloat[] = new float[5];
        Getter arrHelper = new Getter(userFloat);
        arrHelper.get();


        System.out.println("Entered values of your array: "+ Arrays.toString(userFloat));
    }
}
