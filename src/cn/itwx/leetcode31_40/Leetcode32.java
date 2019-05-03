package cn.itwx.leetcode31_40;

import java.util.Stack;

public class Leetcode32 {

    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;

        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();
        int[] res = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (stack.isEmpty() || chars[i] == '(') {
                stack.push(chars[i]);
            } else {
                char c = stack.peek();
                if (c == ')') {
                    stack.push(chars[i]);
                } else {
                    stack.pop();
                    int k = i - 1;
                    while (res[k] == 1) {
                        k--;
                    }
                    res[i] = res[k] = 1;
                }
            }
        }

        int max = 0;
        int temp = 0;
        for (int i = 0; i < res.length; i++) {
            if (res[i] == 1) {
                temp++;
                max = max >= temp ? max : temp;
            } else {
                temp = 0;
            }
        }
        return max;
    }
}
