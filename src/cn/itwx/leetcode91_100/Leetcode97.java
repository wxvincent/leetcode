package cn.itwx.leetcode91_100;

public class Leetcode97 {

    public boolean isInterleave(String ss1, String ss2, String ss3) {
        char[] s1 = ss1.toCharArray();
        char[] s2 = ss2.toCharArray();
        char[] s3 = ss3.toCharArray();
        int m = s1.length;
        int n = s2.length;
        if (ss3.length() != m + n) return false;

        //dp[i][j]ss3前i+j个字符是否由ss1前i个字符ss1[0..i-1]和ss2前j个字符ss2[0..j-1]交错形成
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                dp[i][j] = false;
                //情况1，ss3前i+j-1个字符由ss1前i-1个字符和ss2前j个字符交错形成，ss3第i+j个字符等于ss1第i个字符
                if (i > 0 && s3[i + j - 1] == s1[i - 1]) {
                    dp[i][j] |= dp[i - 1][j];
                }
                //情况2，ss3前i+j-1个字符由ss1前i个字符和ss2前j-1个字符交错形成，ss3第i+j个字符等于ss2第j个字符
                if (j > 0 && s3[i + j - 1] == s2[j - 1]) {
                    dp[i][j] |= dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
