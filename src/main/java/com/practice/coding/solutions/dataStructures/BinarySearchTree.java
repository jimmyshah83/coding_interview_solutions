package com.practice.coding.solutions.dataStructures;

/**
 * Sample implementation for Binary Search tree with nodes and IN-Order,
 * Pre-Order and Post-Order traversal
 */
public class BinarySearchTree {

    private static final StringBuilder inOrder = new StringBuilder();
    private static final StringBuilder preOrder = new StringBuilder();
    private static final StringBuilder postOrder = new StringBuilder();

    /**
     * Example tree 8 4 10 2 6 20
     */
    public static void main(String[] args) {
//		Create the tree first using the Node class
	TreeNode node = new TreeNode(8);

//		root node's children
	node.left = new TreeNode(4);
	node.right = new TreeNode(10);

//		Root's left child's children 
	node.left.left = new TreeNode(2);
	node.left.right = new TreeNode(6);

//		Root node's right child's children
	node.right.right = new TreeNode(20);

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
     * Pre Order Traversal = 8,4,2,6,10,20
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
     * Post Order Traversal = 2,6,4,20,10,8
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
