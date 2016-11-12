package com.commandlinegirl.algorithms.leetcode;

import java.util.*;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * https://leetcode.com/problems/binary-tree-paths/
 */
public class BinaryTreePaths {

    /**
     * Recursive solution using string concatenation for building a path. This
     * is costly - str m and n concatenation time complexity is O(m + n);
     * Time complexity: O(n^2) worst, O(nlogn) for a balanced tree
     * Memory complexity: O(n^2) worst, O(nlogn) for a balanced tree.
     * @param root
     * @return
     */
    public List<String> binaryTreePathsRec1(TreeNode root) {
        List<String> paths = new ArrayList<>();
        binaryTreePathsHelp1(root, paths, "");
        return paths;
    }

    private void binaryTreePathsHelp1(TreeNode root, List<String> paths, String path) {
        if (root == null)
            return;

        String curPath = path.isEmpty() ? String.valueOf(root.val) : path + "->" + root.val;

        if (root.left == null && root.right == null) {
            paths.add(curPath);
        }
        else {
            binaryTreePathsHelp1(root.right, paths, curPath);
            binaryTreePathsHelp1(root.left, paths, curPath);
        }
    }

    /////////////////////////////////////////////////////////////////////////////

    /**
     * Recursive solution using a string builder for building a path.
     * String builder's append is O(1) amortized time.
     * Time complexity: O(n) worst, O(logn) for a balanced tree
     * Memory complexity: O(n) worst, O(logn) for a balanced tree
     * @param
     * @return
     */
    public List<String> binaryTreePathsRec2(TreeNode root) {
        List<String> paths = new ArrayList<>();
        binaryTreePathsHelp2(root, paths, new StringBuilder());
        return paths;
    }

    private void binaryTreePathsHelp2(TreeNode root, List<String> paths, StringBuilder sb) {
        if (root == null)
            return;

        int len = sb.length();
        if(sb.length() != 0)
            sb.append("->");
        sb.append(root.val);

        if (root.left == null && root.right == null) {
            paths.add(sb.toString());
        }
        else {
            binaryTreePathsHelp2(root.right, paths, sb);
            binaryTreePathsHelp2(root.left, paths, sb);
        }
        sb.setLength(len);
    }

    /////////////////////////////////////////////////////////////////////////////

    /**
     * Solution using a stack to solve the problem iteratively.
     * Time complexity: O(n)
     * Memory complexity: O(h) where h is the height of the tree.
     * @param root
     * @return
     */
    public List<String> binaryTreePathsStack1(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null)
            return paths;
        Stack<TreeNode> s = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();

        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        s.add(root);
        while (!s.isEmpty()) {
            TreeNode tn = s.peek();
            if (tn.left == null && tn.right == null) {
                // or print stack
                paths.add(stringify(path));
                s.pop();
                path.remove(path.size() - 1);
            }
            else if (tn.right != null && !visited.contains(tn.right)) {
                path.add(tn.right.val);
                s.push(tn.right);
                visited.add(tn.right);
            }
            else if (tn.left != null && !visited.contains(tn.left)) {
                path.add(tn.left.val);
                s.push(tn.left);
                visited.add(tn.left);
            }
            else {
                s.pop();
                path.remove(path.size() - 1);
            }
        }
        return paths;
    }

    private String stringify( List<Integer> li) {
        StringBuilder sb = new StringBuilder();
        for (int i : li) {
            if (sb.length() != 0)
                sb.append("->");
            sb.append(i);
        }
        return sb.toString();
    }

    /////////////////////////////////////////////////////////////////////////////

    /**
     * @param root
     * @return
     */
    public List<String> binaryTreePathsStack2(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null)
            return paths;
        String path = new String();

        Stack<TreeNode> s = new Stack<>();
        Stack<String> pathStack = new Stack<>();
        TreeNode p = root;

        while(p!=null || !s.isEmpty()) {
            if (p != null) {
                if (p == root)
                    path = Integer.toString(p.val);
                else
                    path = path+"->"+Integer.toString(p.val);

                if (p.left == null && p.right == null)
                    paths.add(path);
                pathStack.push(path);
                s.push(p);
                p = p.left;
            }
            else {
                TreeNode node = s.pop();
                p = node.right;
                path = pathStack.pop();
            }
        }

        return paths;
    }

    /////////////////////////////////////////////////////////////////////////////

    /**
     * Solution using a simple dfs algorithm.
     * This solution has a quadratic time complexity since for every recursive call (O(n)) the array
     * is copied (O(n)). The complexity then is O(n^2).
     * @param root
     */
    public List<List<Integer>> binaryTreePathsRecDfs(TreeNode root) {
        List<List<Integer>> paths = new ArrayList<>();
        dfs(root, paths, new ArrayList<>());
        return paths;
    }

    private void dfs(TreeNode root, List<List<Integer>> list, List<Integer> curr) {
        curr.add(root.val);

        if (root.left == null && root.right == null) {
            list.add(curr);
            return;
        }

        if (root.left != null)
            dfs(root.left, list, new ArrayList<>(curr));
        if (root.right != null)
            dfs(root.right, list, new ArrayList<>(curr));
    }
}
