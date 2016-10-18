package com.commandlinegirl.algorithms.datastructures;

public class LinkedList<T> {

    /***
     * Returns a head of the reversed linked list (iterative implementation).
     * @param start
     * @return
     */
    public static Node reverseIterative(Node start) {
        if (start == null)
            return null;

        Node current = start;
        Node prev = null, next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    /***
     * Returns a head of the reversed linked list (recursive implementation 1).
     * @param start
     * @return
     */
    public static Node reverseRecursive1(Node start) {
        return reverseRecursiveHelper(null, start);
    }

    private static Node reverseRecursiveHelper(Node parent, Node child) {
        if (child == null)
            return parent;

        Node next = child.next;
        child.next = parent;
        return reverseRecursiveHelper(child, next);
    }

    /***
     * Returns a head of the reversed linked list (recursive implementation 2).
     * @param start
     * @return
     */
    public static Node reverseRecursive2(Node start) {
        if (start == null || start.next == null)
            return start;

        Node previousEnd = reverseRecursive2(start.next);
        start.next.next = start;
        start.next = null;
        return previousEnd;
    }

    /***
     * Returns the middle node of a singly-linked list.
     * @param start
     * @return
     */
    public static Node middleNode(Node start) {
        if (start == null)
            return null;

        Node pointer = start;
        Node runner = start.next;

        while (runner != null && runner.next != null) {
            pointer = pointer.next;
            runner = runner.next.next;
        }

        return pointer;
    }

    /***
     * Determine whether a linked list contains a loop as quickly as possible without using any extra storage.
     * Also, identify the location of the loop.
     *
     * Source: http://www.algorist.com/algowiki/index.php/Data-structures-TADM2E
     * @param start
     * @return
     */
    public static Node loopNode(Node start) {
        return null;
    }

    public static class Node<T> {
        private Node next;
        private T data;

        public Node(T data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public T data() {
            return data;
        }
    }
}
