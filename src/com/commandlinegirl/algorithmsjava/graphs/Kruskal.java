package com.commandlinegirl.algorithmsjava.graphs;

import java.util.*;

/* Kruskal algorithm implementation with the use of a disjoint set and a priorty queue.
 * It is a solution to hackerrank.com problem of finding the total weight of a minimum 
 * spanning tree within an undirected graph:
 * https://www.hackerrank.com/challenges/kruskalmstrsub
 */
public class Kruskal {

    private static class DisjointSet {
        private List<Integer> parent;
        private List<Integer> rank;
        
        public DisjointSet(int count) {
            parent = new ArrayList<>();
            rank = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                parent.add(i);
                rank.add(0);
            }
        }
        
        /* Finds a representative of the set */
        public int find(int i) {
            if (parent.get(i) == i) {
                return i;
            } else {
                int result = find(parent.get(i));
                parent.set(i, result);
                return result;
            }
        }
               
        
        /* Unites the set that includes i and the set that includes j */
        public void union(int i, int j) {
            int rep_i = find(i);
            int rep_j = find(j);
            int rank_i = rank.get(i);
            int rank_j = rank.get(j);
            
            if (rep_i == rep_j) {
                return;
            }
            if (rank_i < rank_j) {
                parent.set(rep_i, rep_j);
            } else if (rank_j < rank_i) {
                parent.set(rep_j, rep_i);
            } else {
                parent.set(rep_i, rep_j); // any join is ok
                rank.set(rep_j, rank_j++); 
            }
        }  
    }

    private static class Edge implements Comparable<Edge> {
    private int destination;
        private int source;
        private int weight;
        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
        @Override
        public int compareTo (Edge other) {
            return Integer.compare(weight, other.weight);
        }

    }
    
    private static int getMstSum(PriorityQueue<Edge> edges, int vertixCount) {
        int cost = 0;
        Set<Edge> mst = new HashSet<>();
        DisjointSet ds = new DisjointSet(vertixCount);
        while (!edges.isEmpty() && mst.size() != vertixCount - 1) {
            Edge minEdge = edges.poll();
            int u = minEdge.source;
            int v = minEdge.destination;
            if (ds.find(u) != ds.find(v)) {
                mst.add(minEdge);   
                ds.union(u, v);
            }
        }
        for (Edge e : mst) {
            cost += e.weight;
        }
        return cost;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);        
        int vertixCount = in.nextInt();
        int edgeCount = in.nextInt(); // edges
        PriorityQueue<Edge> edges = new PriorityQueue<>();
        for (int j = 0; j < edgeCount; j++) {
            int vertexA = in.nextInt() - 1;
            int vertexB = in.nextInt() - 1;
            int weight = in.nextInt();
            edges.add(new Edge(vertexA, vertexB, weight));
        }
        int start = in.nextInt(); // not used
        System.out.println(getMstSum(edges, vertixCount));
    }
}
