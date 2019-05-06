package cn.itwx.leetcode61_70;

public class Leetcode63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] ways = new int[obstacleGrid.length][obstacleGrid[0].length];
        int i = 0;
        int j = 0;

        for (i = 0; i < obstacleGrid.length; i++) {
            for (j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    ways[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    ways[i][j] = 1;
                } else if (i == 0 && j > 0) {
                    ways[i][j] = ways[i][j - 1];
                } else if (j == 0 && i > 0) {
                    ways[i][j] = ways[i - 1][j];
                } else {
                    ways[i][j] = ways[i - 1][j] + ways[i][j - 1];
                }

            }
        }
        return ways[i - 1][j - 1];
    }
}
