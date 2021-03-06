package cn.itwx.leetcode151_160;

import cn.itwx.source.ListNode;

public class Leetcode160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        // 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头,
        // 而第二轮体现在如果pA或pB相交就返回交点, 不相交最后就是null==null
        while (pA != pB) {
            //这里其实把最后一个null也当成了链表的一个节点，不过两个指针都要经过，也就不在意了
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
