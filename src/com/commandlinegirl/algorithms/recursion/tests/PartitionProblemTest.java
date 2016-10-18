package com.commandlinegirl.algorithms.recursion.tests;

import com.commandlinegirl.algorithms.recursion.PartitionProblem;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kereish on 17.10.16.
 */
public class PartitionProblemTest {

    @Test
    public void testPartitionProblem_true() {
        PartitionProblem pp = new PartitionProblem();
        int[] s = {3, 1, 1, 2, 2, 1};
        Assert.assertTrue(pp.partition(s));
    }

    @Test
    public void testPartitionProblem_false() {
        PartitionProblem pp = new PartitionProblem();
        int[] s = {3, 1};
        Assert.assertFalse(pp.partition(s));
    }
}
