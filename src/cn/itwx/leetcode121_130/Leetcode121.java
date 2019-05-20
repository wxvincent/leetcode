package cn.itwx.leetcode121_130;

public class Leetcode121 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int min = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                continue;
            }
            max = max > prices[i] - min ? max : prices[i] - min;
        }
        return max;
    }
}
