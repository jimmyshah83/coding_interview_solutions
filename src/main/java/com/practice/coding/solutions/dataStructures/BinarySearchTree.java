package com.practice.coding.solutions.dataStructures;

import com.practice.coding.solutions.treesAndGraphs.MinimalBSTree;

/**
 * Sample implementation for Binary Search tree with nodes and IN-Order,
 * Pre-Order and Post-Order traversal
 */
public class BinarySearchTree {

    private static final StringBuilder inOrder = new StringBuilder();
    private static final StringBuilder preOrder = new StringBuilder();
    private static final StringBuilder postOrder = new StringBuilder();

    /**
     * Example tree 6 2 10 4 8 20
     */
    public static void main(String[] args) {
	int[] input = new int[] {2,4,6,8,10,20};    
	TreeNode node = MinimalBSTree.buildMinimalTree(input, 0, input.length-1);

	System.out.println("In Order Traversal = " + inOrderTraversal(node));
	System.out.println("Pre Order Traversal = " + preOrderTraversal(node));
	System.out.println("Post Order Traversal = " + postOrderTraversal(node));
    }

    /**
     * In Order Traversal = 2,4,6,8,10,20
     */
    private static String inOrderTraversal(TreeNode node) {
	if (node != null) {
	    inOrderTraversal(node.left);
	    inOrder.append(node.getNodeValue() + ",");
	    inOrderTraversal(node.right);
	}
	return inOrder.toString();
    }

    /**
     * Pre Order Traversal = 6,2,4,10,8,20
     */
    private static String preOrderTraversal(TreeNode node) {
	if (node != null) {
	    preOrder.append(node.getNodeValue() + ",");
	    preOrderTraversal(node.left);
	    preOrderTraversal(node.right);
	}
	return preOrder.toString();
    }

    /**
     * Post Order Traversal = 4,2,8,20,10,6
     */
    private static String postOrderTraversal(TreeNode node) {
	if (node != null) {
	    postOrderTraversal(node.left);
	    postOrderTraversal(node.right);
	    postOrder.append(node.getNodeValue() + ",");
	}
	return postOrder.toString();
    }
}
