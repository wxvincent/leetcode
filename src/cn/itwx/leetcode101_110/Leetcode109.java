package cn.itwx.leetcode101_110;

import cn.itwx.source.ListNode;
import cn.itwx.source.TreeNode;

public class Leetcode109 {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode cur = slow.next;
        TreeNode node = new TreeNode(cur.val);
        slow.next = null;//这一步很关键
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(cur.next);

        return node;
    }
}
