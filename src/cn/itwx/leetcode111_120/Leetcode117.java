package cn.itwx.leetcode111_120;

import cn.itwx.source.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode117 {

    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        List<Node> list = new ArrayList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            count = queue.size();
            for (int i = 0; i < count; i++) {
                Node node = queue.poll();
                list.add(node);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            for (int i = 0; i < list.size() - 1; i++) {
                list.get(i).next = list.get(i + 1);
            }
            list.clear();
        }
        return root;
    }

}

