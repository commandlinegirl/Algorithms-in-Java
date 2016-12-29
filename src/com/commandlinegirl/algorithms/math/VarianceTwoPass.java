package com.commandlinegirl.algorithms.math;

import java.util.Collection;

/**
 * The algorithm first computes the sample mean and then of the sum of the squares of the differences from the mean.
 * It is numerically stable if n is small. Due to repeated roundoff error in the accumulation of the sums, it can give
 * a poor result for large datasets. This can be reduced using techniques such as Kahan summation algorithm.
 */
public class VarianceTwoPass {

    public double variance(Collection<Integer> nums) {
        if (nums.isEmpty())
            throw new IllegalArgumentException("list cannot be empty");
        double meanVal = mean(nums);
        double sum_square_diff = nums.stream().map(i -> power(i - meanVal)).mapToDouble(Double::doubleValue).sum();
        return sum_square_diff / (nums.size() - 1);
    }

    public double stdDev(Collection<Integer> nums) {
        return Math.sqrt(variance(nums));
    }

    private double mean(Collection<Integer> nums) {
        if (nums.isEmpty())
            throw new IllegalArgumentException("list cannot be empty");
        return nums.stream().mapToInt(Integer::intValue).sum() / nums.size();
    }

    private double power(double x) {
        return x * x;
    }

}
