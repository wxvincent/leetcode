package cn.itwx.leetcode111_120;

import cn.itwx.source.Node;

public class Leetcode116 {

    public Node connect(Node root) {
        if (root == null) return null;
        if (root.left != null) root.left.next = root.right;
        //注意这里需要判断两个条件
        if (root.next != null && root.right != null) root.right.next = root.next.left;

        //相当于是前序遍历
        connect(root.left);
        connect(root.right);

        return root;
    }
}
