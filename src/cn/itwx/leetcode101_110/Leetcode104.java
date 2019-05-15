package cn.itwx.leetcode101_110;

import cn.itwx.source.TreeNode;

public class Leetcode104 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
