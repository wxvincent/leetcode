package cn.itwx.leetcode51_60;

public class Leetcode58 {

    public int lengthOfLastWord(String s) {
        if (s == null) return 0;

        String[] split = s.split(" ");
        if (split.length == 0) return 0;

        return split[split.length - 1].length();
    }
}
