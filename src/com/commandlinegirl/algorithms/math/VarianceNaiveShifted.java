package com.commandlinegirl.algorithms.math;

import java.util.Collection;

/**
 * The naive algorithm for computing variance can lead to the so called catastrophic cancellation,
 * which means sumOfSquares(nums) and squareOfSum(nums) / n) can be so similar, their difference
 * will be less than floating-point arithmetic used to compute the variance.
 * To avoid that, we can use a property of the variance that it is invariant with respect to
 * changes in a location parameter and add a shift k to each value in the list. The closer the
 * shift is to the mean value the more accurate the result will be, but just choosing
 * a value inside the samples range will guarantee the desired stability.
 */
public class VarianceNaiveShifted {

    // value by which the variance will be shifted, which increases the stability of the algorithm.
    private double shift = 0.0;

    public VarianceNaiveShifted(double shift) {
        this.shift = shift;
    }

    public double variance(Collection<Integer> nums) {
        if (nums.isEmpty())
            throw new IllegalArgumentException("list cannot be empty");
        int n = nums.size();
        return (sumOfSquares(nums) - squareOfSum(nums) / n) / (n - 1);
    }

    private double squareOfSum(Collection<Integer> nums) {
        return power(nums.stream().map(i -> i - shift).mapToDouble(Double::doubleValue).sum());
    }

    private double sumOfSquares(Collection<Integer> nums) {
        return nums.stream().map(i -> power(i - shift)).mapToDouble(Double::doubleValue).sum();
    }

    public double stdDev(Collection<Integer> nums) {
        return Math.sqrt(variance(nums));
    }

    private double power(double x) {
        return x * x;
    }
}
