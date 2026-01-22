package pk1;


import java.util.Scanner;


public class Getter{
    int arr[] = null;
    float arrf[] = null;
    int len;
    Scanner sc = new Scanner(System.in);
    public Getter(int[] arr){
        this.arr = arr;
        this.len = arr.length;
    }


    public Getter(float[] arrf){
        this.arrf = arrf;
        this.len = arrf.length;
    }


    public void get(){
        System.out.println("Enter the elements");
        if(this.arr!=null){
            for(int i=0; i<this.len; i++){
                this.arr[i] = sc.nextInt();
            }
        }
        if(this.arrf!=null){
           for(int i=0; i<this.len; i++){
                this.arrf[i] = sc.nextFloat();
            }
        }
    }
}

