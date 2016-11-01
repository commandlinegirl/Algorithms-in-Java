package com.commandlinegirl.algorithms.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/even-tree
 */
public class EvenTree {

    private static class TreeNode {
        private List<TreeNode> children = new ArrayList<>();
        private boolean removed = false;
        private int allChildrenCount = 0;
        private int id;
        public TreeNode(int id) { this.id = id; }
        public void addChild(TreeNode child) { children.add(child); }
        public void setRemoved() { removed = true; };
        public boolean isRemoved() { return removed;} ;

    }

    private static List<TreeNode> initializeNodes(int nodeCount) {
        List<TreeNode> nodes = new ArrayList<>();
        for (int i = 0; i <= nodeCount; i++) {
            TreeNode node = new TreeNode(i+1);
            nodes.add(node);
        }
        return nodes;
    }

    private static int countAllChildren(TreeNode root, int count) {
        if (root == null) {
            return 0;
        }
        for (TreeNode child: root.children) {
            count++;
            count = countAllChildren(child, count);
        }
        return count;
    }

    private static int getSum(TreeNode root, int cutCount) {
        if (root == null) {
            return cutCount;
        }
        for (TreeNode child : root.children) {
            if (!child.isRemoved()) {
                int allChildrenCount = countAllChildren(child, 0);
                if (allChildrenCount % 2 != 0) {
                    child.setRemoved();
                    cutCount++;
                }
                cutCount = getSum(child, cutCount);
            }
        }
        return cutCount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nodeCount = in.nextInt();
        int edgeCount = in.nextInt();
        List<TreeNode> nodes = initializeNodes(nodeCount);
        for (int j = 0; j < edgeCount; j++) {
            // Subtract 1 for the purpose of using 0-index based array.
            int childId = in.nextInt() - 1;
            int parentId = in.nextInt() - 1;
            TreeNode child = nodes.get(childId);
            TreeNode parent = nodes.get(parentId);
            parent.addChild(child);
        }
        System.out.println(getSum(nodes.get(0), 0));
    }
}
