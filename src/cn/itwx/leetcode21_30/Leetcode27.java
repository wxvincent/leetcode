package cn.itwx.leetcode21_30;

public class Leetcode27 {

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;

        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[num] = nums[i];
                num++;
            }
        }
        return num;
    }
}
