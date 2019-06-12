package cn.itwx.leetcode41_50;

public class Leetcode50 {

    public double myPow(double x, int n) {

        if (n == 0) return 1;
        //此处需要考虑到递归进入后会发生n = -n，所以这里乘以1 / x
        if (n == Integer.MIN_VALUE) return 1 / x * myPow(x, n + 1);
        if (n < 0) {
            n = -n;
            return myPow(1 / x, n);
        }

        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}
