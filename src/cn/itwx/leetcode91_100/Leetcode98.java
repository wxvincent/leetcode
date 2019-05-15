package cn.itwx.leetcode91_100;

import cn.itwx.source.TreeNode;

public class Leetcode98 {

    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, long minValue, long maxValue) {
        if (root == null) return true;

        if (root.val >= maxValue || root.val <= minValue) return false;

        return dfs(root.left, minValue, root.val) && dfs(root.right, root.val, maxValue);
    }
}
