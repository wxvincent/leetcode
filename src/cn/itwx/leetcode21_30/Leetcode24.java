package cn.itwx.leetcode21_30;

import cn.itwx.source.ListNode;

public class Leetcode24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;

        return next;
    }
}
