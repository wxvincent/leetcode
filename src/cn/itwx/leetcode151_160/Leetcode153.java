package cn.itwx.leetcode151_160;

public class Leetcode153 {

    public int findMin(int[] nums) {
        if (nums.length == 0) return 0;
        int left = 0, right = nums.length - 1, mid = left;

        while (nums[left] > nums[right]) {
            if (left == right - 1) {
                mid = right;
                break;
            }
            mid = (left + right) / 2;
            if (nums[mid] >= nums[left]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return nums[mid];
    }
}

