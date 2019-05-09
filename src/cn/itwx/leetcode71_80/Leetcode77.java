package cn.itwx.leetcode71_80;

import java.util.ArrayList;
import java.util.List;

public class Leetcode77 {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        backtrack(res,temp,n,k,1);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> temp, int n, int k, int start) {
        if(temp.size()==k){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= n; i++) {
            temp.add(i);
            backtrack(res, temp, n, k, i+1);
            temp.remove(temp.size()-1);
        }
    }
}
