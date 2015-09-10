package com.commandlinegirl.algorithms.misc.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.commandlinegirl.algorithms.misc.LambdaExpressions;
import com.commandlinegirl.algorithms.misc.LambdaExpressions.Country;

public class TestLambdaExpressions {
    
    @Test
    public void testPopulationCount() {
        Country a = new Country(10000, "Europe", "Monaco");
        Country b = new Country(40000, "Europe", "Austria");
        Country c = new Country(123456, "Asia", "Mongolia");
        List<Country> countries = new ArrayList<>();
        countries.add(a);
        countries.add(b);
        countries.add(c);
        int pop = LambdaExpressions.getContinentPopulation(countries, "Europe");
        assertEquals(pop, 50000);
    }
}
