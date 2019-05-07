package cn.itwx.leetcode61_70;

public class Leetcode65 {

    public boolean isNumber(String s) {
        if (s.charAt(s.length() - 1) == 'f' || s.charAt(s.length() - 1) == 'F' ||
                s.charAt(s.length() - 1) == 'd' || s.charAt(s.length() - 1) == 'D') return false;
        try {
            Float.parseFloat(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
