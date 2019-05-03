package cn.itwx.leetcode1_10;

import java.util.HashMap;
import java.util.Map;

public class Leetcode3 {

    public int lengthOfLongestSubstring(String s) {
        if (s==null || s.length()==0) return 0;
        Map<Character,Integer> map = new HashMap<>();
        int[] dp = new int[s.length()];
        map.put(s.charAt(0),0);
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i)) || i-map.get(s.charAt(i))>dp[i-1]){
                dp[i] = dp[i-1]+1;
            }else {
                dp[i] = i-map.get(s.charAt(i));
            }
            map.put(s.charAt(i),i);
        }

        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i]>max){
                max = dp[i];
            }
        }
        return max;
    }
}
