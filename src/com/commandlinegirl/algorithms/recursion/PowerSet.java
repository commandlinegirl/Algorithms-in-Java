package com.commandlinegirl.algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Cracking the Coding Interview, 6th Edition
Problem 8.4 Power Set
*/
class PowerSet {

    private static List<List<Integer>> subsets(List<List<Integer>> result, List<Integer> pool) {
        if (pool.size() == 0) {
            result.add(new ArrayList<>());
            return result;
        }

        List<List<Integer>> resultClone = new ArrayList<>();
        for (List<Integer> li : result)
            resultClone.add(new ArrayList<>(li));

        Integer curr = pool.get(0);
        for (List<Integer> li : result)
            li.add(curr);
        result.addAll(resultClone);

        List<Integer> currList = new ArrayList<>();
        currList.add(curr);
        result.add(currList);

        pool.remove(curr);
        return subsets(result, pool);
    }

    public static List<List<Integer>> getSubsets(List<List<Integer>> result, List<Integer> pool) {
        return subsets(result, new ArrayList<>(pool));
    }

    public static void main(String... args) {
        List<Integer> li = Arrays.asList(1, 2, 3, 4);

        List<List<Integer>> out = getSubsets(new ArrayList<>(), li);

        for (List<Integer> l : out) {
            System.out.println(Arrays.toString(l.toArray()));
        }    
    }    
}    
