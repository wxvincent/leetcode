package cn.itwx.leetcode51_60;

import java.util.ArrayList;
import java.util.List;

public class Leetcode54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;

        int start = 0;
        while (start * 2 < matrix.length && start * 2 < matrix[0].length) {
            printMatrix(matrix, start, res);
            start++;
        }

        return res;
    }

    private void printMatrix(int[][] matrix, int start, List<Integer> res) {
        int endX = matrix[0].length - start - 1, endY = matrix.length - start - 1;
        for (int i = start; i <= endX; i++) {
            res.add(matrix[start][i]);
        }
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                res.add(matrix[i][endX]);
            }
        }
        if (start < endY && start < endX) {
            for (int i = endX - 1; i >= start; i--) {
                res.add(matrix[endY][i]);
            }
        }
        if (start < endY - 1 && start < endX) {
            for (int i = endY - 1; i > start; i--) {
                res.add(matrix[i][start]);
            }
        }

    }
}
