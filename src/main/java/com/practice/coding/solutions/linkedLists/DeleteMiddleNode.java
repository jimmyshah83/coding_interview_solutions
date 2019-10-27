package com.practice.coding.solutions.linkedLists;

/**
 * Cracking the coding interview 2.3
 * 
 * Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but 
 * the first and last node, not necessarily the exact middle) of a singly linked list, given only access to that node.
 * EXAMPLE
 * Input: the node c from the linked list a - > b - > c - > d - > e - > f
 * Result: nothing is returned, but the new linked list looks like a- >b->d->e->f
 * 
 */
public class DeleteMiddleNode {
    
    private static class Node { 
	int value;
	Node next = null;
	public Node(int value) {
	    this.value = value;
	}
    }
    
    public static void main(String[] args) {
	Node head = new Node(2);
	head.next = new Node(0);
	head.next.next = new Node(2);
	head.next.next.next = new Node(1);
	deleteMiddleNode(head.next.next);
    }
    
    /**
     * All we need to do is copy the data over from the next node onto the current node. 
     * This cannot be solved if the node is the last node in the Linked List
     */
    private static void deleteMiddleNode(Node node) {
	Node next = node.next;
	node.value = next.value;
	node.next = next.next;
    }
}
