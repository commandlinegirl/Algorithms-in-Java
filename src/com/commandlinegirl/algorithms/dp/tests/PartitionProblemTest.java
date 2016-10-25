package com.commandlinegirl.algorithms.dp.tests;

import com.commandlinegirl.algorithms.dp.PartitionProblem;
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

    @Test
    public void testPartitionProblem2_true() {
        PartitionProblem pp = new PartitionProblem();
        int[] s = {1, 5, 11, 5};
        Assert.assertTrue(pp.partition(s));
    }

    @Test
    public void testPartitionProblemRec_true() {
        PartitionProblem pp = new PartitionProblem();
        int[] s = {3, 1, 1, 2, 2, 1};
        Assert.assertTrue(pp.partitionRec(s));
    }

    @Test
    public void testPartitionProblemRec_false() {
        PartitionProblem pp = new PartitionProblem();
        int[] s = {3, 1};
        Assert.assertFalse(pp.partitionRec(s));
    }

    @Test
    public void testPartitionProblemRec2_true() {
        PartitionProblem pp = new PartitionProblem();
        int[] s = {1, 5, 11, 5};
        Assert.assertFalse(pp.partitionRec(s));
    }

}
