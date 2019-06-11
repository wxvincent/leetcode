package cn.itwx.leetcode11_20;

public class Leetcode13 {

    public int romanToInt(String s) {
        //用数组定义字典
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        if (s == null || s.length() == 0) return 0;
        int res = 0;

        a:
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length()) {
                for (int j = 0; j < strs.length; j++) {
                    if (s.substring(i, i + 2).equals(strs[j])) {
                        res += values[j];
                        i++;
                        continue a;
                    }
                }
            }

            for (int j = 0; j < strs.length; j++) {
                if (String.valueOf(s.charAt(i)).equals(strs[j])) {
                    res += values[j];
                }
            }
        }
        return res;
    }
}
