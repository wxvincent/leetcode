package cn.itwx.leetcode161_170;

public class Leetcode162 {

    public int findPeakElement(int[] nums) {
        if (nums.length == 0) return 0;

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            //因为左边右边均是负无穷，所以哪个大，那边就一定存在峰值
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
