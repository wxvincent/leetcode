package cn.itwx.leetcode201_210;

import java.util.ArrayList;
import java.util.List;

public class Leetcode202 {

    public boolean isHappy(int n) {
        List<Integer> list = new ArrayList<>();

        while (!list.contains(n)) {
            list.add(n);
            String temp = String.valueOf(n);
            int sum = 0;
            for (int i = 0; i < temp.length(); i++) {
                sum += Math.pow(temp.charAt(i) - '0', 2);
            }
            if (sum == 1) {
                return true;
            }
            n = sum;
        }

        return false;
    }

    public static void main(String[] args) {
        boolean happy = new Leetcode202().isHappy(2);
        System.out.println(happy);
    }
}
