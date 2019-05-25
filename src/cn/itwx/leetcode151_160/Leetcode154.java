package cn.itwx.leetcode151_160;

public class Leetcode154 {

    public int findMin(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int left = 0, right = nums.length - 1, mid = left;

        while (nums[left] >= nums[right]) {
            if (left == right - 1) {
                mid = right;
                break;
            }
            mid = (left + right) / 2;

            if (nums[mid] == nums[left] && nums[mid] == nums[right]) {
                int temp = nums[left];
                for (int i = 1; i < nums.length; i++) {
                    if (nums[i] < temp) {
                        temp = nums[i];
                    }
                }
                return temp;
            }

            if (nums[mid] >= nums[left]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return nums[mid];
    }
}
