package com.commandlinegirl.algorithms.strings.test;

import com.commandlinegirl.algorithms.strings.RabinKarp;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class RabinKarpTest {

    @Test
    public void testSubstringSearch() {
        RabinKarp searcher = new RabinKarp();
        int index = searcher.searchPattern("internnet", "net");
        Assert.assertEquals(6, index);
    }
}
