package com.commandlinegirl.algorithms.misc;

import java.util.Stack;

/* Implementation of a queue with two stacks */
public class QueueWithStacks<T> {

    private Stack<T> inbox = new Stack<T>();
    private Stack<T> outbox = new Stack<T>();

    private void inbox2outbox() {
        while (!inbox.isEmpty()) {
            outbox.push(inbox.pop());
        }
    }
    
    public T remove() {
        inbox2outbox();
        return outbox.pop();
    }
    
    public T peek() {
        inbox2outbox();
        return outbox.peek();
    }
    
    public void add(T item) {
        inbox.push(item);
    }
    
    public boolean isEmpty() {
        return inbox.isEmpty() && outbox.isEmpty();
    }
    
}

