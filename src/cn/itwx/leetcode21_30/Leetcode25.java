package cn.itwx.leetcode21_30;

import cn.itwx.source.ListNode;

public class Leetcode25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        if (head == null || head.next == null) return head;
        int kk = k;
        ListNode newHead = null;
        ListNode p = head;
        ListNode prev = null;
        ListNode pNext = null;
        int size = size(head);
        if (size < k) return head;
        while (k >= 1) {//和反转链表类似
            k--;
            pNext = p.next;
            if (k == 0) newHead = p;
            p.next = prev;
            prev = p;
            p = pNext;
        }
        head.next = reverseKGroup(pNext, kk);
        return newHead;
    }

    public int size(ListNode head) {
        int i = 0;
        while (head != null) {
            head = head.next;
            i++;
        }
        return i;
    }
}
