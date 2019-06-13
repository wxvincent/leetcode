package cn.itwx.leetcode51_60;

public class Leetcode59 {

    public int[][] generateMatrix(int n) {

        int[][] res = new int[n][n];

        int start = 0;
        int[] index = {1};//和打印矩阵不同的地方
        while (2 * start < n) {
            generate(res, start, index);
            start++;
        }
        return res;
    }

    private void generate(int[][] res, int start, int[] index) {
        int endX = res.length - 1 - start, endY = res.length - 1 - start;
        for (int i = start; i <= endX; i++) {
            res[start][i] = index[0];
            index[0]++;
        }
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                res[i][endX] = index[0];
                index[0]++;
            }
        }
        if (start < endY && start < endX) {
            for (int i = endX - 1; i >= start; i--) {
                res[endY][i] = index[0];
                index[0]++;
            }
        }
        if (start < endY - 1 && start < endX) {
            for (int i = endY - 1; i >= start + 1; i--) {
                res[i][start] = index[0];
                index[0]++;
            }
        }
    }
}
