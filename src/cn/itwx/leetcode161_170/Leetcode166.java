package cn.itwx.leetcode161_170;

import java.util.HashMap;

public class Leetcode166 {

    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) return "NaN";
        if (numerator == 0) return "0";

        StringBuilder res = new StringBuilder();
        long n1 = Math.abs((long) numerator);
        long n2 = Math.abs((long) denominator);
        HashMap<Long, Long> m = new HashMap<>();
        long pre = 0, cur = 0, index = 0;
        if ((long) numerator * (long) denominator < 0) {
            res.append("-");
        }
        if (n1 % n2 == 0) {
            res.append(n1 / n2);
            return res.toString();
        }
        res.append(n1 / n2 + "."); //整数部分
        index = res.length();
        n1 = n1 % n2;
        while (n1 % n2 != 0) {//不太理解
            if (m.containsKey(n1)) {
                res.insert(Integer.parseInt(m.get(n1).toString()), "(");
                res.append(")");
                break;
            }
            m.put(n1, index);
            n1 *= 10;
            cur = n1 / n2;
            res.append(cur);
            n1 = n1 % n2;
            index++;
        }

        return res.toString();
    }
}
