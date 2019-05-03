package cn.itwx.leetcode41_50;

import java.util.ArrayList;
import java.util.List;

public class Leetcode46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        permute(nums, res, 0);
        return res;
    }

    private void permute(int[] nums, List<List<Integer>> res, int index) {
        if (index == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            res.add(list);
        } else {
            for (int i = index; i < nums.length; i++) {
                swap(nums, i, index);
                permute(nums, res, index + 1);
                swap(nums, i, index);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
