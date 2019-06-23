package cn.itwx.leetcode140_150;

import cn.itwx.source.ListNode;

import java.util.LinkedList;

public class Leetcode143 {

    public void reorderList1(ListNode head) {//一种是使用双端队列的，会改变链表
        LinkedList<ListNode> queue = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            queue.addLast(cur);
            cur = cur.next;
        }
        while (!queue.isEmpty()) {
            if (cur == null) {
                cur = queue.pollFirst();
            } else {
                cur.next = queue.pollFirst();
                cur = cur.next;
            }
            cur.next = queue.pollLast();
            cur = cur.next;
        }
        if (cur != null) {//最后一个节点如果是从后面取的，会形成循环链表（此时cur不为null）
            cur.next = null;
        }
    }

    public void reorderList2(ListNode head) {//一种是快慢指针法，分成两个队列（后队列反转），然后再逐个插入
        if (head == null) return;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode newhead = slow.next;
        slow.next = null; // head--->slow 第一个链，newhead--->fast 第二个链
        // 将第二个链反转
        ListNode prev = null, curr = newhead;
        while (curr != null) {
            ListNode tempNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNode;
        }
        curr = head;
        while (curr != null && prev != null) {//这种方法就不会导致循环链表
            ListNode tempNode1 = curr.next;
            ListNode tempNode2 = prev.next;
            curr.next = prev;
            curr = tempNode1;
            prev.next = tempNode1;
            prev = tempNode2;
        }
    }
}
