package com.commandlinegirl.algorithms.implementations;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

/* Implementation of a list of stacks, each with a given capacity */
public class ListOfStacks<T> {

    private List<Stack<T>> listOfStacks = new ArrayList<>();
    private Stack<T> lastStack;
    private int lastStackCount = 0;
    private int capacity = 1000;

    public ListOfStacks(int capacity) {
        this.capacity = capacity;
    }
    
    public void push(T item) {
        if (listOfStacks.isEmpty() || lastStackCount == capacity) {
            lastStack = new Stack<T>();
            listOfStacks.add(lastStack);
            lastStackCount = 0;
        } 
        lastStack.push(item);
        lastStackCount++;
    }

    public T pop() {
        T returnedData = lastStack.pop();
        lastStackCount--;
        if (lastStack.isEmpty()) {
            listOfStacks.remove(lastStack);
            if (listOfStacks.size() > 0) {
                lastStack = listOfStacks.get(listOfStacks.size() - 1);
            }
        }
        return returnedData;
    }
    
    public T peek() {
        return lastStack.peek();
    }

    public T peekAt(int index) {
        if (index >= listOfStacks.size()) {
            throw new EmptyStackException();
        }
        return listOfStacks.get(index).peek();
    }
    
    public boolean isEmpty() {
        return listOfStacks.isEmpty();
    }
    
    public int size() {
        return listOfStacks.size();
    }
    
}

