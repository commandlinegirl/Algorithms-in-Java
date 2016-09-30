package com.commandlinegirl.algorithms.datastructures;

public class LinkedList<T> {

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


    public static Node reverseRecursive2(Node start) {
        if (start == null || start.next == null)
            return start;

        Node previousEnd = reverseRecursive2(start.next);
        start.next.next = start;
        start.next = null;
        return previousEnd;
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
