package com.commandlinegirl.algorithms.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/intersection-of-sorted-arrays/
 */
public class IntersectionOfTwoSortedArrays {

    public List<Integer> intersect(final List<Integer> a, final List<Integer> b) {
        int ia = 0;
        int ib = 0;
        List<Integer> ret = new ArrayList<>();
        while (ia < a.size() && ib < b.size()) {
            if (a.get(ia) < b.get(ib)) {
                ia++;
            }
            else if (a.get(ia) > b.get(ib)) {
                ib++;
            }
            else {
                ret.add(a.get(ia));
                ia++;
                ib++;
            }
        }
        return ret;
    }
}
