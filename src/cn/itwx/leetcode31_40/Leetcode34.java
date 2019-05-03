package cn.itwx.leetcode31_40;

public class Leetcode34 {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};

        int a = getFirstTarget(nums, target);
        if (a != -1) {
            int b = getLastTarget(nums, target, a);
            return new int[]{a, b};
        }
        return new int[]{-1, -1};
    }

    private int getLastTarget(int[] nums, int target, int index) {
        int left = index;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid + 1] != target) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private int getFirstTarget(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] != target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
