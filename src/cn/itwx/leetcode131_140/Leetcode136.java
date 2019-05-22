package cn.itwx.leetcode131_140;

public class Leetcode136 {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
