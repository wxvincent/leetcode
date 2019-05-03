package cn.itwx.leetcode31_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }

    public void combinationSum2(List<List<Integer>> res, ArrayList<Integer> list, int[] candidates, int target, int index, int sum) {
        if (sum == target || index >= candidates.length) {
            if (sum == target) {
                res.add(new ArrayList<Integer>(list));
            }
            return;
        } else {
            if (sum + candidates[index] < target) {
                list.add(candidates[index]);
                combinationSum2(res, list, candidates, target, index + 1, sum + candidates[index]);
                list.remove(list.size() - 1);
            } else if (sum + candidates[index] == target) {
                list.add(candidates[index]);
                res.add(new ArrayList<Integer>(list));
                list.remove(list.size() - 1);
                return;
            } else if (sum + candidates[index] > target) {
                return;
            }
            while (index < candidates.length - 1 && candidates[index] == candidates[index + 1]) {
                index++;
            }
            combinationSum2(res, list, candidates, target, index + 1, sum);
        }
    }
}
