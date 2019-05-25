package cn.itwx.leetcode151_160;

public class Leetcode151 {

    public String reverseWords(String s) {
        String[] split = s.split(" ");
        if (split.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(split[split.length - 1]);
        for (int i = split.length - 2; i >= 0; i--) {
            if (split[i].equals("")) {
                //注意split方法，每次遇到空格就把前面的值返回，
                // 如果最前面是一个空格的话，就把空字符串返回
                continue;
            }
            sb.append(" " + split[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Leetcode151 leetcode151 = new Leetcode151();
        String s = leetcode151.reverseWords(" hello world! ");
        System.out.println(s);
    }
}
