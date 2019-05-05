package cn.itwx.leetcode51_60;

public class Leetcode55 {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;

        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxLen || maxLen >= nums.length - 1) {
                break;
            }
            maxLen = Math.max(maxLen, i + nums[i]);
        }

        return maxLen >= nums.length - 1;
    }
}
