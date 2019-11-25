package com.practice.coding.solutions.linkedLists;

import com.practice.coding.solutions.dataStructures.SinglyLinkedListNode;

/**
 * Cracking the coding interview 2.7
 * 
 * Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node. 
 * Note that the intersection is defined based on reference, not value. That is, if the 
 * kth node of the first linked list is the exact same node (by reference) as the j t h node of the second 
 * linked list, then they are intersecting.
 */
public class Intersection {

    public static void main(String[] args) {
	SinglyLinkedListNode<Integer> node1 = new SinglyLinkedListNode<Integer>(5);
	SinglyLinkedListNode<Integer> nine = new SinglyLinkedListNode<Integer>(9);

	SinglyLinkedListNode<Integer> node2 = new SinglyLinkedListNode<Integer>(4);
	SinglyLinkedListNode<Integer> six = new SinglyLinkedListNode<Integer>(6);

	SinglyLinkedListNode<Integer> seven = new SinglyLinkedListNode<Integer>(7);
	SinglyLinkedListNode<Integer> two = new SinglyLinkedListNode<Integer>(2);

	node1.next = nine;
	node2.next = six;
	nine.next = seven;
	six.next = seven;

	seven.next = two;

	System.out.println(findIntersection(node1, node2));
    }

    /**
     * A naive O(n * m^2) implementation to do instance comparison for every node in
     * 1 vs 2
     */
    private static SinglyLinkedListNode<Integer> findIntersection(SinglyLinkedListNode<Integer> node1, SinglyLinkedListNode<Integer> node2) {
	while (node1 != null) {
	    SinglyLinkedListNode<Integer> temp = node2;
	    while (temp != null) {
		if (node1 == temp)
		    return node1;
		temp = temp.next;
	    }
	    node1 = node1.next;
	}
	return null;
    }
}
