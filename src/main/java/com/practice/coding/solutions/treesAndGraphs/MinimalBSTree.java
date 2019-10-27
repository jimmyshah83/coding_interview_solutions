package com.practice.coding.solutions.treesAndGraphs;

import com.practice.coding.solutions.dataStructures.TreeNode;

/**
 * Cracking the coding interview 4.2
 * 
 * Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an 
 * algorithm to create a binary search tree with minimal height.
 */
public class MinimalBSTree {

    public static void main(String[] args) {
	int[] input = new int[] {2,4,6,8,10,20};    
	System.out.println(buildMinimalTree(input, 0, input.length-1));
    }
    
    public static TreeNode buildMinimalTree(int[] input, int start, int end) {
	if (start > end) 
            return null; 
	int mid = (start + end)/2;
	TreeNode node = new TreeNode(input[mid]);
	node.left = buildMinimalTree(input, start, mid-1);
	node.right = buildMinimalTree(input, mid+1, end);
	return node;
    }
}
