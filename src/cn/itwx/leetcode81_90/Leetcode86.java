package cn.itwx.leetcode81_90;

import cn.itwx.source.ListNode;

public class Leetcode86 {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode yummy1 = new ListNode(-1);
        ListNode cur1 = yummy1;

        ListNode yummy2 = new ListNode(-1);
        ListNode cur2 = yummy2;

        while (head != null) {
            if (head.val < x) {
                cur1.next = head;
                cur1 = cur1.next;
                head = head.next;
                cur1.next = null;
            } else {
                cur2.next = head;
                cur2 = cur2.next;
                head = head.next;
                cur2.next = null;
            }
        }

        cur1.next = yummy2.next;
        return yummy1.next;
    }
}
