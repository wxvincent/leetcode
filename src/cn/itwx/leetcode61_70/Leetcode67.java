package cn.itwx.leetcode61_70;

public class Leetcode67 {

    public String addBinary(String a, String b) {
        int len = Math.min(a.length(), b.length());
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = 0; i < len; i++) {
            int i1 = a.charAt(a.length() - 1 - i) - '0';
            int i2 = b.charAt(b.length() - 1 - i) - '0';
            int temp = i1 + i2 + count;
            sb.append(temp % 2);
            count = temp / 2;
        }

        if (a.length() < b.length()) {
            count = getCount(b, a, sb, count);
        } else if (a.length() > b.length()) {
            count = getCount(a, b, sb, count);
        }

        if (count != 0) sb.append(1);
        return sb.reverse().toString();
    }

    private int getCount(String a, String b, StringBuilder sb, int count) {
        for (int i = a.length() - 1 - b.length(); i >= 0; i--) {
            int i3 = a.charAt(i) - '0';
            int temp = i3 + count;
            sb.append(temp % 2);
            count = temp / 2;
        }
        return count;
    }

}