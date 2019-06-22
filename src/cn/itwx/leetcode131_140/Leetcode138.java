package cn.itwx.leetcode131_140;

import cn.itwx.source.ComplexListNode;

public class Leetcode138 {

    /**
     * 在每个节点后面新复制一个节点
     *
     * @param head
     */
    public void cloneNodes(ComplexListNode head) {
        ComplexListNode node = head;
        while (node != null) {
            ComplexListNode clone = new ComplexListNode();
            clone.val = node.val;
            clone.next = node.next;
            node.next = clone;
            node = clone.next;
        }
    }

    /**
     * 将每个复制的节点的sibling连接上
     *
     * @param head
     */
    public void connectSiblingNodes(ComplexListNode head) {
        ComplexListNode node = head;
        while (node != null) {
            ComplexListNode clone = node.next;
            if (node.sibling != null) {
                clone.sibling = node.sibling.next;
            }
            node = clone.next;
        }
    }

    /**
     * 将两个链表拆分
     *
     * @param head
     * @return
     */
    public ComplexListNode reconnectNodes(ComplexListNode head) {
        ComplexListNode node = head;
        ComplexListNode cloneHead = null;
        ComplexListNode cloneNode = null;

        if (node != null) {
            cloneHead = cloneNode = node.next;
            node.next = cloneNode.next;
            node = node.next;
        }

        while (node != null) {
            cloneNode.next = node.next;
            cloneNode = cloneNode.next;
            node.next = cloneNode.next;
            node = node.next;
        }

        return cloneHead;
    }

    public ComplexListNode clone(ComplexListNode head) {
        cloneNodes(head);
        connectSiblingNodes(head);
        return reconnectNodes(head);
    }

}


