package cn.itwx.leetcode61_70;

import cn.itwx.source.ListNode;

public class Leetcode61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            len++;
        }

        k %= len;
        if (k == 0) return head;

        ListNode pre = head;
        ListNode post = head;

        for (int i = 0; i < k; i++) {
            pre = pre.next;
        }

        while (pre.next != null) {
            pre = pre.next;
            post = post.next;
        }

        ListNode temp = post.next;
        post.next = null;
        pre.next = head;
        return temp;
    }
}
