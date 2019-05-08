package cn.itwx.leetcode61_70;

public class Leetcode70 {

    public int climbStairs(int n) {
        if (n == 1 || n == 2) return n;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
}
