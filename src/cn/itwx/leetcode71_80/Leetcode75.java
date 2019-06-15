package cn.itwx.leetcode71_80;

public class Leetcode75 {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > right) return;
            if (nums[i] < 1) {
                swap(nums, left, i);
                left++;
            } else if (nums[i] > 1) {
                swap(nums, right, i);
                right--;
                i--;//注意这里需要i--，因为从后面换过来的数不能确定大小
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
