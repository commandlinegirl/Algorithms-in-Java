package com.commandlinegirl.algorithms.graphs;

import java.util.LinkedList;
import java.util.Queue;
import com.commandlinegirl.algorithms.datastructures.Graph.Vertex;

public class BreadthFirstSearch {
    
    public static void search(Vertex root) {
        if (root == null) {
            return;
        }
        Queue<Vertex> q = new LinkedList<>();
        q.add(root);
        visit(root);
        root.setVisited();
        while (!q.isEmpty()) {
            Vertex v = q.remove();
            for (Vertex u : v.getAdjacencies()) {
                if (!u.isVisited()) {
                    visit(u);
                    u.setVisited();
                    q.add(u);
                }
            }
        }
    }

    public static void visit(Vertex v) {
        System.out.println(v.getId());
    }
    
}
