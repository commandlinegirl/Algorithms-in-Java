package com.commandlinegirl.algorithms.graphs;

import java.util.Stack;
import com.commandlinegirl.algorithms.datastructures.Graph.Vertex;

public class DepthFirstSearchIterative {
    
    public static void visit(Vertex v) {
        System.out.println(v.getId());
    }
    
    public static void search(Vertex root) {
        if (root == null)
            return;
        Stack<Vertex> s = new Stack<>();
        s.push(root);
        while (!s.empty()) {
            Vertex x = s.pop();
            visit(x);
            for (Vertex y : x.getAdjacencies()) {
                if (!y.isVisited()) {
                    y.setVisited();
                    s.push(y);
                }
            }
        }
    }
}
