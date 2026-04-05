public class Leetcode303 {
    class NumArray {
    int[] sumNum;
    public NumArray(int[] nums) {
        sumNum = new int[nums.length];
        sumNum[0] = nums[0];

        for(int i=1; i<nums.length; i++){
            sumNum[i] = sumNum[i-1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left==0) return sumNum[right];
        else return sumNum[right] - sumNum[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
}   
