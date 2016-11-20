package com.commandlinegirl.algorithms.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 */
public class LinkedListCycleII {

        public ListNode detectCycle(ListNode head) {
            if (head == null)
                return null;

            ListNode f = head;
            ListNode s = head;

            while (f != null && f.next != null) {
                s = s.next;
                f = f.next.next;
                if (f == s) {
                    s = head;
                    while (f != s) {
                        s = s.next;
                        f = f.next;
                    }
                    return f;
                }
            }
            return null;
        }
}
