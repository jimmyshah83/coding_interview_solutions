package com.practice.coding.solutions.dataStructures;

/**
 * A TreeNode which could be used to implement Binary Tree or Binary Search Tree.
 */
public class TreeNode {
	
	private final Object nodeValue;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(Object nodeValue) {
		this.nodeValue = nodeValue;
		this.left = null;
		this.right = null;
	}

	public Object getNodeValue() {
		return nodeValue;
	}
}
