package cn.itwx.leetcode91_100;

import cn.itwx.source.ListNode;

public class Leetcode92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) return head;

        ListNode yummy = new ListNode(-1);
        yummy.next = head;
        ListNode pre = yummy;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        for (int i = 0; i < n - m; i++) {
            cur = cur.next;
        }

        ListNode lastNode = cur.next;
        cur = pre.next;

        ListNode preNode = null;
        while (cur.next != lastNode) {
            ListNode temp = cur.next;
            cur.next = preNode;
            preNode = cur;
            cur = temp;
        }
        cur.next = preNode;
        pre.next.next = lastNode;
        pre.next = cur;

        return yummy.next;
    }

    /**
     *
     * 实现思路 ：以1->2->3->4->5, m = 2, n=4 为例:
     *
     * 定位到要反转部分的头节点 2，head = 2；前驱结点 1，pre = 1；
     * 当前节点的下一个节点3调整为前驱节点的下一个节点 1->3->2->4->5,
     * 当前结点仍为2， 前驱结点依然是1，重复上一步操作。。。
     * 1->4->3->2->5.
     *
     * public ListNode reverseBetween(ListNode head, int m, int n) {
     *         ListNode dummy = new ListNode(0);
     *         dummy.next = head;
     *         ListNode pre = dummy;
     *         for(int i = 1; i < m; i++){
     *             pre = pre.next;
     *         }
     *         head = pre.next;
     *         for(int i = m; i < n; i++){
     *             ListNode nex = head.next;
     *             head.next = nex.next;
     *             nex.next = pre.next;
     *             pre.next = nex;
     *         }
     *         return dummy.next;
     *     }
     */
}
