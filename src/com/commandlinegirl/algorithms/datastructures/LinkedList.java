package com.commandlinegirl.algorithms.datastructures;

public class LinkedList<T> {

    public static Node reverse(Node start) {
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
