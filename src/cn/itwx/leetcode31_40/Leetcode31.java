package cn.itwx.leetcode31_40;

import java.util.Arrays;

public class Leetcode31 {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int i = nums.length - 1;
        while (nums[i] <= nums[i - 1]) {
            i--;
            if (i == 0) {//此时的数是最大数，直接反转
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
        //i-1是刚才找到的需要改变的位置，这里从新从最后开始找第一个大于它的数，然后交换
        while (nums[j] <= nums[i - 1]) {
            j--;
        }
        int temp = nums[i - 1];
        nums[i - 1] = nums[j];
        nums[j] = temp;

        //不要忘记对i-1后面的数进行排序
        Arrays.sort(nums, i, nums.length);
    }
}
