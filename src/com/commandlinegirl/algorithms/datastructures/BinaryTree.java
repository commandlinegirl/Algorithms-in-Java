package com.commandlinegirl.algorithms.datastructures;

public class BinaryTree {
    
    public static class Node {
        private final String name;
        private Node left;
        private Node right;
        // number of node levels from root
        private Integer height;
        
        public Node(String name) {
            this.name = name;
        }
        
        public String getName() {
            return name;
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

        public Integer getHeight() {
            return height;
        }
        
        public void setHeight(Integer height) {
            this.height = height;
        }
    }
}
