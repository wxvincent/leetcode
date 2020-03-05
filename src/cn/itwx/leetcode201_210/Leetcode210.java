package cn.itwx.leetcode201_210;

import java.util.*;

public class Leetcode210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] count = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            count[prerequisites[i][0]]++;
        }

        List<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            int temp = stack.pop();
            res.add(temp);
            for (int i = 0; i < prerequisites.length; i++) {
                if (temp == prerequisites[i][1]) {
                    count[prerequisites[i][0]]--;
                    if (count[prerequisites[i][0]] == 0) {
                        stack.push(prerequisites[i][0]);
                    }
                }
            }
        }

        if (res.size() == numCourses) {
            int[] result = new int[numCourses];
            for (int i = 0; i < res.size(); i++) {
                result[i] = res.get(i);
            }
            return result;
        } else {
            return new int[0];
        }

    }

    public static void main(String[] args) {
        int[] order = new Leetcode210().findOrder(2, new int[0][0]);
        System.out.println(order);
    }
}
