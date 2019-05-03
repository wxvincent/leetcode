package cn.itwx.leetcode21_30;

public class Leetcode29 {

    public int divide(int dividend, int divisor) {
//      考虑特殊情况
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;

        long x = (dividend < 0) ? -(long) dividend : (long) dividend;
        long y = (divisor < 0) ? -(long) divisor : (long) divisor;
        int res = 0;

        while (x >= y) {//此处使用for循环实在太慢,用这种方法来模拟乘法还可以
            long temp = y, mid = 1;
            while (x >= (temp << 1)) {
                temp <<= 1;
                mid <<= 1;
            }
            x -= temp;
            res += mid;
        }

        return sign * res;
    }
}
