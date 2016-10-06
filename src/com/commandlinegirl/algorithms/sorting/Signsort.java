package com.commandlinegirl.algorithms.sorting;

/**
 * Give an efficient algorithm to rearrange an array of n keys so that all
 * the negative keys precede all the nonnegative keys. Your algorithm must
 * be in-place, meaning you cannot allocate another array to temporarily
 * hold the items. How fast is your algorithm?
 * Source: http://www.algorist.com/algowiki/index.php/Sorting-searching-TADM2E
 */
public class Signsort implements Sort {

    private void swap(int[] ar, int i, int j) {
        if (ar == null || i >= ar.length || j >= ar.length)
            throw new IllegalArgumentException();
        int tmp = ar[i];
        ar[i] = ar[j];
        ar[j] = tmp;
    }

    private void partition(int[] ar) {
        int i = 0; // division index between negative and positive elements
        for (int j = 0; j < ar.length; j++) {
            if (ar[j] < 0) {
                swap(ar, i, j);
                i++;
            }
        }
    }

    @Override
    public void sort(int[] ar) {
        partition(ar);
    }
}

