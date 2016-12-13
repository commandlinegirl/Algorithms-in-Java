package com.commandlinegirl.algorithms.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/max-non-negative-subarray/
 */
public class MaxNonnegativeSubarray {

    public List<Integer> maxset(List<Integer> a) {
        List<Integer> result = new ArrayList<>();

        int n = a.size();
        if (n == 0) {
            return result;
        }

        long tmp_sum = 0;
        long result_sum = 0;
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (a.get(i) < 0) {
                // compare tmp with result
                if (isTmpLarger(tmp_sum, result_sum, tmp, result)) {
                    result = new ArrayList<>(tmp);
                    result_sum = tmp_sum;
                }
                tmp_sum = 0;
                tmp.clear();
            } else {
                tmp.add(a.get(i));
                tmp_sum += a.get(i);
            }
        }
        if (isTmpLarger(tmp_sum, result_sum, tmp, result))
            result = new ArrayList<>(tmp);
        return result;
    }

    private boolean isTmpLarger(long tmp_sum, long result_sum, List<Integer> tmp, List<Integer> result) {
        return (tmp_sum > result_sum ||
                (tmp_sum == result_sum && tmp.size() > result.size()) ||
                (tmp_sum == result_sum && tmp.size() == result.size() && result.size() != 0 && tmp.get(0) < result.get(0)));
    }
}
