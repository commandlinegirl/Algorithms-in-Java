package com.commandlinegirl.algorithms.sorting;

/* 
 * Insertion sort implementation. 
 */
public class Insertsort implements Sort {

    private void insertSort1(int[] ar) {
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

    private void insertSort2(int[] ar) {
        if (ar == null) {
            return;
        }

        for (int i = 1; i < ar.length; i++) {
            int j = i;
            while (j > 0 && ar[j - 1] > ar[j]) {
                swap(ar, i, j);
                j--;
            }
        }

    }

    private void swap(int[] ar, int i, int j) {
        int tmp = ar[i];
        ar[i] = ar[j];
        ar[j] = tmp;

    }

    @Override
    public void sort(int[] ar) {
        insertSort1(ar);
    }
}
