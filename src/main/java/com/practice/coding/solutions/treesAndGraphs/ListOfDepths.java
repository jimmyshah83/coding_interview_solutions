package com.practice.coding.solutions.treesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.practice.coding.solutions.dataStructures.TreeNode;

/**
 * Cracking the coding interview 4.3
 * 
 * List of Depths: Given a binary tree, design an algorithm which creates a
 * linked list of all the nodes at each depth (e.g., if you have a tree with
 * depth D, you'lf have D linked lists).
 */
public class ListOfDepths {

    public static void main(String[] args) {
	int[] input = new int[] { 2, 4, 6, 8, 10, 20 };
	TreeNode node = MinimalBSTree.buildMinimalTree(input, 0, input.length - 1);
	ListOfDepths listOfDepths = new ListOfDepths();
	listOfDepths.create(node);
    }

    /**
     * A small modification to BFS
     * 
     * Time: O(N), Extra Space: O(1)
     * 
     */
    public List<LinkedList<TreeNode>> create(TreeNode root) {
	List<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
	if (root == null)
	    return result;
	LinkedList<TreeNode> current = new LinkedList<TreeNode>();
	current.add(root);
	while (current.size() > 0) {
	    result.add(current);
	    // go to the next level
	    LinkedList<TreeNode> parents = current;
	    current = new LinkedList<TreeNode>();
	    for (TreeNode parent : parents) {
		if (parent.left != null) {
		    current.add(parent.left);
		}
		if (parent.right != null) {
		    current.add(parent.right);
		}
	    }
	}
	return result;
    }
}
