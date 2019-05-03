package cn.itwx.leetcode21_30;

import cn.itwx.source.ListNode;

public class Leetcode23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeSort(lists, 0, lists.length - 1);
    }

    private ListNode mergeSort(ListNode[] lists, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            ListNode leftNode = mergeSort(lists, left, mid);
            ListNode rightNode = mergeSort(lists, mid + 1, right);
            return mergeTwo(leftNode, rightNode);
        }
        return lists[left];
    }

    private ListNode mergeTwo(ListNode leftNode, ListNode rightNode) {
        if (leftNode == null) return rightNode;
        if (rightNode == null) return leftNode;

        ListNode node = null;
        if (leftNode.val <= rightNode.val) {
            node = leftNode;
            node.next = mergeTwo(leftNode.next, rightNode);
        } else {
            node = rightNode;
            node.next = mergeTwo(leftNode, rightNode.next);
        }

        return node;
    }

}
