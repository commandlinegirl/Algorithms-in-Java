package com.commandlinegirl.algorithms.math;

import java.util.LinkedList;

/**
 * Algorithms for computing moving averages.
 */
public class AverageMoving {

    private double currentAvg;
    private final int windowSize; // sliding window size for computing moving average
    private int currentSize; // current sample size
    private LinkedList<Integer> li = new LinkedList<>();

    public AverageMoving(int windowSize) {
        if (windowSize == 0)
            throw new IllegalArgumentException("windowSize must be positive integer");
        this.windowSize = windowSize;
    }

    /**
     * Returns next average of a sliding window of samples from the list.
     */
    public double nextAverage(int val) {
        if (li.size() < windowSize)
            currentAvg = cumulativeMovingAverage(val);
        else
            currentAvg = simpleMovingAverage(val);
        return currentAvg;
    }

    /**
     * Avg(n + 1) = Avg(n) + val(n+1)/n - val(n-windowSize)
     */
    public double simpleMovingAverage(int val) {
        int prevVal = li.poll();
        li.offer(val);
        return currentAvg + (double) (val - prevVal) / windowSize;
    }

    /**
     * Avg(n + 1) = Avg(n) + (x(n + 1) - Avg(n)) / n + 1
     */
    public double cumulativeMovingAverage(int val) {
        li.offer(val);
        currentSize++;
        return currentAvg + (val - currentAvg) / currentSize;
    }
}
