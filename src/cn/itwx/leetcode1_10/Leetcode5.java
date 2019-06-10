package cn.itwx.leetcode1_10;

public class Leetcode5 {

    public static String findLongestPalindrome1(String s) {
        int len = s.length();
        int start = 0;//纪录最长子串的初始位置
        int maxlength = 0;//纪录最长子串的长度
        boolean p[][] = new boolean[s.length()][s.length()];
        // 子串长度为1和为2的初始化
        for (int i = 0; i < len; i++) {
            p[i][i] = true;

            if (maxlength == 0 || maxlength == 1) {
                start = i;
                maxlength = 1;
            }

            if (i < len - 1 && s.charAt(i) == s.charAt(i + 1)) {
                p[i][i + 1] = true;
                start = i;
                maxlength = 2;
            }
        }
        // 使用上述结果可以dp出子串长度为3~len -1的子串
        for (int strlen = 3; strlen <= len; strlen++) {
            for (int i = 0; i <= len - strlen; i++) {
                int j = i + strlen - 1; // 子串结束的位置
                if (p[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    p[i][j] = true;
                    maxlength = strlen;
                    start = i;
                }
            }
        }

        return s.substring(start, start + maxlength);
    }

    public static void main(String[] args) {
        String s = findLongestPalindrome1("ababac");
        System.out.println(s);
    }

}
