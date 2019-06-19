package cn.itwx.leetcode101_110;

import cn.itwx.source.TreeNode;

import java.util.Arrays;

public class Leetcode106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null ||
                inorder.length != postorder.length || inorder.length == 0) return null;

        int i = 0;
        for (i = 0; i < inorder.length; i++) {
            if (inorder[i] == postorder[postorder.length - 1]) break;
        }

        TreeNode node = new TreeNode(postorder[postorder.length - 1]);
        node.left = buildTree(Arrays.copyOfRange(inorder, 0, i),
                Arrays.copyOfRange(postorder, 0, i));
        node.right = buildTree(Arrays.copyOfRange(inorder, i + 1, inorder.length),
                Arrays.copyOfRange(postorder, i, postorder.length - 1));

        return node;
    }
}
