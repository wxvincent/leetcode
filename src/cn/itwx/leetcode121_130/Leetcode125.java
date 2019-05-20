package cn.itwx.leetcode121_130;

public class Leetcode125 {

    public boolean isPalindrome(String s) {
        if (s == null) return true;
        s = s.toLowerCase();
        int length = s.length();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                sb.append(c);
            }
        }

        return sb.toString().equals(sb.reverse().toString());
    }
}
