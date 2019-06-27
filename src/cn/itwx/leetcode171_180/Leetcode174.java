package cn.itwx.leetcode171_180;

public class Leetcode174 {

    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int cloumn = dungeon[0].length;

        int[][] cost = new int[row + 1][cloumn + 1];
        //填充最大值，这样下面的math.min就可以进行了
        for (int i = 0; i <= row; i++) {
            cost[i][cloumn] = Integer.MAX_VALUE;
        }
        for (int i = 0; i <= cloumn; i++) {
            cost[row][i] = Integer.MAX_VALUE;
        }

        for (int i = row - 1; i >= 0; i--) {
            for (int j = cloumn - 1; j >= 0; j--) {
                //初始化公主房间的cost
                if (i == row - 1 && j == cloumn - 1) {
                    cost[i][j] = dungeon[i][j] > 0 ? 1 : 1 - dungeon[i][j];
                    continue;
                }
                //更新当前位置到公主房间所需要的最小生命值。 min函数用来判断是往右边走还是往下走更合适，
                //max函数用来限制骑士当前的生命值不能小于1.
                cost[i][j] = Math.max(1, Math.min(cost[i + 1][j], cost[i][j + 1]) - dungeon[i][j]);

            }
        }
        return cost[0][0];
    }
}
