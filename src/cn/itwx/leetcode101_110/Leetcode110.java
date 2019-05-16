package cn.itwx.leetcode101_110;

import cn.itwx.source.TreeNode;

public class Leetcode110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int left = depth(root.left);
        int right = depth(root.right);
        if (Math.abs(left - right) >= 2) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
}
