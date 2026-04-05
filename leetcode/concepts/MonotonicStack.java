import java.util.Arrays;
import java.util.Stack;

public class MonotonicStack {
    int[] arr = {1,3,1,3,1};
    int[] nextInc = new int[arr.length];
    int[] nextDec = new int[arr.length];
    Stack<Integer> s = new Stack<>();

    public void findIncreasing(){
        Arrays.fill(nextInc,-1);
        int n = arr.length;
        for(int i=0; i<n; i++){
            while(!s.empty() && arr[i]>arr[s.peek()]){
                nextInc[s.peek()] = i;
                s.pop();
            }
            s.push(i);
        }
        s.clear();
    }

    public void findDecreasing(){
        Arrays.fill(nextDec,-1);
        int n = arr.length;
        for(int i=0; i<n; i++){
            while(!s.empty() && arr[i]<arr[s.peek()]){
                nextDec[s.peek()] = i;
                s.pop();
            }
            s.push(i);
        }
        s.clear();
    }

    public static void main(String[] args) {
        MonotonicStack ms = new MonotonicStack();
        ms.findDecreasing();
        ms.findIncreasing();

        System.out.println("nextInc: "+Arrays.toString(ms.nextInc));
        System.out.println("nextDec: "+Arrays.toString(ms.nextDec));
    }
}
