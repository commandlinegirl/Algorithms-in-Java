package com.commandlinegirl.algorithms.misc;

import java.util.List;
import java.util.stream.Stream;

/* Lambda expressions tests */
public class LambdaExpressions {

    public static class Country {
        // public for simplicity
        final public String name; 
        final public int population;
        final public String continent;
        
        public Country(int population, String continent, String name) {
            this.population = population;
            this.continent = continent;
            this.name = name;
        }
    }
    
    /*
     * Returns the total population of a given continent.
     */
    public static int getContinentPopulation(List<Country> countries, String continent) {
        Stream<Integer> continentCountries = countries
                .stream()
                .filter(u -> u.continent.equals(continent))
                .map(u -> u.population);
        return continentCountries.reduce(0, (total, s) -> total + s);
    }

}
