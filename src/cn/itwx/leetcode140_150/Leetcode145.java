package cn.itwx.leetcode140_150;

import cn.itwx.source.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
}
