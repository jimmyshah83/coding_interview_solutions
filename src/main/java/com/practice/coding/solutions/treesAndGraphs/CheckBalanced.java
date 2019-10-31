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
//	Recursively get the left subtree height of every node
	int leftH = balancedHeight(n.left);
//	Recursively get the right subtree height of every node
	int rightH = balancedHeight(n.right);

//	If at any point the subtree length is > 1 then it is not balanced
	if (Math.abs(leftH - rightH) > 1)
	    return -1;
	
//	Return the subtree height that is greater than the other
	if (leftH > rightH)
	    return leftH + 1;
	return rightH + 1;
    }
}
