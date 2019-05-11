package cn.itwx.leetcode81_90;

public class Leetcode81 {

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return true;

            if (nums[mid] == nums[left] && nums[mid] == nums[right]) {
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == target) return true;
                }
            }

            if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }

}
