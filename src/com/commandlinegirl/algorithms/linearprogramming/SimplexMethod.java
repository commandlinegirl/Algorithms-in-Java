package com.commandlinegirl.algorithms.linearprogramming;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SimplexMethod {

    private static Character DELIMINATOR = ',';

    private List<List<Integer>> readInput(String fileName, Character deliminator) {
        File file = new File(fileName);
        List<List<Integer>> input = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                List<Integer> equation = convertToInt(Arrays.asList(line.split(deliminator.toString())));
                input.add(equation);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    private List<Integer> convertToInt(List<String> strings) {
        return strings.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    public static void main(String... args) {

        SimplexMethod simplex = new SimplexMethod();

        System.out.println(args.length);
        if (args.length > 0) {
            for (List<Integer> li : simplex.readInput(args[0], DELIMINATOR)) {
                System.out.println(Arrays.toString(li.toArray()));
            }
        }

    }

}
