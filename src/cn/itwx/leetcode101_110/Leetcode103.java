package cn.itwx.leetcode101_110;

import cn.itwx.source.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);

        int count = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            if (count % 2 == 0) {
                while (!stack1.isEmpty()) {
                    TreeNode node = stack1.pop();
                    temp.add(node.val);
                    if (node.left != null) stack2.push(node.left);
                    if (node.right != null) stack2.push(node.right);
                }
                res.add(temp);
                count++;
            } else {
                while (!stack2.isEmpty()) {
                    TreeNode node = stack2.pop();
                    temp.add(node.val);
                    if (node.right != null) stack1.push(node.right);
                    if (node.left != null) stack1.push(node.left);
                }
                res.add(temp);
                count++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Leetcode103 leetcode103 = new Leetcode103();
        TreeNode root = new TreeNode(3);
        TreeNode a1 = new TreeNode(9);
        TreeNode a2 = new TreeNode(20);
        TreeNode a3 = new TreeNode(15);
        TreeNode a4 = new TreeNode(7);

        root.left = a1;
        root.right = a2;
        a2.left = a3;
        a2.right = a4;

        List<List<Integer>> list = leetcode103.zigzagLevelOrder(root);
        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.println(integer);
            }
        }

    }
}
