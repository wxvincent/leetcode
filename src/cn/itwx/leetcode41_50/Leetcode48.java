package cn.itwx.leetcode41_50;

public class Leetcode48 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {//总共循环几次
            for (int j = 0; j < n - 2 * i - 1; j++) {//每次循环需要变化多少次
                int temp = matrix[i][i + j];//找好四个点的坐标即可，基本上都是n-1-某个值
                matrix[i][i + j] = matrix[n - 1 - (i + j)][i];
                matrix[n - 1 - (i + j)][i] = matrix[n - 1 - i][n - 1 - (i + j)];
                matrix[n - 1 - i][n - 1 - (i + j)] = matrix[i + j][n - 1 - i];
                matrix[i + j][n - 1 - i] = temp;
            }
        }

    }
}
