package com.commandlinegirl.algorithms.misc.test;

import com.commandlinegirl.algorithms.misc.PermutateList;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestPermutateList {

    @Test
    public void testPermutate() {
        PermutateList p = new PermutateList();
        List<List> result = p.permutate(Arrays.asList(1,2,3));
        System.out.printf(result.toString());
    }
}
