package cn.itwx.leetcode201_210;

public class Leetcode201 {

    public int rangeBitwiseAnd(int m, int n) {

        int offset = 0;
        for (; m != n; ++offset) {
            m >>= 1;
            n >>= 1;
        }
        return n << offset;

    }
}
