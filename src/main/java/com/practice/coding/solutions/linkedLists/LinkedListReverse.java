package com.practice.coding.solutions.linkedLists;

import com.practice.coding.solutions.dataStructures.SinglyLinkedListNode;

/**
 * Reverse a linked list in place
 */
public class LinkedListReverse {

    public static void main(String[] args) {
	SinglyLinkedListNode<Integer> head = new SinglyLinkedListNode<Integer>(1);
	head.next = new SinglyLinkedListNode<Integer>(2);
	head.next.next = new SinglyLinkedListNode<Integer>(3);
	System.out.println(head);
	System.out.println(reverse(head));
    }

    private static SinglyLinkedListNode<Integer> reverse(SinglyLinkedListNode<Integer> head) {
	SinglyLinkedListNode<Integer> prev = null;
	SinglyLinkedListNode<Integer> current = head;
	SinglyLinkedListNode<Integer> next = null;
	while (current != null) {
//	    hold reference to next iteration
	    next = current.next;
//	    Make the next element the previous element
	    current.next = prev;
//	    Make the current element as previous
	    prev = current;
//	    Prepare for next iteration
	    current = next;
	}
	return prev;
    }
}
