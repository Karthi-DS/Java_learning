class Solution {
    public int maxSubArray(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }

        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        int minPrefix = nums[0];
        int sum = prefix[0];
        for(int i=1; i<nums.length; i++){
            prefix[i] = prefix[i-1] + nums[i];

            if(sum< prefix[i]-minPrefix) sum = prefix[i] - minPrefix;
            if(sum< prefix[i]) sum = prefix[i];

            if(minPrefix>prefix[i]) minPrefix = prefix[i];
        }


        return sum;
    }
}