package com.commandlinegirl.algorithms.hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/count-luck
 */
public class CountLuck {

    private static class Vertex {
        private Set<Vertex> adjacencies = new HashSet<>();
        private char id;
        private boolean visited = false;
        private int turnCount = 0;

        public Vertex(char id) {
            this.id = id;
        }

        void addAdjacent(Vertex vertex) {
            adjacencies.add(vertex);
        }

        void setVisited() {
            visited = true;
        }

        boolean isVisited() {
            return visited;
        }

        int getNotVisited() {
            int notVisited = 0;
            for (Vertex adj : adjacencies) {
                if (!adj.visited) {
                    notVisited++;
                }
            }
            return notVisited;
        }
    }

    private static boolean isWalkSuccessful(Vertex start, int k) {
        if (start == null) {
            return false;
        }
        Stack<Vertex> stack = new Stack<>();
        start.setVisited();
        stack.push(start);
        while (!stack.isEmpty()) {
            Vertex v = stack.pop();
            if (v.id == '*') {
                return v.turnCount == k;
            }
            if (v.getNotVisited() > 1) {
                v.turnCount++;
            }
            for (Vertex n : v.adjacencies) {
                if (!n.isVisited()) {
                    n.turnCount = v.turnCount;
                    n.setVisited();
                    stack.push(n);
                }
            }

        }
        return false;
    }

    private static void addAdjacencies(Vertex[][] matrix, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Vertex v = matrix[i][j];
                if (i != 0 && matrix[i-1][j].id != 'X')
                    v.addAdjacent(matrix[i-1][j]);
                if (i < m - 1 && matrix[i+1][j].id != 'X')
                    v.addAdjacent(matrix[i+1][j]);
                if (j != 0 && matrix[i][j-1].id != 'X')
                    v.addAdjacent(matrix[i][j-1]);
                if (j < n - 1 && matrix[i][j+1].id != 'X')
                    v.addAdjacent(matrix[i][j+1]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for (int t = 0; t < cases; t++) {
            int m = in.nextInt();
            int n = in.nextInt();
            Vertex[][] matrix = new Vertex[m][n];
            Vertex start = null;
            for (int i = 0; i < m; i++) {
                String row = in.next();
                for (int j = 0; j < n; j++) {
                    char c = row.charAt(j);
                    matrix[i][j] = new Vertex(c);
                    if (c == 'M') {
                        start = matrix[i][j];
                    }
                }
            }
            int k = in.nextInt();
            addAdjacencies(matrix, m, n);
            if (isWalkSuccessful(start, k)) {
                System.out.println("Impressed");
            } else {
                System.out.println("Oops!");
            }
        }
        in.close();
    }
}
