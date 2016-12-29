package com.commandlinegirl.algorithms.datastructures;

import java.util.Arrays;

/* Simple min heap implementation in Java */
public class MinHeap {

    private int capacity;
    private int size = 0;
    private int[] arr;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
    }

    public int peek() {
        if (size == 0)
            throw new IllegalArgumentException();
        return arr[0];
    }

    public int pop() {
        if (size == 0)
            throw new IllegalArgumentException();
        int val = arr[0];
        arr[0] = arr[size - 1];
        size--;
        heapifyDown(0);
        return val;
    }

    public void add(int val) {
        ensureCapacity();
        arr[size++] = val;
        heapifyUp(size - 1);
    }

    private void ensureCapacity() {
        if (size == capacity) {
            Arrays.copyOf(arr, capacity * 2);
            capacity *= 2;
        }
    }

    private void heapifyDown(int ind) {
        int min = ind;
        if (hasLeft(ind) && arr[ind] > arr[left(ind)]) {
            min = left(ind);
        }
        if (hasRight(ind) && arr[right(ind)] < arr[min]) {
            min = right(ind);
        }
        if (min != ind) {
            swap(min, ind);
            heapifyDown(min);
        }
    }

    private void heapifyUp(int ind) {
        if (hasParent(ind) && arr[parent(ind)] > arr[ind]) {
            swap(ind, parent(ind));
            heapifyUp(parent(ind));
        }
    }

    private void swap(int s, int ind) {
        int tmp = arr[s];
        arr[s] = arr[ind];
        arr[ind] = tmp;
    }

    private int left(int index) {
        return (index * 2) + 1;
    }

    private int right(int index) {
        return (index * 2) + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private boolean hasLeft(int index) {
        return left(index) < size;
    }

    private boolean hasRight(int index) {
        return right(index) < size;
    }

    private boolean hasParent(int index) {
        return parent(index) >= size;
    }
}
