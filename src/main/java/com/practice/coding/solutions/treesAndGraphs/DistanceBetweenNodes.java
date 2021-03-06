package com.practice.coding.solutions.treesAndGraphs;

/**
 * https://www.geeksforgeeks.org/shortest-distance-between-two-nodes-in-bst/
 * 
 * In the case of BST, we can find the distance faster. We start from the root
 * and for every node, we do following.
 * 
 * If both keys are greater than the current node, we move to the right child of
 * the current node. If both keys are smaller than current node, we move to left
 * child of current node. If one keys is smaller and other key is greater,
 * current node is Lowest Common Ancestor (LCA) of two nodes. We find distances
 * of current node from two keys and return sum of the distances.
 */
public class DistanceBetweenNodes {

    static class Node {
	Node left, right;
	int key;
    }

    static Node newNode(int key) {
	Node ptr = new Node();
	ptr.key = key;
	ptr.left = null;
	ptr.right = null;
	return ptr;
    }

    // Standard BST insert function
    static Node insert(Node root, int key) {
	if (root == null)
	    root = newNode(key);
	else if (root.key > key)
	    root.left = insert(root.left, key);
	else if (root.key < key)
	    root.right = insert(root.right, key);
	return root;
    }

    // This function returns distance of x from
    // root. This function assumes that x exists
    // in BST and BST is not NULL.
    static int distanceFromRoot(Node root, int x) {
	if (root.key == x)
	    return 0;
	else if (root.key > x)
	    return 1 + distanceFromRoot(root.left, x);
	return 1 + distanceFromRoot(root.right, x);
    }

    // Returns minimum distance beween a and b.
    // This function assumes that a and b exist
    // in BST.
    static int distanceBetween2(Node root, int a, int b) {
	if (root == null)
	    return 0;

	// Both keys lie in left
	if (root.key > a && root.key > b)
	    return distanceBetween2(root.left, a, b);

	// Both keys lie in right
	if (root.key < a && root.key < b) // same path
	    return distanceBetween2(root.right, a, b);

	// Lie in opposite directions (Root is
	// LCA of two nodes)
	if (root.key >= a && root.key <= b)
	    return distanceFromRoot(root, a) + distanceFromRoot(root, b);

	return 0;
    }

    // This function make sure that a is smaller
    // than b before making a call to findDistWrapper()
    static int findDistWrapper(Node root, int a, int b) {
	int temp = 0;
	if (a > b) {
	    temp = a;
	    a = b;
	    b = temp;
	}
	return distanceBetween2(root, a, b);
    }

    // Driver code
    public static void main(String[] args) {
	Node root = null;
	root = insert(root, 20);
	insert(root, 10);
	insert(root, 5);
	insert(root, 15);
	insert(root, 30);
	insert(root, 25);
	insert(root, 35);
	System.out.println(findDistWrapper(root, 5, 35));
    }
}
