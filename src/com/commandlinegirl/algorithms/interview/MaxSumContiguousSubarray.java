package com.commandlinegirl.algorithms.interview;

import java.util.List;

/**
 * https://www.interviewbit.com/problems/max-sum-contiguous-subarray/
 */
public class MaxSumContiguousSubarray {

    public int maxSubArray(final List<Integer> a) {
        int max = a.get(0);
        int max_ending_here = a.get(0);
        for (int i = 1; i < a.size(); i++) {
            max_ending_here = Math.max(a.get(i), max_ending_here + a.get(i));
            max = Math.max(max_ending_here, max);
        }
        return max;
    }
}
