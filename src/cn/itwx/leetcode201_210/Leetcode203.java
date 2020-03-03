package cn.itwx.leetcode201_210;

import cn.itwx.source.ListNode;

public class Leetcode203 {

    public ListNode removeElements(ListNode head, int val) {

        ListNode yummy = new ListNode(-1);
        yummy.next = head;
        ListNode cur = yummy;

        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return yummy.next;
    }

    /**
     * 使用递归来进行处理（1.找到终止条件 2.这一步需要做什么 3.给这一步的返回值应该是什么）
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements2(head.next, val);
        return head.val == val ? head.next : head;
    }
}
