package cn.itwx.leetcode111_120;

import cn.itwx.source.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (root == null) return res;
        pathSum(root, res, temp, sum);
        return res;
    }

    private void pathSum(TreeNode root, List<List<Integer>> res, List<Integer> temp, int sum) {
        temp.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }

        if (root.left != null) {
            pathSum(root.left, res, temp, sum - root.val);
            temp.remove(temp.size() - 1);
        }
        if (root.right != null) {
            pathSum(root.right, res, temp, sum - root.val);
            temp.remove(temp.size() - 1);
        }

    }

}
