package com.commandlinegirl.algorithms.leetcode;

import java.util.Random;

/**
 * https://leetcode.com/problems/linked-list-random-node/
 * https://en.wikipedia.org/wiki/Reservoir_sampling
 * Time complexity of getRandom(): O(n)
 */
public class LinkedListRandomNode {

    private ListNode head;
    private Random random;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        random = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int val = head.val;
        int i = 2;
        ListNode l = head.next;
        while (l != null) {
            // with probability 1/i keep the new item (discard the old one)
            // with probability 1 - 1/i keep the old item (discard/ignore the new one
            if (random.nextInt(i++) == 0)
                val = l.val;
            l = l.next;
        }
        return val;
    }
}