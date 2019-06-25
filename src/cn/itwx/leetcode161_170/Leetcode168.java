package cn.itwx.leetcode161_170;

public class Leetcode168 {

    public String convertToTitle(int n) {
        if (n <= 0) return "";

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;//n--十分精髓，从0开始去加上‘A’就挺舒服
            sb.append((char) (n % 26 + 'A'));
            n = n / 26;
        }
        return sb.reverse().toString();
    }

}
