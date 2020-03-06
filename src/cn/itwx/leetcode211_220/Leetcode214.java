package cn.itwx.leetcode211_220;

public class Leetcode214 {

    public static String shortestPalindrome(String s) {
        StringBuilder r = new StringBuilder(s).reverse();
        String str = s + "#" + r;
        int[] next = next(str);
        String prefix = r.substring(0, r.length() - next[str.length()]);
        return prefix + s;
    }

    //再去研究研究KMP算法吧，没搞懂
    // next数组
    private static int[] next(String P) {
        int[] next = new int[P.length() + 1];
        next[0] = -1;
        int k = -1;
        int i = 1;
        while (i < next.length) {
            if (k == -1 || P.charAt(k) == P.charAt(i - 1)) {
                next[i++] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        Leetcode214.shortestPalindrome("abc");
    }
}
