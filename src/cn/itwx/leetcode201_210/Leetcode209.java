package cn.itwx.leetcode201_210;

public class Leetcode209 {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int result = Integer.MAX_VALUE;

        int test = 0;
        for (int i = 0; i < nums.length; i++) {
            test += nums[i];
        }
        if (test < s) return 0;

        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                temp += nums[j];
                count++;
                if (temp >= s) {
                    if (count < result) {
                        result = count;
                    }
                    break;
                }
            }
        }

        return result;
    }
}
