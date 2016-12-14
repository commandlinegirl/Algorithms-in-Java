package com.commandlinegirl.algorithms.interview;

import java.util.List;

/**
 * https://www.interviewbit.com/problems/min-steps-in-infinite-grid/
 */
public class MinStepsInInfiniteGrid {

    // X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
    public int coverPoints(List<Integer> X, List<Integer> Y) {
        // iterate over all coordinate points
        int steps = 0;
        for (int i = 0; i < X.size() - 1; i++) {
            steps += Math.max(Math.abs(X.get(i) - X.get(i + 1)), Math.abs(Y.get(i) - Y.get(i + 1)));
        }
        return steps;
    }
}
