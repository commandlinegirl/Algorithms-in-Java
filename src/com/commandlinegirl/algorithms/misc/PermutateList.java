package com.commandlinegirl.algorithms.misc;

import java.util.ArrayList;
import java.util.List;

public class PermutateList<T> {

    public List<List<T>> permutate(List<T> input) {
        if (input == null)
            return new ArrayList<>();

        List<List<T>> result = new ArrayList<>();

        if (input.isEmpty()) {
            result.add(new ArrayList<>());
            return result;
        }

        for (T i : input) {
            List<T> reducedList = new ArrayList<>(input);
            reducedList.remove(i);
            List<List<T>> perms = permutate(reducedList);

            for (List<T> p : perms) {
                p.add(i);
                result.add(p);
            }
        }

        return result;
    }

}
