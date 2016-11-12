package com.commandlinegirl.algorithms.leetcode;

/**
 * Remove all elements from a linked list of integers that have value val.
 * https://leetcode.com/problems/remove-linked-list-elements/
 */
public class RemoveLinkedListElements {

    /**
     * Time complexity: O(n)
     * Space: O(1)
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            if (current.val == val) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
            }
            else {
                prev = current;
            }
            current = current.next;
        }
        return head;
    }

    /**
     * Using a dummy prev (head) to simplify the code.
     * Time complexity: O(n)
     * Space: O(1)
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode current = head;
        ListNode ret = prev;

        while (current != null) {
            if (current.val == val)
                prev.next = current.next;
            else
                prev = current;
            current = current.next;
        }
        return ret.next;
    }
}
