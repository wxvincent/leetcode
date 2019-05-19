package cn.itwx.leetcode111_120;

import cn.itwx.source.Node;

public class Leetcode117 {

    public Node connect(Node root) {
        if (root == null) return null;

        //node直接走到root的右兄弟处(根结点时,直接为null)
        Node node = root.next;

        //找到root的 右兄弟 中从左往右第一个不为空的孩子结点
        //(如果没有,则找下一个右兄弟,直到没有右兄弟为止->null)
        while (node != null) {
            if (node.left != null) {
                node = node.left;
                break;
            } else if (node.right != null) {
                node = node.right;
                break;
            } else {
                node = node.next;
            }
        }

        //如果左孩子不为空,就要替他找一个伴侣. 向右看第一个不为空的孩子.
        // (右孩子 | 上一步中找到的左往右第一个不为空的孩子结点
        if (root.left != null) {
            root.left.next = (root.right == null ? node : root.right);
        }

        //如果右孩子不为空,也要替他找一个伴侣. 即上一步中找到的左往右第一个不为空的孩子结点
        if (root.right != null) root.right.next = node;

        //先扫描右孩子再扫描左孩子.
        connect(root.right);
        connect(root.left);

        return root;
    }

}

