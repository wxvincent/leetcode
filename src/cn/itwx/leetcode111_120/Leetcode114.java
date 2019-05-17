package cn.itwx.leetcode111_120;

import cn.itwx.source.TreeNode;

public class Leetcode114 {

    public void flatten(TreeNode root) {//啥也不管，后序遍历即可
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);

        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        root.right = tmp;
    }
}
