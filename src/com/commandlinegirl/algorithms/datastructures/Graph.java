package com.commandlinegirl.algorithms.datastructures;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Graph {

    private Vertex root;
    
    public Graph(Vertex root) {
        this.root = root;
    }
    
    public Vertex getRoot() {
        return root;
    }
    
    public static class Vertex implements Comparable<Vertex> {

        private final int id;
        private Set<Vertex> adjacencies = new HashSet<>();
        private Set<Edge> edges = new HashSet<>();
        private boolean visited = false;
        private int minDistance = Integer.MAX_VALUE;
        private Vertex previous;
        
        public Vertex(int id) {
            this.id = id;
        }
        
        public Set<Vertex> getAdjacencies() {
            return Collections.unmodifiableSet(adjacencies);
        }
        
        public void addAdjacent(Vertex vertex) {
            adjacencies.add(vertex);
        }
        
        public Set<Edge> getEdges() {
            return Collections.unmodifiableSet(edges);
        }
        
        public void setVisited() {
            visited = true;
        }
        
        public boolean isVisited() {
            return visited;
        }
        
        public int getId() {
            return id;
        }
        
        public Vertex getPrevious() {
            return previous;
        }

        @Override
        public int compareTo(Vertex other) {
            return Integer.compare(minDistance , other.minDistance);
        }

        public void setMinDistance(int i) {
            minDistance = 0;
        }
        
        public int getMinDistance() {
            return minDistance;
        }

        public void setPrevious(Vertex vertex) {
            previous = vertex;
            
        }
    }
    
    public static class Edge implements Comparable<Edge> {
        private final Vertex source;
        private final Vertex destination;
        private final int weight;
        
        public Edge(Vertex source, Vertex destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
        
        @Override
        public int compareTo (Edge other) {
            return Integer.compare(weight, other.weight);
        }

        public Vertex getSource() {
            return source;
        }

        public Vertex getDestination() {
            return destination;
        }

        public int getWeight() {
            return weight;
        }

    }
}
