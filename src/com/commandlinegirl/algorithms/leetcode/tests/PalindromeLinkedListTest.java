package com.commandlinegirl.algorithms.leetcode.tests;

import com.commandlinegirl.algorithms.leetcode.PalindromeLinkedList;
import com.commandlinegirl.algorithms.leetcode.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class PalindromeLinkedListTest {
    
    @Test
    public void testIsPalindrome() {
        ListNode n0, n1, n2, n3;
        n0 = new ListNode(0);
        n1 = new ListNode(1);
        n2 = new ListNode(2);
        n3 = new ListNode(3);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        PalindromeLinkedList e = new PalindromeLinkedList();
        boolean res = e.isPalindrome(n0);
        Assert.assertFalse(res);
    }

    @Test
    public void testIsPalindrome2() {
        ListNode n0, n1, n2;
        n0 = new ListNode(0);
        n1 = new ListNode(1);
        n2 = new ListNode(0);
        n0.next = n1;
        n1.next = n2;
        PalindromeLinkedList e = new PalindromeLinkedList();
        boolean res = e.isPalindrome(n0);
        Assert.assertTrue(res);
    }

}
