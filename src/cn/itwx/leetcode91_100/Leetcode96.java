package cn.itwx.leetcode91_100;

public class Leetcode96 {

    public int numTrees(int n) {
        /**
         * 以n=5为例,根节点有1,2,3,4,5枚举这五种根节点,dp[i]表示n=i时的解
         *
         * 1: 左:dp[0],右:dp[4]
         * 2: 左:dp[1],右:dp[3]
         * 3: 左:dp[2],右:dp[2]
         * 4: 左:dp[3],右:dp[1]
         * 5: 左:dp[4],右dp:[0]
         * 状态转移方程: dp[i] += dp[j] * dp[i - 1 - j] for j in range(i)
         */

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[i - 1 - j] * dp[j];
            }
        }

        return dp[n];
    }

}
