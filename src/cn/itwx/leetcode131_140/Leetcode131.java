package cn.itwx.leetcode131_140;

import java.util.ArrayList;
import java.util.List;

public class Leetcode131 {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        dfs(res, s, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(List<List<String>> res, String s,
                     List<String> partitionList, int index) {
        if (s.length() == index) {
            res.add(new ArrayList<>(partitionList));
            return;
        }

        //for循环控制着起始位置，递归从起始位置逐次向前走
        for (int i = index; i < s.length(); i++) {
            if (isPartition(s, index, i)) {
                partitionList.add(s.substring(index, i + 1));
                dfs(res, s, partitionList, i + 1);
                partitionList.remove(partitionList.size() - 1);
            }
        }
    }

    private boolean isPartition(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }
}
