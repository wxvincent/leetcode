package cn.itwx.leetcode81_90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        Arrays.sort(nums);
        dfs(res, nums, temp, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, List<Integer> temp, int cur) {
        if (cur <= nums.length) res.add(new ArrayList<>(temp));

        for (int i = cur; i < nums.length; i++) {
            if (i > cur && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            dfs(res, nums, temp, i + 1);
            temp.remove(temp.size() - 1);
        }

    }
}
