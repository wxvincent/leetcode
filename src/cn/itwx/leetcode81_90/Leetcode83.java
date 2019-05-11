package cn.itwx.leetcode81_90;

import cn.itwx.source.ListNode;

public class Leetcode83 {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode pre = head;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            cur = cur.next;
            pre.next = cur;
            pre = cur;
        }

        return head;
    }
}
