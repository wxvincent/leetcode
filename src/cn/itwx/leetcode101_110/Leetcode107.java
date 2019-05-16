package cn.itwx.leetcode101_110;

import cn.itwx.source.TreeNode;

import java.util.*;

public class Leetcode107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            count = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(temp);
        }
        Collections.reverse(res);
        return res;
    }
}
