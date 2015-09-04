package com.commandlinegirl.algorithms.graphs;

import java.util.*;

/* Solution to the hackerrank problem of finding the length of the largest connected
 * region in the given matrix. It uses a deep first graph search. 
 * https://www.hackerrank.com/challenges/connected-cell-in-a-grid */
public class CellConnection {

    private static class Vertex {
        private Set<Vertex> adjacencies = new HashSet<>();
        private int id;
        private boolean visited = false;
        
        public Vertex(int id) {
            this.id = id;
        }
        
        public void addAdjacent(Vertex vertex) {
            adjacencies.add(vertex);
        }
        
        public void setVisited() {
            visited = true;
        }
        
        public boolean isVisited() {
            return visited;
        }        
    }
    
    private static int getLargestArea(Vertex[][] matrix, int m, int n) {
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Vertex v = matrix[i][j];
                if (!v.isVisited() && v.id == 1) {
                    int score = search(v, 0);
                    if (score > max) {
                        max = score;
                    }
                }
            }
        }
        return max;
    }
    
    private static int search(Vertex root, int score) {
        if (root == null) {
            return score;
        }
        root.setVisited();
        if (root.id == 1) {
            score++;
        }
        for (Vertex vertex : root.adjacencies) {
            if (!vertex.isVisited()) {
                vertex.setVisited();
                score = search(vertex, score);
            }
        }
        return score;
    }
    
    private static void addAdjacencies(Vertex[][] matrix, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Vertex v = matrix[i][j];
                for (int k = i - 1; k <= i + 1; k++) {
                    for (int r = j - 1; r <= j + 1; r++) {
                        if (!(k == i && r == j) && k >= 0 && k < m && r >= 0 && r < n) {
                            if (matrix[k][r].id == 1) {
                                v.addAdjacent(matrix[k][r]);
                            }
                        }
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        Vertex[][] matrix = new Vertex[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = new Vertex(in.nextInt());
            }
        }
        addAdjacencies(matrix, m, n);
        System.out.println(getLargestArea(matrix, m, n));
    }
}
