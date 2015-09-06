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
    
    public static class Vertex {

        private Set<Vertex> adjacencies = new HashSet<>();
        private int id;
        private boolean visited = false;
        
        public Vertex(int id) {
            this.id = id;
        }
        
        public void addAdjacent(Vertex vertex) {
            adjacencies.add(vertex);
        }
        
        public Set<Vertex> getAdjacencies() {
            return Collections.unmodifiableSet(adjacencies);
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
    }
}
