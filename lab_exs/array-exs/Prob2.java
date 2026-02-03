class Prob2{
    static void printArr(int[] arr){
       for(int i=0; i<arr.length; i++){
        System.out.println(arr[i]);
       } 
    }

    static void sumUp(int[] arr1,int[] arr2,int[] target){
        for(int i=0;i<arr1.length;i++){
            target[i] = arr1[i] + arr2[i];
        }
    }
    public static void main(String args[]){
        int arr[] = {1,2,3,4,5};
        int arr2[]  = {3,10,23,25,34};
        int arr3[] = new int[arr.length];
        
        System.out.println("Array 1: ");
        printArr(arr);
        System.out.println("Array 2: ");
        printArr(arr2);
        System.out.println("Resultant arrray: ");
        sumUp(arr, arr2, arr3);
        printArr(arr3);
    }
}