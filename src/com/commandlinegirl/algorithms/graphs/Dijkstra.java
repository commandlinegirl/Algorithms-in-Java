package com.commandlinegirl.algorithms.graphs;

import java.util.Map;
import java.util.PriorityQueue;

import com.commandlinegirl.algorithms.datastructures.Graph.Edge;
import com.commandlinegirl.algorithms.datastructures.Graph.Vertex;

/* Dijkstra algorithm implementation for finding the minimum distance
 * for a reference vertex to all other vertices. */
public class Dijkstra {

    /* Main algorithm */ 
    public static void search(Vertex start) {
        if (start == null) {
            return;
        }
        
        start.setMinDistance(0);
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Vertex u = queue.poll();
            for (Edge e : u.getEdges()) {
                Vertex v = e.getDestination();
                int weight = e.getWeight();
                int distanceViaU = u.getMinDistance() + weight;
                if (distanceViaU < v.getMinDistance()) {
                    queue.remove(v); 
                    v.setMinDistance(distanceViaU);
                    v.setPrevious(u);
                    queue.add(v); 
                } 
            }
        }
    }

    public static void printDistances(Map<Integer, Vertex> nodes, int start) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Vertex> entry : nodes.entrySet()) {
            if (entry.getKey() != start) {
                Vertex node = entry.getValue();
                Integer dist = node.getMinDistance() == Integer.MAX_VALUE ? -1 : node.getMinDistance();
                sb.append(dist).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }
       
}
