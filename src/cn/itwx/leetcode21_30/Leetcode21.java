package cn.itwx.leetcode21_30;

import cn.itwx.source.ListNode;

public class Leetcode21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode node = null;
        if (l1.val <= l2.val) {
            node = l1;
            node.next = merge(l1.next, l2);
        } else {
            node = l2;
            node.next = merge(l1, l2.next);
        }
        return node;
    }
}
