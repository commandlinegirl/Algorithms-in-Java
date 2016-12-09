package com.commandlinegirl.algorithms.leetcode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode tmp = head;
        ListNode runner = null;
        while (tmp != null) {
            runner = tmp.next;
            while (runner != null && tmp.val == runner.val) {
                runner = runner.next;
            }
            tmp.next = runner;
            tmp = tmp.next;
        }
        return head;
    }
}
