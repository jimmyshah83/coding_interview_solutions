package com.practice.coding.solutions.treesAndGraphs;

import com.practice.coding.solutions.dataStructures.TreeNode;

/**
 * Subtree of Another Tree
 * 
 * Given two non-empty binary trees s and t, check whether tree t has exactly
 * the same structure and node values with a subtree of s. A subtree of s is a
 * tree consists of a node in s and all of this node's descendants. The tree s
 * could also be considered as a subtree of itself.
 *
 */
public class CheckSubTreeOfAnotherTree {
    
    /**
     * Approach: InOrder-Traverse the tree to get all the elements and then check if t is subStirng of t
     */
    public static String inOrderTraversal(TreeNode node, StringBuffer inOrder) {
	if (node != null) {
	    inOrderTraversal(node.left,inOrder);
	    inOrder.append(node.getNodeValue());
	    inOrderTraversal(node.right,inOrder);
	}
	return inOrder.toString();
    }
}
