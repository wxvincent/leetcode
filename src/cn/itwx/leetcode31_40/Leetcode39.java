package cn.itwx.leetcode31_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> listAll = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        //排序
        Arrays.sort(candidates);
        find(listAll, list, candidates, target, 0);
        return listAll;
    }

    public void find(List<List<Integer>> listAll, List<Integer> tmp, int[] candidates, int target, int num) {
        //递归的终点
        if (target == 0) {
            listAll.add(tmp);
            return;
        }
        if (target < candidates[num]) return;
        //注意所有数字都是正整数
        for (int i = num; i < candidates.length && candidates[i] <= target; i++) {
            //深拷贝
            List<Integer> list = new ArrayList<>(tmp);
            list.add(candidates[i]);
            //递归运算，将i传递至下一次运算是为了避免结果重复
            find(listAll, list, candidates, target - candidates[i], i);
        }
    }
}
