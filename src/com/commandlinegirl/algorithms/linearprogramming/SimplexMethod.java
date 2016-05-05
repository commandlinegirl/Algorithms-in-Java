package com.commandlinegirl.algorithms.linearprogramming;


import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SimplexMethod {

    private static final Logger logger = Logger.getLogger(SimplexMethod.class.getName());

    private int getMinIndex(List<Integer> list) {
        int minIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < list.get(minIndex))
                minIndex = i;
        }
        return minIndex;
    }


    private int[][] getPivot(List<List<Integer>> tableau) {
        int pivotColumn =  getMinIndex(tableau.get(0));
        int pivotRow = getPivotRow(tableau, pivotColumn);
        return new int[][]{{pivotRow}, {pivotColumn}};
    }

    private int getPivotRow(List<List<Integer>> tableau, int pivotColumnIndex) {
        int minValue = 0;
        int minIndex = 0;
        List<Integer> valueColumn = getColumn(tableau, tableau.size() - 1);
        List<Integer> pivotColumn = getColumn(tableau, pivotColumnIndex);
        for (int i = 0; i < valueColumn.size(); i++) {
            if (pivotColumn.get(i) != 0 && valueColumn.get(i) / pivotColumn.get(i) < minValue) {
                minValue = valueColumn.get(i) / pivotColumn.get(i);
                minIndex = i;
            }
        }
        return minIndex;
    }

    private List<Integer> getColumn(List<List<Integer>> tableau, int columnIndex) {
        if (Preconditions.checkIndexNotWithinArray(tableau, columnIndex))
            throw new IllegalArgumentException("Invalid column index " + columnIndex + " for tableau " + tableau);
        return tableau.stream().map(e -> e.get(columnIndex)).collect(Collectors.toList());
    }

    private void maximize(List<List<Integer>> tableau) {
        int[][] pivot = getPivot(tableau);
    }

    public static void main(String... args) {
        if (args.length == 0) {
            logger.severe("Usage: java SimplexMethod <name-of_file>");
            System.exit(0);
        }

        SimplexMethod simplex = new SimplexMethod();
        InputReader freader = new InputReader();
        List<List<Integer>> tableau = freader.readInput(args[0]);
        simplex.maximize(tableau);

    }

}
