package com.commandlinegirl.algorithms.graphs.test;

import static org.junit.Assert.assertEquals;

import java.util.PriorityQueue;

import org.junit.Before;
import org.junit.Test;

import com.commandlinegirl.algorithms.datastructures.Graph.Edge;
import com.commandlinegirl.algorithms.datastructures.Graph.Vertex;
import com.commandlinegirl.algorithms.graphs.Kruskal;

public class TestKruskal {

    private PriorityQueue<Edge> edges = new PriorityQueue<>();
    private int vertexCount;
    
    @Before
    public void setupTest() {

        String[] edgesInput = new String[]{
                "0 1 5",
                "0 2 3",
                "3 0 6",
                "1 3 7",
                "2 1 4",
                "2 3 5"};
        vertexCount = 6;
        for (int j = 0; j < edgesInput.length; j++) {
            String in = edgesInput[j];
            String[] vals = in.split(" ");
            Vertex v1 = new Vertex(Integer.valueOf(vals[0]));
            Vertex v2 = new Vertex(Integer.valueOf(vals[1]));
            int weight = Integer.valueOf(vals[2]);
            edges.add(new Edge(v1, v2, weight));
        }
    }

    @Test
    public void testKruskal_array_ds() {
        assertEquals(Kruskal.getMstSumArray(edges, vertexCount), 12);
    }

}
