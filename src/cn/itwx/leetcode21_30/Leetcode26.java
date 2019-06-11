package cn.itwx.leetcode21_30;

public class Leetcode26 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int num = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[num]) {
                num++;
                nums[num] = nums[i];
            }
        }
        return num + 1;
    }
}
