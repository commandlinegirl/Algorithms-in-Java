package com.commandlinegirl.algorithms.searching;

/**
 * 4-33. Suppose that you are given a sorted sequence of distinct integers {a1,a2,…,an}.
 * Give an O(lgn) algorithm to determine whether there exists an i index such as ai=i.
 * For example, in {−10,−3,3,5,7}, a3=3. In {2,3,4,5,6,7}, there is no such i.
 * Source: http://www.algorist.com/algowiki/index.php/Sorting-searching-TADM2E
 */
public class IndexElement {

    public boolean isEqualToIndex(int[] ar) {
        if (ar == null)
            throw new IllegalArgumentException("null array");

        int lo = 0;
        int hi = ar.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (ar[mid] == mid) {
                return true;
            }
            else if (mid > ar[mid]) {
                lo = mid + 1;
            }
            else {
                return false;
            }
        }

        return false;
    }
}
