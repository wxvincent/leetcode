package cn.itwx.leetcode161_170;

public class Leetcode170 {

    public int majorityElement(int[] nums) {
        if (nums.length == 0) return 0;

        int temp = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) temp = nums[i];

            if (nums[i] == temp) {
                count++;
            } else {
                count--;
            }
        }
        return temp;
    }
}
