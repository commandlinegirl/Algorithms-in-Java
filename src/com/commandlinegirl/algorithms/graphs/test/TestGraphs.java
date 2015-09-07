package com.commandlinegirl.algorithms.graphs.test;


import static org.junit.Assert.*;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

import com.commandlinegirl.algorithms.datastructures.Graph.Edge;
import com.commandlinegirl.algorithms.datastructures.Graph.Vertex;
import com.commandlinegirl.algorithms.graphs.Dijkstra;

public class TestGraphs {

    Map<Integer, Vertex> vertices;
    
    @Before
    public void setupTest() {

        String[] edges = new String[]{
                "1 2 24",
                "1 4 20",
                "3 1 3",
                "4 3 12"};
        int edgeCount = edges.length;
        vertices = initializeNodes(4);
        for (int j = 0; j < edgeCount; j++) {
            String in = edges[j];
            String[] vals = in.split(" ");
            Vertex v1 = vertices.get(Integer.valueOf(vals[0]));
            Vertex v2 = vertices.get(Integer.valueOf(vals[1]));
            int weight = Integer.valueOf(vals[2]);
            Edge a = new Edge(v1, v2, weight);
            Edge b = new Edge(v2, v1, weight);
            v1.addEdge(a);  
            v2.addEdge(b);
        }
    }

    @Test
    public void testDijkstra() {
        Vertex startNode = vertices.get(1);
        Dijkstra.search(startNode);
        assertEquals(getMinDistance(vertices, 2), 24);
        assertEquals(getMinDistance(vertices, 3), 3);
        assertEquals(getMinDistance(vertices, 4), 15);
    }
    
    
    private Map<Integer, Vertex> initializeNodes(int m) {
        Map<Integer, Vertex> vertices = new TreeMap<>();
        for (int i = 1; i <= m; i++) {
            Vertex node = new Vertex(i);
            vertices.put(i, node);
        }
        return vertices;
    }
    
    private int getMinDistance(Map<Integer, Vertex> vertices, int id) {
        if (vertices == null) {
            throw new IllegalArgumentException("Vertices argument is null.");
        }
        
        Vertex v = vertices.get(id);
        if (v == null) {
            throw new IllegalArgumentException("Vertex with id " + id +" does not found.");
        }
        
        return v.getMinDistance();
    }
}
