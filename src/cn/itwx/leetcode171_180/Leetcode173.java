package cn.itwx.leetcode171_180;

import cn.itwx.source.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode173 {

    class BSTIterator {

        List<Integer> res = new ArrayList<>();
        int count = 0;

        public BSTIterator(TreeNode root) {
            add(root);
        }

        private void add(TreeNode root) {
            if (root == null) return;
            add(root.left);
            res.add(root.val);
            add(root.right);
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            count++;
            return res.get(count - 1);
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return res.size() > count;
        }
    }
}


