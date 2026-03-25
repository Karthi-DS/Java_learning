import java.util.Arrays;

public class MergeSort {
    
    public void splitArr(int[] arr, int i, int j){
        if(i<j){
            int mid = (i+j)/2;
            splitArr(arr, i, mid);
            splitArr(arr, mid+1, j);
            merge(arr,i,mid,j);
        }
    }

    public void merge(int[] arr, int low, int mid, int high){
        int k = low, i = low, j= mid+1;
        int[] b = new int[arr.length];

        while(i<=mid && j<=high){
            if(arr[i]<=arr[j]){
                b[k] = arr[i];
                i++;
            }else{
                b[k] = arr[j];
                j++;
            }
            k++;
        }

        if(i>mid){
            while(j<=high){
                b[k] = arr[j];
                j++;
                k++;
            }
        }else{
            while(i<=mid){
                b[k] = arr[i];
                i++;
                k++;
            }
        }

        for(int l=low;l<=high;l++){
            arr[l] = b[l];
        }
    }

    public static void main(String[] args) {
        int arr[] = {2,1,10,7,6,5};
        MergeSort m = new MergeSort();
        m.splitArr(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
