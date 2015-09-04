package com.commandlinegirl.algorithms.sorting;

/* 
 * Insertion sort implementation. 
 */
public class Insertsort implements Sort {

    private void insertSort(int[] ar) {
        if (ar == null) {
            return;
        }

        for (int i = 0; i < ar.length; i++) {
            int x = ar[i]; 
            int j = i;
            while (j > 0 && ar[j - 1] > x) {
                ar[j] = ar[j - 1];
                j--;
            }
            ar[j] = x;
        }
    }

    @Override
    public void sort(int[] ar) {
        insertSort(ar);
    }
}
