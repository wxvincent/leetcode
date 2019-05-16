package cn.itwx.leetcode101_110;

import cn.itwx.source.TreeNode;

public class Leetcode108 {

    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums == null) return null;
        return convertTree(nums, 0, nums.length - 1);
    }

    private TreeNode convertTree(int[] nums, int left, int right) {
        if (left <= right) {
            int mid = (left + right) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = convertTree(nums, left, mid - 1);
            node.right = convertTree(nums, mid + 1, right);
            return node;
        }

        return null;
    }
}
