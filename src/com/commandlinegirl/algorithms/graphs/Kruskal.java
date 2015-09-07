package com.commandlinegirl.algorithms.graphs;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import com.commandlinegirl.algorithms.datastructures.DisjointSet;
import com.commandlinegirl.algorithms.datastructures.Graph.Edge;

/* Kruskal algorithm implementation with the use of a disjoint set and a priority queue.
 * It finds the total weight of a Minimum Spanning Tree (MST) within an undirected graph.
 */
public class Kruskal {

    public static int getMstSum(PriorityQueue<Edge> edges, int vertexCount) {
        int cost = 0;
        Set<Edge> mst = new HashSet<>();
        DisjointSet ds = new DisjointSet(vertexCount);
        while (!edges.isEmpty() && mst.size() != vertexCount - 1) {
            Edge minEdge = edges.poll();
            int u = minEdge.getSource().getId();
            int v = minEdge.getDestination().getId();
            if (ds.find(u) != ds.find(v)) {
                mst.add(minEdge);   
                ds.union(u, v);
            }
        }
        for (Edge e : mst) {
            cost += e.getWeight();
        }
        return cost;
    }
}
