package cn.itwx.leetcode1_10;

public class Leetcode1 {

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return null;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
