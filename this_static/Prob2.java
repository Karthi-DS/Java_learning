
 class Solution{
    int instanceVal = 10;
    static int staticVal = 1;
}

public class Prob2 {
    public static void main(String[] args) {
        Solution sol1 = new Solution();
        sol1.instanceVal = 20;
        Solution sol2 = new Solution();
        // sol2.instanceVal = 30;

        System.out.println("Changing: "+sol1.instanceVal+" "+sol2.instanceVal);
        System.out.println("Before \n"+Solution.staticVal);
        Solution.staticVal = 10;
        System.out.println("After \n"+Solution.staticVal);
    }
}
