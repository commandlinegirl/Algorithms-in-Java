package com.commandlinegirl.algorithms.hackerrank;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

/*
 * Solution to the hackerrank.com problem: 
 * https://www.hackerrank.com/challenges/cut-the-tree
 * which requires to print the minimum difference between
 * the total weight of the trees (sum of vertices weight)
 * that result from 'cutting' the intput tree into two
 * by removing one of its edges.
 * 
 * It uses DFS to obtain the total sum of subtrees within
 * the tree.
 *
 * The average and worst runtime of the algorithm is O(n).
 */

public class TreeSum {

    private static class Vertex  {
        private int id;
        private int weight;
        private int sumWithChildren;
        private boolean visited = false;
        private List<Vertex> adjacencies = new ArrayList<>();

        public Vertex(int id, int weight) { 
            this.id = id; 
            this.weight = weight; 
        }

        public void addAdjacent(Vertex vertex) { 
            adjacencies.add(vertex); 
        }

        public List<Vertex> getAdjacencies() { 
            return Collections.unmodifiableList(adjacencies); 
        }

        public void setVisited() { 
            visited = true; 
        }

        public boolean isVisited() { 
            return visited; 
        }
    }
   
    /*
     * Main algorithm (DFS).
     */
    private static int search(Vertex root) {
        if (root == null) {
            return 0;
        }
        int sumWithChildren = root.weight;
        root.setVisited();
        for (Vertex vertex : root.getAdjacencies()) {
            if (!vertex.isVisited()) {
                vertex.setVisited();
                sumWithChildren += search(vertex);
            }
        }
        root.sumWithChildren = sumWithChildren;
        return root.sumWithChildren;
    }
    
    private static int getMinTreeDiff(List<Vertex> vertices) {
        if (vertices == null || vertices.size() == 0) {
            return 0;
        }
        int minDiff = Integer.MAX_VALUE;
        int total = vertices.get(0).sumWithChildren;
        for (Vertex v : vertices) {
            int current_diff = Math.abs(total - 2 * v.sumWithChildren);
            if (current_diff < minDiff) {
                minDiff = current_diff;
            }
        }
        return minDiff;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int vertexCount = in.nextInt();
        List<Vertex> vertices = new ArrayList<>(vertexCount);
        for (int i = 0; i < vertexCount; i++) {
            vertices.add(new Vertex(i, in.nextInt()));
        }
        
        for (int j = 0; j < vertexCount - 1; j++) {
            // Subtract 1 for the purpose of using 0-index based array.
            int vertexAId = in.nextInt() - 1;
            int vertexBId = in.nextInt() - 1;
            Vertex vertexA = vertices.get(vertexAId);
            Vertex vertexB = vertices.get(vertexBId);
            vertexA.addAdjacent(vertexB);
            vertexB.addAdjacent(vertexA);
        }
        search(vertices.get(0));
        System.out.println(getMinTreeDiff(vertices));
    }
}
