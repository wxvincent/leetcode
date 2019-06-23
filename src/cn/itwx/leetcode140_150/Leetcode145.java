package cn.itwx.leetcode140_150;

import cn.itwx.source.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(res, root);
        return res;
    }

    private void postorder(List<Integer> res, TreeNode root) {
        if (root == null) return;
        postorder(res, root.left);
        postorder(res, root.right);
        res.add(root.val);
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left != null) stack.push(node.left);//和传统先序遍历不一样，先将左结点入栈
            if(node.right != null) stack.push(node.right);//后将右结点入栈
            res.add(0,node.val);//逆序添加结点值，因为是逆序，所以先将左节点入栈
        }
        return res;
    }
}
