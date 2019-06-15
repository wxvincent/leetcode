package cn.itwx.leetcode71_80;

import java.util.ArrayList;
import java.util.List;

public class Leetcode78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        dfs(res, temp, nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, int start) {
        res.add(new ArrayList<>(temp));

        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(res, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

}
