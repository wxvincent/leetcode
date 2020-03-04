package cn.itwx.leetcode201_210;

import java.util.Stack;

public class Leetcode207 {

    /**
     * 拓扑排序
     * <p>
     * 1、创建一个一维数组存放顶点的入度
     * 2、将入度为0的顶点入栈
     * 3、只要栈非空，就从栈顶取出一个顶点，结果集加1，并且将这个顶点的所有邻接点的入度减1，
     * 在减1以后，发现这个邻接点的入度为0，就继续入栈。
     * 最后检查结果集的大小是否和课程数相同即可。
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) return true;

        int[] count = new int[numCourses];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prerequisites.length; i++) {
            count[prerequisites[i][0]]++;
        }

        int result = 0;
        for (int i = 0; i < numCourses; i++) {
            if (count[i] == 0) {
                stack.push(i);
                result++;
            }
        }

        while (!stack.isEmpty()) {
            int temp = stack.pop();
            for (int i = 0; i < prerequisites.length; i++) {
                if (temp == prerequisites[i][1]) {
                    count[prerequisites[i][0]]--;
                    if (count[prerequisites[i][0]] == 0) {
                        stack.push(prerequisites[i][0]);
                        result++;
                    }
                }
            }
        }

        return result == numCourses;
    }
}
