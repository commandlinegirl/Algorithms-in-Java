package com.commandlinegirl.algorithms.leetcode;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class KthSmallestElementBst {

    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return -1;
        return kthSmallest(root, k, 0);
    }

    /**
     * TODO: Not passed yet!
     * @param root
     * @param k
     * @param i
     * @return
     */
    public int kthSmallest(TreeNode root, int k, int i) {
        if (root == null)
            return -1;
        int kth = kthSmallest(root.left, k, i);
        if (kth > 0)
            return kth;
        i += 1;
        if (k == i)
            return root.val;

        kth = kthSmallest(root.right, k, i);
        if (kth > 0)
            return kth;
        return -1;
    }
}


//	if(tree==NULL) return tree;
//
//            node *left=k_smallest_elementUtil(tree->left,k,count);
//            if(left) return left;
//
//            count++;
//            if(count==k)  return tree;
//
//            node* right=k_smallest_elementUtil(tree->right,k,count);
//            if(right) return right;
//
//            return NULL;