package com.commandlinegirl.algorithms.leetcode;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {

    /**
     * Using fast and slow pointer get to the middle and
     * while reversing the left side, compare elements from the
     * right side.
     * Time complexity: O(n)
     * Space: O(1)
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;

        ListNode fast = head;
        ListNode slow = head;
        int num = 0;

        while (fast != null) {
            fast = fast.next;
            num++;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
                num++;
            }
        }
        System.out.println(slow.val);
        System.out.println(num);

        ListNode reversedHead;
        if (num % 2 == 0)
            reversedHead = slow;
        else
            reversedHead = slow.next;

        ListNode reversed = reverse(reversedHead);
        while (reversed != null) {
            if (reversed.val != head.val)
                return false;
            head = head.next;
            reversed = reversed.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head == null)
            return null;
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode tmp = current.next;
            current.next = prev;
            prev = current;
            current = tmp;
        }
        return prev;
    }


}
