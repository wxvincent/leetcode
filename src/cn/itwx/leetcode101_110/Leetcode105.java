package cn.itwx.leetcode101_110;

import cn.itwx.source.TreeNode;

import java.util.Arrays;

public class Leetcode105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null ||
                preorder.length == 0 || preorder.length != inorder.length) return null;

        int i = 0;
        for (i = 0; i < inorder.length; i++) {
            if (preorder[0] == inorder[i]) break;
        }

        TreeNode node = new TreeNode(preorder[0]);
        node.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1),
                Arrays.copyOfRange(inorder, 0, i));
        node.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length),
                Arrays.copyOfRange(inorder, i + 1, inorder.length));

        return node;
    }

    public static void main(String[] args) {
        Leetcode105 leetcode105 = new Leetcode105();
        int[] a = {3, 9, 20, 15, 7};
        int[] b = {9, 3, 15, 20, 7};
        TreeNode node = leetcode105.buildTree(a, b);
        System.out.println(node.val);
    }
}
