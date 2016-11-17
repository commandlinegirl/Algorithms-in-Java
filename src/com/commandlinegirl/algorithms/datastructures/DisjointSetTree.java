package com.commandlinegirl.algorithms.datastructures;

/* Simple disjoint set implementation using trees.
 * It uses additional rank heuristic to optimize the union of two trees. A smaller tree is attached to
 * the root of the larger tree so that the depth of the tree is as low as possible.
 */
public class DisjointSetTree {

    /* Creates a node of the set */
    public Node createNode(int i) {
        Node n = new Node();
        n.parent = n;
        n.rank = 0;
        n.id = i;
        return n;
    }

    /* Finds a representative/root of the tree */
    public Node find(Node n) {
        if (n.parent.id == n.id) {
            return n.parent;
        }
        n.parent = find(n.parent); // path compression optimization
        return n.parent;
    }

    /* Unites the tree that includes i and the tree that includes j */
    public void union(Node i, Node j) {
        Node rep_i = find(i);
        Node rep_j = find(j);

        if (rep_i.id == rep_j.id) {
            return;
        }
        // the parent will be the node with a higher rank
        if (rep_i.rank >= rep_j.rank) {
            rep_j.parent = rep_i;
            if (rep_i.rank == rep_j.rank)
                rep_j.rank++;
        }
        else {
            rep_i.parent = rep_j;
        }
    }

    public static class Node {
        public int rank; // stores the approximate depth of the tree
        public int id;
        public Node parent;
    }
}
