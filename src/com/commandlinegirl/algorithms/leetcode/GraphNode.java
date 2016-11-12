package com.commandlinegirl.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Util definition for a binary tree node.
 */
public class GraphNode {

    public int val;
    public boolean visited;
    public boolean completed;
    public List<GraphNode> adjacencies = new ArrayList<>();
    public GraphNode(int x) { val = x; }

    public void addAdjacency(GraphNode g) {
        adjacencies.add(g);
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
