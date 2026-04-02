public class Leetcode560 {
    class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        // if (Arrays.stream(nums).sum() == k)
        //     count++;

            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = i; j >= 0; j--) {
                    sum += nums[j];
                    if (sum == k) {
                        count++;
                    }
                }
            }
        return count;
    }
}
}
