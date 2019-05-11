package cn.itwx.leetcode81_90;

import java.util.Stack;

public class Leetcode84 {//使用单调栈，不好理解

    public int largestRectangleArea(int[] heights) {
        // Ascending stack 递增栈
        int[] heights2 = new int[heights.length + 1];
        System.arraycopy(heights, 0, heights2, 0, heights.length);
        heights2[heights2.length - 1] = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        int MAX_AREA = 0;
        int i = 0;
        for (i = 0; i < heights2.length; i++) {
            if (stack.isEmpty() || heights2[i] > heights2[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && heights2[stack.peek()] >= heights2[i]) {
                    int popindex = stack.pop();
                    // i-1 是闭右边界 topindex+1 是闭左边界
                    // 长度是 (i-1)-(topindex+1)+1  == i-topindex-1
                    int topindex = stack.isEmpty() ? -1 : stack.peek();
                    int area = (i - 1 - topindex) * heights2[popindex];
                    if (area > MAX_AREA) {
                        MAX_AREA = area;
                    }
                }
                stack.push(i);
            }
        }
        return MAX_AREA;
    }
}
