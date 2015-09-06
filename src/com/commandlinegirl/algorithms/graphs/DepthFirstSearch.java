package com.commandlinegirl.algorithms.graphs;

import java.util.Stack;
import com.commandlinegirl.algorithms.datastructures.Graph.Vertex;

public class DepthFirstSearch {
    
    public static void visit(Vertex v) {
        System.out.println(v.getId());
    }
    
    public static void search(Vertex root) {
        Stack<Vertex> stack = new Stack<Vertex>();
        visit(root);
        root.setVisited();
        stack.push(root);
        while(!stack.isEmpty()) {
            Vertex r = stack.pop();
            for (Vertex n : r.getAdjacencies()) {
                if (!n.isVisited()) {
                    n.setVisited();
                    visit(n);
                    stack.add(n);
                }
            }
        }
    }
}
