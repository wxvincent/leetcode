package cn.itwx.leetcode11_20;

import java.util.Stack;

public class Leetcode20 {

    public boolean isValid(String s) {
        if (s == null) return false;
        if (s.length() == 0) return true;

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (!stack.isEmpty()) {
                char peek = stack.peek();
                if ((peek == '(' && c == ')') || (peek == '[' && c == ']') || (peek == '{' && c == '}')) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();

    }
}
