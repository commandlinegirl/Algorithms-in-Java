package com.commandlinegirl.algorithms.leetcode;

/**
 * Node definition for singly-linked list.
 */
public class ListNode {
     public int val;
     public ListNode next;

     public ListNode(int x) {
         val = x;
     }

    public static void printLinedList(ListNode head) {
        if (head == null)
            return;
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println("");
    }
}
