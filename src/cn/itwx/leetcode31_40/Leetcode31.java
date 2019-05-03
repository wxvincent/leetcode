package cn.itwx.leetcode31_40;

import java.util.Arrays;

public class Leetcode31 {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int i = nums.length - 1;
        while (nums[i] <= nums[i - 1]) {
            i--;
            if (i == 0) {
                int left = 0, right = nums.length - 1;
                while (left < right) {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                    left++;
                    right--;
                }
                return;
            }
        }

        int j = nums.length - 1;
        while (nums[j] <= nums[i - 1]) {
            j--;
        }
        int temp = nums[i - 1];
        nums[i - 1] = nums[j];
        nums[j] = temp;

        Arrays.sort(nums, i, nums.length);

    }
}
