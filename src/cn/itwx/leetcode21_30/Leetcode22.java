package cn.itwx.leetcode21_30;

import java.util.ArrayList;
import java.util.List;

public class Leetcode22 {

    public List<String> generateParenthesis(int n) {
        if (n <= 0) return null;
        List<String> res = new ArrayList<>();
        backTrace(res, "", 0, 0, n);
        return res;
    }

    private void backTrace(List<String> res, String s, int left, int right, int max) {
        if (left + right == max * 2) {
            res.add(s);
            return;
        }

        if (left < max) {
            backTrace(res, s + "(", left + 1, right, max);
        }

        if (right < left) {
            backTrace(res, s + ")", left, right + 1, max);
        }

        return;
    }
}
