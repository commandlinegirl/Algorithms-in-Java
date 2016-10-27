package com.commandlinegirl.algorithms.leetcode;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBst {

    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelp(root, null, null);
    }

    public boolean isValidBSTHelp(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;

        if (min != null && root.val <= min || max != null && root.val >= max)
            return false;

        return isValidBSTHelp(root.left, min, root.val) && isValidBSTHelp(root.right, root.val, max);
    }

}
