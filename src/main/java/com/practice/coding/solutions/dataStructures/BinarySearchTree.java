package com.practice.coding.solutions.dataStructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Binary Search Tree implementation using {@link TreeNode} It implements the
 * add, delete and search functionality
 * 
 * InOrder, PreOrder and PostOrder are used to Traverse a tree. Also known as
 * Depth First Traversals
 */
public class BinarySearchTree {

    private TreeNode root;

    /* 
     * Worst case: O(n): Go through all elements of a Binary tree
     * 		OR O(h): Where h s the height of the BST
     * Average case: O(log n)
     */
    private TreeNode add(TreeNode currentNode, int value) {
	if (null == currentNode)
	    return new TreeNode(value);
//	Giving left the priority would make this a complete binary tree as well
	if (value < (int) currentNode.nodeValue)
	    currentNode.left = add(currentNode.left, value);
	else
	    currentNode.right = add(currentNode.right, value);
	return currentNode;
    }

    public void add(int value) {
	root = add(root, value);
    }

    /**
     * Cracking the coding interview 4.2
     * 
     * Minimal Tree: Given a sorted (increasing order) array with unique integer
     * elements, write an algorithm to create a binary search tree with minimal
     * height.
     */
    public TreeNode buildBST(int[] input, int start, int end) {
	if (start > end)
	    return null;
	int mid = (start + end) / 2;
	TreeNode node = new TreeNode(input[mid]);
	node.left = buildBST(input, start, mid - 1);
	node.right = buildBST(input, mid + 1, end);
	return node;
    }

    /* 
     * Worst case: O(n): Go through all elements of a Binary tree
     * 		OR O(h): Where h s the height of the BST
     * Average case: O(log n)
     */
    private boolean search(TreeNode currentNode, int value) {
	if (null == currentNode)
	    return false;
	if (value == (int) currentNode.nodeValue)
	    return true;
	return value < (int) currentNode.nodeValue ? search(currentNode.left, value) : search(currentNode.right, value);
    }

    /* 
     * Worst case: O(n): Go through all elements of a Binary tree
     * 		OR O(h): Where h s the height of the BST
     * Average case: O(log n)
     */
    public boolean search(int value) {
	return search(root, value);
    }

    private int findSmallest(TreeNode currentNode) {
	return currentNode.left == null ? (int) currentNode.nodeValue : findSmallest(currentNode.left);
    }

    /* 
     * Worst case: O(n): Go through all elements of a Binary tree
     * 		OR O(h): Where h s the height of the BST
     * Average case: O(log n)
     */
    private TreeNode delete(TreeNode currentNode, int value) {
	if ((int) currentNode.nodeValue == value) {
//	    Case 1: When the node is a leaf Node
	    if (currentNode.left == null && currentNode.right == null)
		return null;

//	    Case 2: when node has 1 child node
	    if (currentNode.left == null)
		return currentNode.right;
	    if (currentNode.right == null)
		return currentNode.left;

//	    Case 3: when node as 2 children
	    int smallestValue = findSmallest(currentNode.right);
	    currentNode.nodeValue = smallestValue;
	    currentNode.right = delete(currentNode.right, smallestValue);
	    return currentNode;
	}
	if (value < (int) currentNode.nodeValue) {
	    currentNode.left = delete(currentNode.left, value);
	    return currentNode;
	} else {
	    currentNode.right = delete(currentNode.right, value);
	    return currentNode;
	}
    }

    public void delete(int value) {
	root = delete(root, value);
    }

    /*
     * O(n): Where n is the number of nodes in the BST
     */
    public void inOrderTraversal(TreeNode currentNode) {
	if (null == currentNode)
	    return;
	inOrderTraversal(currentNode.left);
	System.out.print(currentNode.nodeValue + ",");
	inOrderTraversal(currentNode.right);
    }

    /*
     * O(n): Where n is the number of nodes in the BST
     */
    public void preOrderTraversal(TreeNode currentNode) {
	if (null == currentNode)
	    return;
	System.out.print(currentNode.nodeValue + ",");
	preOrderTraversal(currentNode.left);
	preOrderTraversal(currentNode.right);
    }

    /*
     * O(n): Where n is the number of nodes in the BST
     */
    public void postOrderTraversal(TreeNode currentNode) {
	if (null == currentNode)
	    return;
	postOrderTraversal(currentNode.left);
	postOrderTraversal(currentNode.right);
	System.out.print(currentNode.nodeValue + ",");
    }
    
    /**
     * 4.3: Cracking the coding interview
     * 
     * List of Depths: Given a binary tree, design an algorithm which creates a
     * linked list of all the nodes at each depth (e.g., if you have a tree with
     * depth D, you'lf have D linked lists).
     * 
     * Time complexity: O(n) where n is the number of nodes in the tree
     * 
     * BFS implementation to create list
     */
    public List<LinkedList<TreeNode>> createLevelLinkedList_BFS(TreeNode currentNode) {
	List<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
//	base condition
	if (null == currentNode)
	    return null;
	LinkedList<TreeNode> current = new LinkedList<TreeNode>();
	current.add(currentNode);
	while(current.size() > 0) {
	    result.add(current);
//	    make current the parent
	    LinkedList<TreeNode> parents = current;
//	    create new list for children
	    current = new LinkedList<TreeNode>();
//	    iterate over all children and add them to the list
	    for (TreeNode parent : parents) {
		if (parent.left != null) 
		    current.add(parent.left);
		if (parent.right != null) 
		    current.add(parent.right);
	    }
	}
	return result;
    }

    public static void main(String[] args) {
	BinarySearchTree binarySearchTree = new BinarySearchTree();
	binarySearchTree.add(8);
	binarySearchTree.add(4);
	binarySearchTree.add(20);
	binarySearchTree.add(2);
	binarySearchTree.add(10);
	binarySearchTree.add(6);
	binarySearchTree.add(0);
	binarySearchTree.add(1);
	binarySearchTree.add(5);
	binarySearchTree.add(3);

	// System.out.println("Searches: ");
	// System.out.println(binarySearchTree.search(0)); // True
	// System.out.println(binarySearchTree.search(10)); // True
	// System.out.println(binarySearchTree.search(100)); // False

	// binarySearchTree.delete(4);

	// System.out.println("Traversals");
	// binarySearchTree.inOrderTraversal(binarySearchTree.root);
	// System.out.println();
	// binarySearchTree.preOrderTraversal(binarySearchTree.root);
	// System.out.println();
	// binarySearchTree.postOrderTraversal(binarySearchTree.root);

	// System.out.println("4.2: Build min BST");
	// BinarySearchTree binarySearchTree2 = new BinarySearchTree();
	// int[] input = { 0, 1, 2, 3, 4, 5, 6, 8, 10, 20 };
	// binarySearchTree2.buildBST(input, 0, input.length - 1);
	
	// System.out.println("4.3: List of depths - BFS");
	// binarySearchTree.createLevelLinkedList_BFS(binarySearchTree.root);
	
    }
}
