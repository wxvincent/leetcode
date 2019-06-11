package cn.itwx.leetcode11_20;

public class Leetcode14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < min) {
                min = strs[i].length();
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < min; i++) {
            char temp = strs[0].charAt(i);
            boolean equal = true;
            for (int j = 1; j < strs.length; j++) {
                if (temp != strs[j].charAt(i)) {
                    equal = false;
                }
            }
            if (equal) {
                sb.append(temp);
            } else {
                return sb.toString();
            }
        }
        return sb.toString();
    }
}
