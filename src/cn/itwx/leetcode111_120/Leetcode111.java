package cn.itwx.leetcode111_120;

import cn.itwx.source.TreeNode;

public class Leetcode111 {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (root.left == null) return right + 1;
        if (root.right == null) return left + 1;
        return Math.min(left, right) + 1;
    }
}
