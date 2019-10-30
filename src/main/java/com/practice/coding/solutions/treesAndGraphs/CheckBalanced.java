package com.practice.coding.solutions.treesAndGraphs;

import com.practice.coding.solutions.dataStructures.TreeNode;

/**
 * Cracking the coding interview 4.4
 * 
 * Check Balanced: implement a function to check if a binary tree is balanced.
 * For the purposes of this question, a balanced tree is defined to be a tree
 * such that the heights of the two subtrees of any node never differ by more
 * than one.
 *
 */
public class CheckBalanced {

    public static void main(String[] args) {
	int[] arr = new int[] { 10, 2, 1, 7, 4, 9, 8, 6 };
	TreeNode root = MinimalBSTree.buildMinimalTree(arr, 0, arr.length - 1);
	System.out.println(checkBalanced(root));
    }

    private static boolean checkBalanced(TreeNode n) {
	if (balancedHeight(n) > -1)
	    return true;
	return false;
    }

    private static int balancedHeight(TreeNode n) {
	if (n == null)
	    return 0;
	int h1 = balancedHeight(n.left);
	int h2 = balancedHeight(n.right);

	if (h1 == -1 || h2 == -1)
	    return -1;
	if (Math.abs(h1 - h2) > 1)
	    return -1;
	if (h1 > h2)
	    return h1 + 1;
	return h2 + 1;
    }
}
