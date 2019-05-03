package cn.itwx.leetcode21_30;

import cn.itwx.source.ListNode;

public class Leetcode25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        // Write your code here

        if (k == 1)
            return head;
        if (head == null || head.next == null)
            return head;
        int kk = k;
        ListNode newHead = null;
        ListNode p = head;
        ListNode prev = null;
        ListNode pNext = null;
        int size = size(head);
        if (size < k)
            return head;
        while (k >= 1) {
            k--;
            pNext = p.next;
            if (k == 0) {
                newHead = p;
            }
            p.next = prev;
            prev = p;
            p = pNext;
        }
        ListNode lastNode = newHead;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        ListNode nextHead = reverseKGroup(pNext, kk);
        lastNode.next = nextHead;
        return newHead;

    }

    public int size(ListNode head) {
        int i = 0;
        while (head != null) {
            i++;
            head = head.next;
        }
        return i;
    }
}
