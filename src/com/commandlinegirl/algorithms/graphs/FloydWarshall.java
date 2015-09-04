package com.commandlinegirl.algorithms.graphs;

import java.util.Scanner;

/* Solution to https://www.hackerrank.com/challenges/floyd-city-of-blinding-lights,
 * search for shortest paths between nodes, using Floyd Warshall algorithm. */
public class FloydWarshall {

    private static final Integer MAX_VALUE = 28000000;
   
    private static Integer[][] initializeDistances(Integer[][] weights, int vertices) {
        Integer[][] distances = new Integer[vertices][vertices];        
        for (int a = 0; a < vertices; a++) {
            for (int b = 0; b < vertices; b++) {
                if (a == b) {
                    distances[a][b] = 0;
                } else {
                    if (weights[a][b] != null) {
                        distances[a][b] = weights[a][b];
                    } else {
                        distances[a][b] = MAX_VALUE;
                    }
                }
                
            }
        }
        return distances;
    }

    private static Integer[][] shortestPaths(Integer[][] weights, int vertices) {
        Integer[][] distances = initializeDistances(weights, vertices);
        for (int k = 0; k < vertices; k++) {
             for(int i = 0; i < vertices; i++) {
                 for (int j = 0; j < vertices; j++) {
                     if(distances[i][k] + distances[k][j] < distances[i][j]) {
                         distances[i][j] = distances[i][k] + distances[k][j];
                     }
                 }
             }
        }
        return distances;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
            int vertices = in.nextInt(); 
            int edges = in.nextInt();         
            Integer[][] weights = new Integer[vertices][vertices];
            
            for (int i = 0; i < edges; i++) {
                int x = in.nextInt() - 1;
                int y = in.nextInt() - 1;
                int weight = in.nextInt();
                weights[x][y] = weight;
            }
        
            Integer[][] minDistances = shortestPaths(weights, vertices);
            
            // replace max with -1
            for (int x = 0; x < vertices; x++) {
                for (int y = 0; y < vertices; y++) {
                    if (minDistances[x][y].compareTo(MAX_VALUE) == 0) {
                        minDistances[x][y] = -1;
                    }
                }
            }
        
            int q = in.nextInt(); // queries count
            for (int j = 0; j < q; j++) {
                int id1 = in.nextInt() - 1;
                int id2 = in.nextInt() - 1;
                System.out.println(minDistances[id1][id2]);
            }
       
     }
}
