package cn.itwx.leetcode131_140;

import java.util.List;

public class Leetcode139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] word = new boolean[n + 1];
        word[0] = true;

        for (int i = 1; i <= n; i++) {
            //从0到i不断试，看看是否可以匹配
            for (int j = 0; j < i; j++) {
                if (word[j] && wordDict.contains(s.substring(j, i))) {
                    word[i] = true;
                    break;
                }
            }
        }

        return word[n];
    }
}
