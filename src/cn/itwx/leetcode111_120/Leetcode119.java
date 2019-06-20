package cn.itwx.leetcode111_120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode119 {

    //和前一道题不一样的地方在于这里使用了数组，最后直接把数组的最后一行给放到集合中去即可
    public List<Integer> getRow(int rowIndex) {
        int[][] nums = new int[rowIndex + 1][rowIndex + 1];

        for (int i = 0; i < nums.length; i++) {
            nums[i][0] = 1;
        }

        if (rowIndex == 0) return Arrays.asList(1);
        if (rowIndex == 1) return Arrays.asList(1, 1);

        nums[1][1] = 1;
        for (int i = 2; i < nums.length; i++) {
            for (int j = 1; j < i; j++) {
                nums[i][j] = nums[i - 1][j - 1] + nums[i - 1][j];
            }
            nums[i][i] = 1;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums[rowIndex].length; i++) {
            res.add(nums[rowIndex][i]);
        }
        return res;
    }
}
