package cn.itwx.leetcode151_160;

import java.util.Stack;

public class Leetcode155 {


}

class MinStack {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty()) {
            stack2.push(x);
        } else {
            Integer peek = stack2.peek();
            if (x <= peek) {
                stack2.push(x);
            }
        }
    }

    public void pop() {
        int pop = stack1.pop();
        if (stack2.peek() == pop) {
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
