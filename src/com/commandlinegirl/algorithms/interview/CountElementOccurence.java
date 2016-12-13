package com.commandlinegirl.algorithms.interview;

import java.util.List;

/**
 * Given a sorted array of integers, find the number of occurrences of a given target value.
 */
public class CountElementOccurence {

        public int findCount(final List<Integer> a, int b) {
            int lo = 0;
            int hi = a.size() - 1;
            int result = 0;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (a.get(mid) < b) {
                    lo = mid + 1;
                } else if (a.get(mid) > b) {
                    hi = mid - 1;
                } else if (a.get(mid) == b) {
                    int i = mid;
                    int j = mid + 1;
                    while (i >= 0 && a.get(i) == b) {
                        result++;
                        i--;
                    }
                    while (j < a.size() && a.get(j) == b) {
                        result++;
                        j++;
                    }
                    return result;
                }
            }
            return 0;
        }
}
