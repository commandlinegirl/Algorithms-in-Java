package com.commandlinegirl.algorithms.graphs;

import com.commandlinegirl.algorithms.datastructures.Graph.Vertex;

import java.util.Stack;

public class DepthFirstSearchRecursive {
    
    public static void visit(Vertex v) {
        System.out.println(v.getId());
    }
    
    public static void search(Vertex root) {
        if (root == null)
            return;
        visit(root);
        root.setVisited();
        for (Vertex v : root.getAdjacencies()) {
            if (!v.isVisited()) {
                search(v);
            }
        }

    }
}
