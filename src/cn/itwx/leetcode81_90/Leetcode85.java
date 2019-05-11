package cn.itwx.leetcode81_90;

import java.util.Stack;

public class Leetcode85 {//和上题差不多

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[] height = new int[matrix[0].length];
        int globalmax = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') height[j] = 0;
                else height[j]++;
            }
            globalmax = Math.max(globalmax, maxrow(height));
        }
        return globalmax;
    }

    public int maxrow(int[] height) {
        Stack<Integer> st = new Stack<>();
        int localmax = 0;
        for (int i = 0; i <= height.length; i++) {
            int h = (i == height.length) ? 0 : height[i];
            while (!st.isEmpty() && height[st.peek()] >= h) {
                int maxheight = height[st.pop()];
                int area = st.isEmpty() ? i * maxheight : maxheight * (i - st.peek() - 1);
                localmax = Math.max(localmax, area);
            }
            st.push(i);
        }
        return localmax;
    }
}
