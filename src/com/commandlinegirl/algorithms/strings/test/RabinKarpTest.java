package com.commandlinegirl.algorithms.interview.test;

import com.commandlinegirl.algorithms.interview.SubstringSearch;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class SubstringSearchTest {

    @Test
    public void testSubstringSearchRK() {
        SubstringSearch searcher = new SubstringSearch();
        int index = searcher.strStrRabinKarp("internnet", "net");
        Assert.assertEquals(6, index);
    }

    @Test
    public void testSubstringSearchNaive() {
        SubstringSearch searcher = new SubstringSearch();
        int index = searcher.strStrNaive("internnet", "net");
        Assert.assertEquals(6, index);
    }
}
