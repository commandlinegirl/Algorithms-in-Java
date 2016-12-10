package com.commandlinegirl.algorithms.sorting;

import com.commandlinegirl.algorithms.utils.Printer;

/**
 * Implementation of bubble sort.
 * Time complexity: O(n2)
 * Memory complexity: O(1)
 */
public class Bubblesort implements Sort {

    @Override
    public void sort(int[] ar) {
        if (ar == null)
            return;

        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < ar.length - 1; i++) {
                if (ar[i] > ar[i + 1]) {
                    swap(ar, i, i + 1);
                    swapped = true;
                }
            }
        }
    }

    private void swap(int[] ar, int i, int j) {
        int tmp = ar[i];
        ar[i] = ar[j];
        ar[j] = tmp;
    }
}
