package cn.itwx.leetcode91_100;

import cn.itwx.source.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Leetcode95 {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<>();
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> res = new LinkedList<>();
        if (start > end) {//注意这里的判断条件
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {//索引i代表的是根节点
            List<TreeNode> subLeftTree = generateTrees(start, i - 1);
            List<TreeNode> subRightTree = generateTrees(i + 1, end);
            for (TreeNode left : subLeftTree) {
                for (TreeNode right : subRightTree) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        return res;
    }
}
