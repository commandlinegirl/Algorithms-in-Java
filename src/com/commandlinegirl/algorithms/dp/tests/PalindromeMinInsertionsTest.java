package com.commandlinegirl.algorithms.dp.tests;

import com.commandlinegirl.algorithms.dp.PalindromeMinInsertions;
import org.junit.Assert;
import org.junit.Test;

public class PalindromeMinInsertionsTest {

    @Test
    public void testPalindromeMinInsertionsRec_ok1() {
        PalindromeMinInsertions e = new PalindromeMinInsertions();
        int res = e.insertsRec("ab", 0, 1);
        Assert.assertEquals(1, res);
    }

    @Test
    public void testPalindromeMinInsertionsRec_ok2() {
        PalindromeMinInsertions e = new PalindromeMinInsertions();
        int res = e.insertsRec("aba", 0, 2);
        Assert.assertEquals(0, res);
    }

    @Test
    public void testPalindromeMinInsertionsRec_ok3() {
        PalindromeMinInsertions e = new PalindromeMinInsertions();
        int res = e.insertsRec("abcd", 0, 3);
        Assert.assertEquals(3, res);
    }

    @Test
    public void testPalindromeMinInsertionsRec_ok4() {
        PalindromeMinInsertions e = new PalindromeMinInsertions();
        int res = e.insertsRec("abcda", 0, 4);
        Assert.assertEquals(2, res);
    }
}
