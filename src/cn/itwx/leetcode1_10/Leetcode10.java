package cn.itwx.leetcode1_10;

public class Leetcode10 {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;

        int sIndex = 0;
        int pIndex = 0;
        return match(s, sIndex, p, pIndex);
    }

    private boolean match(String s, int sIndex, String p, int pIndex) {
        if (sIndex == s.length() && pIndex == p.length()) return true;
        if (sIndex != s.length() && pIndex == p.length()) return false;

        if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
            if ((sIndex < s.length() && s.charAt(sIndex) == p.charAt(pIndex)) ||
                    sIndex < s.length() && p.charAt(pIndex) == '.') {
                return match(s, sIndex, p, pIndex + 2) ||
                        match(s, sIndex + 1, p, pIndex) ||
                        match(s, sIndex + 1, p, pIndex + 2);
            } else {
                return match(s, sIndex, p, pIndex + 2);
            }
        }

        if ((sIndex < s.length() && s.charAt(sIndex) == p.charAt(pIndex)) ||
                sIndex < s.length() && p.charAt(pIndex) == '.') {
            return match(s, sIndex + 1, p, pIndex + 1);
        }

        return false;
    }
}
