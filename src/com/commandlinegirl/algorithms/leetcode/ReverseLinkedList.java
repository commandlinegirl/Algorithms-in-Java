package com.commandlinegirl.algorithms.leetcode;

/**
 *  https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        return reverseList(null, head);
    }

    private ListNode reverseList(ListNode parent, ListNode head) {
        if (head == null)
            return parent;

        ListNode next = head.next;
        head.next = parent;
        return reverseList(head, next);
    }
}
