package com.commandlinegirl.algorithms.interview;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePrintLeaves {

    public List<Integer> dfs(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(result, root);
        return result;
    }

    private void helper(List<Integer> result, TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            result.add(root.val);
        }
        else if (root.left != null) {
            dfs(root.left);
        }
        else {
            dfs(root.right);
        }
    }

    public static class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode(int x) { val = x; }
    }
}
