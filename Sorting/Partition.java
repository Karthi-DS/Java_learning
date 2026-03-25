
import java.util.Arrays;

class Partition {
    public int getPartition(int arr[],int i, int j){
        
        int m = i;

        do {
            do {
                i++;
            } while (i<arr.length && arr[i]<arr[m] );
            do{
                j--;
            }while(j>0 && arr[j]>arr[m]);

            if(i<j){
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        } while (i<=j);

        int tmp = arr[m];
        arr[m] = arr[j];
        arr[j] = tmp;
        return j;
    }

    public void splitArr(int[] arr, int low, int high){
        if(low<high){
        int partition = getPartition(arr, low, high+1);
        System.out.println("partition: "+partition);
        splitArr(arr, low, partition-1);
        splitArr(arr, partition+1, high);
        }
    }

     public static void main(String[] args) {
        int arr[] = {2,1,10,7,6,0};
        Partition m = new Partition();
        m.splitArr(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
