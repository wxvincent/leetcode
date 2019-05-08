package cn.itwx.leetcode71_80;

public class Leetcode74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0 || target < matrix[0][0] ||
                target > matrix[matrix.length - 1][matrix[0].length - 1]) return false;

        int i = 0;
        while (i < matrix.length && matrix[i][0] <= target) {
            i++;
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[i - 1][j] == target) return true;
        }
        return false;
    }

}
