package cn.itwx.leetcode11_20;

import java.util.Arrays;

public class Leetcode16 {

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;

        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int temp = nums[i] + nums[left] + nums[right];
                if (temp == target) return target;
                if (temp < target) {
                    left++;
                } else {
                    right--;
                }
                if (Math.abs(temp - target) < Math.abs(res - target)) {
                    res = temp;
                }
            }
        }

        return res;

    }

}
