package com.practice.coding.solutions.dataStructures;

/**
 * A TreeNode which is used to implement Binary Tree
 */
public class TreeNode {

    public Object nodeValue;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Object nodeValue) {
	this.nodeValue = nodeValue;
	this.left = null;
	this.right = null;
    }

    public Object getNodeValue() {
	return nodeValue;
    }

    @Override
    public String toString() {
	return "TreeNode [nodeValue=" + nodeValue + ", left=" + left + ", right=" + right + "]";
    }
}
