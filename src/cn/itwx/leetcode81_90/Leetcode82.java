package cn.itwx.leetcode81_90;

import cn.itwx.source.ListNode;

public class Leetcode82 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode yummy = new ListNode(-1);
        yummy.next = head;
        ListNode pre = yummy;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }

        return yummy.next;
    }
}
