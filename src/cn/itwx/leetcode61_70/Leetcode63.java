package cn.itwx.leetcode61_70;

public class Leetcode63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] ways = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    ways[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    ways[i][j] = 1;
                } else if (i == 0) {
                    ways[i][j] = ways[i][j - 1];
                } else if (j == 0) {
                    ways[i][j] = ways[i - 1][j];
                } else {
                    ways[i][j] = ways[i - 1][j] + ways[i][j - 1];
                }
            }
        }
        return ways[ways.length - 1][ways[0].length - 1];
    }
}
