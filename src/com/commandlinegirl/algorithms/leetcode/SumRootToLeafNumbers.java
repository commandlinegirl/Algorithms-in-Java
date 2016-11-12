package com.commandlinegirl.algorithms.leetcode;

import java.util.*;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
public class SumRootToLeafNumbers {

    /**
     * Recursive solution using preorder traversal and storing digits in a list.
     * Time complexity: O(n)
     * Memory complexity: O(nlogn) for a balanced tree, O(n) for a tree
     * where all parents have only 1 child.
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {

        List<Integer> nums = new ArrayList<>();
        digitsPaths(root, nums, new StringBuilder());
        int result = 0;
        for (Integer li : nums) {
            result += li;
        }
        return result;
    }

    private void digitsPaths(TreeNode root, List<Integer> nums, StringBuilder sb) {
        if (root == null)
            return;

        int len = sb.length();
        sb.append(root.val);

        if (root.left == null && root.right == null) {
            nums.add(Integer.valueOf(sb.toString()));
        } else {
            digitsPaths(root.left, nums, sb);
            digitsPaths(root.right, nums, sb);
        }
        sb.setLength(len);
    }

    ////////////////////////////////////////////////////////////////////////////

    /**
     * Recursive solution using dfs.
     * Time complexity:
     * Memory complexity:
     * @param root
     * @return
     */
    private int sumNumbersDfsRecursiveHelp(TreeNode root, int tmp) {
        if(root == null)
            return 0;

        tmp = tmp * 10 + root.val;
        if (root.left == null && root.right == null)
            return tmp;

        return sumNumbersDfsRecursiveHelp(root.left, tmp) +
                sumNumbersDfsRecursiveHelp(root.right, tmp);
    }

    public int sumNumbersDfsRecursive(TreeNode root) {
        if (root == null)
            return 0;
        return sumNumbersDfsRecursiveHelp(root, 0);
    }

    ////////////////////////////////////////////////////////////////////////////

    /**
     * Iterative solution using dfs.
     * Time complexity:
     * Memory complexity:
     * @param root
     * @return
     */
    public int sumNumbersDfsIterative(TreeNode root) {
        int ret = 0;
        if (root == null)
            return ret;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.empty()) {

        }

        return ret;
    }

    /**
     * Iterative solution using bfs.
     * Time complexity: O(n)
     * Memory complexity: O(n)
     * @param root
     * @return
     */
    public int sumNumbersBfsIterative(TreeNode root) {
        int sum = 0;
        if (root == null)
            return sum;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode n = q.remove();
            if (n.left == null && n.right == null)
                sum += n.val;
            if (n.left != null) {
                n.left.val += n.val * 10;
                q.add(n.left);
            }
            if (n.right != null) {
                n.right.val += n.val * 10;
                q.add(n.right);
            }
        }
        return sum;
    }


}
