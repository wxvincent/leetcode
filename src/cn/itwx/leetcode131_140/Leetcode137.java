package cn.itwx.leetcode131_140;

public class Leetcode137 {

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length <= 0) throw new RuntimeException();

        int[] bitSum = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int bitMask = 1;
            for (int j = 31; j >= 0; j--) {
                int bit = nums[i] & bitMask;
                if (bit != 0) {
                    bitSum[j] += 1;
                }
                bitMask = bitMask << 1;
            }
        }

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;//此处需要先乘2，可以仔细想下
            result = result + (bitSum[i] % 3);
        }

        return result;
    }
}
