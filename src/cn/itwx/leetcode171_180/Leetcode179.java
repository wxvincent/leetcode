package cn.itwx.leetcode171_180;

import java.util.Arrays;

public class Leetcode179 {

    public String largestNumber(int[] nums) {
        if (nums.length == 0) return null;

        String[] str = new String[nums.length];
        for (int i = 0; i < str.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(str, (s1, s2) -> {
            String temp1 = s1 + s2;
            String temp2 = s2 + s1;
            return temp2.compareTo(temp1);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            sb.append(s);
        }
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
