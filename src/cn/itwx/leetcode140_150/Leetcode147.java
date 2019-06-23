package cn.itwx.leetcode140_150;

import cn.itwx.source.ListNode;

public class Leetcode147 {

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0), pre;
        dummy.next = head;

        while (head != null && head.next != null) {//因为是链表，只有从前往后比
            if (head.val <= head.next.val) {
                head = head.next;
                continue;
            }
            pre = dummy;

            //用小于很舒服，不然的话，用小于等于还得往后走几个
            while (pre.next.val < head.next.val) pre = pre.next;

            ListNode curr = head.next;
            head.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
        }
        return dummy.next;
    }
}
