package com.commandlinegirl.algorithms.dp.tests;

import com.commandlinegirl.algorithms.dp.PathsInMatrix;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PathsInMatrixTest {

    @Test
    public void testCost1() {
        PathsInMatrix e = new PathsInMatrix();
        int res = e.count(2, 2);
        Assert.assertEquals(6, res);
    }

    @Test
    public void testCost2() {
        PathsInMatrix e = new PathsInMatrix();
        int res = e.count(10, 20);
        Assert.assertEquals(30045015, res);
    }

    @Test
    public void testPrint1() {
        PathsInMatrix e = new PathsInMatrix();
        List<List<Integer>> res =  e.print(new int[][]{ {1, 2, 3}, {4, 5, 6} }, 1, 2);
        Assert.assertEquals(Arrays.asList(Arrays.asList(1, 2, 3, 6), Arrays.asList(1, 2, 5, 6), Arrays.asList(1, 4 ,5, 6)), res);
    }

    @Test
    public void testPrint2() {
        PathsInMatrix e = new PathsInMatrix();
        List<List<Integer>> res =  e.print(new int[][]{ {1, 2, 3}, {4, 5, 6} }, 1, 1);
        Assert.assertEquals(Arrays.asList(Arrays.asList(1, 2, 5), Arrays.asList(1, 4, 5)), res);
    }

}
