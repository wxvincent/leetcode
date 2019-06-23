package cn.itwx.leetcode140_150;

import cn.itwx.source.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(res, root);
        return res;
    }

    private void preorder(List<Integer> res, TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        preorder(res, root.left);
        preorder(res, root.right);
    }


    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return res;
    }
}
