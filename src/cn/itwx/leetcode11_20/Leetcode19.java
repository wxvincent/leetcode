package cn.itwx.leetcode11_20;

import cn.itwx.source.ListNode;

public class Leetcode19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        ListNode pre = head;
        ListNode cur = head;
        while (n > 0) {
            pre = pre.next;
            if (pre == null) return head.next;
            n--;
        }

        while (pre.next != null) {
            pre = pre.next;
            cur = cur.next;
        }

        cur.next = cur.next.next;
        return head;
    }
}
