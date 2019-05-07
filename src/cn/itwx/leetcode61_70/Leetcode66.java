package cn.itwx.leetcode61_70;

public class Leetcode66 {

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if (digits[len - 1] != 9) {
            digits[len - 1]++;
            return digits;
        } else {
            int i = len - 1;
            while (i >= 0 && digits[i] == 9) {
                digits[i] = 0;
                i--;
            }
            if (i == -1) {
                int[] res = new int[len + 1];
                res[0] = 1;
                return res;
            } else {
                digits[i]++;
                return digits;
            }
        }
    }
}
