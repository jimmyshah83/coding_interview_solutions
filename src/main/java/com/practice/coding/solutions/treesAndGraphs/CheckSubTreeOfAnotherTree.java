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

    public static void main(String[] args) {
	int[] sInt = new int[] {1,2,3,4,5};    
	TreeNode s = MinimalBSTree.buildMinimalTree(sInt, 0, sInt.length-1);
	
	int[] tInt = new int[] {1,2,4};    
	TreeNode t = MinimalBSTree.buildMinimalTree(tInt, 0, tInt.length-1);

	System.out.println(inOrderTraversal(s, new StringBuffer()).contains(inOrderTraversal(t, new StringBuffer())));
    }
    
    /**
     * Approach: InOrder-Traverse the tree to get all the elements and then check if t is subStirng of t
     */
    private static String inOrderTraversal(TreeNode node, StringBuffer inOrder) {
	if (node != null) {
	    inOrderTraversal(node.left,inOrder);
	    inOrder.append(node.getNodeValue());
	    inOrderTraversal(node.right,inOrder);
	}
	return inOrder.toString();
    }
}
