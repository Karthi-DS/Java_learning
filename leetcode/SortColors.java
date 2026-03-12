package leetcode;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = { 1, 0 };
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}

class Solution {

    void swap(int[] nums, int i, int j) {
        int v = nums[i];
        nums[i] = nums[j];
        nums[j] = v;
    }

    public void sortColors(int[] nums) {

    int red = 0, white = 0;

    for (int x : nums) {
        if (x == 0) red++;
        else if (x == 1) white++;
    }

    int redP = 0;
    int whiteP = red;

    int i = 0;

    while (i < nums.length) {

        if (nums[i] == 0 && i >= redP) {
            swap(nums, i, redP);
            redP++;
        }
        else if (nums[i] == 1 && i >= whiteP) {
            swap(nums, i, whiteP);
            whiteP++;
        }
        else {
            i++;  
        }
    }
}
}