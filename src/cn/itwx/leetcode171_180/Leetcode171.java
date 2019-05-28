package cn.itwx.leetcode171_180;

public class Leetcode171 {

    public int titleToNumber(String s) {
        double sum = 0;
        if (s.length() == 0) return 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            sum = sum + Math.pow(26, s.length() - i - 1) * (s.charAt(i) - 64);
        }

        return (int) sum;
    }
}
