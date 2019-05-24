package cn.itwx.leetcode140_150;

import java.util.Stack;

public class Leetcode150 {

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (stack.isEmpty() || !(tokens[i].equals("+") || tokens[i].equals("-") ||
                    tokens[i].equals("*") || tokens[i].equals("/"))) {
                stack.push(tokens[i]);
            } else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                if (tokens[i].equals("+")) stack.push(String.valueOf(num2 + num1));
                if (tokens[i].equals("-")) stack.push(String.valueOf(num2 - num1));
                if (tokens[i].equals("*")) stack.push(String.valueOf(num2 * num1));
                if (tokens[i].equals("/")) stack.push(String.valueOf(num2 / num1));
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
