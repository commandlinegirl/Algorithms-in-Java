package com.commandlinegirl.algorithms.datastructures;

public class BinaryTree {
    
    public static class Node {
        private final String name;
        private Node left;
        private Node right;
        
        public Node(String name) {
            this.name = name;
        }
        
        public Node getLeft() {
            return left;
        }
        
        public void setLeft(Node left) {
            this.left = left;
        }
        
        public Node getRight() {
            return right;
        }
        
        public void setRight(Node right) {
            this.right = right;
        }
        
        public String getName() {
            return name;
        }

    }
}
