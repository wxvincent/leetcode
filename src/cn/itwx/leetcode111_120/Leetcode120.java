package cn.itwx.leetcode111_120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] dp = new int[size];

        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < size; i++) {
            for (int j = triangle.get(i).size() - 1; j >= 0; j--) {
                if (j == 0) {
                    dp[j] = dp[j] + triangle.get(i).get(0);
                } else if (j == triangle.get(i).size() - 1) {
                    dp[j] = dp[j - 1] + triangle.get(i).get(j);
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
                }
            }
        }

        int min = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] < min) min = dp[i];
        }

        return min;
    }

    public static void main(String[] args) {
        Leetcode120 leetcode120 = new Leetcode120();
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3, 4));
        list.add(Arrays.asList(6, 5, 7));
        list.add(Arrays.asList(4, 1, 8, 3));
        int i = leetcode120.minimumTotal(list);
        System.out.println(i);
    }
}
