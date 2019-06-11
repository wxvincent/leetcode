package cn.itwx.leetcode21_30;

public class Leetcode28 {

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        if (needle.length() == 0) return 0;
        if (haystack.length() == 0) return -1;

        a:
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    continue a;
                }
            }
            return i;
        }
        return -1;
    }
}
