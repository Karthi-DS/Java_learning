package lab_exs_and_HW.array_exs1;

import pk.Array;

public class Prob2 {
    public static void main(String[] args) {
        int oddCount=0, evenCount=0;
        int arr[][] = Array.get2DArray(true);

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]%2==0){
                    evenCount++;
                }else{
                    oddCount++;
                }
            }
        }

        System.out.println("Even No: "+evenCount+" Odd Count: "+oddCount);

    }
}
