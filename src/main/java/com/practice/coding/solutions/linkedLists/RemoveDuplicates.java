package com.practice.coding.solutions.linkedLists;

import java.util.HashSet;
import java.util.Set;

import com.practice.coding.solutions.dataStructures.SinglyLinkedListNode;

/**
 * Cracking the coding interview 2.1
 * 
 * Remove Dups: Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP How would you solve this problem if a temporary buffer is not
 * allowed?
 *
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
	SinglyLinkedListNode<Integer> head = new SinglyLinkedListNode<Integer>(2);
	head.next = new SinglyLinkedListNode<Integer>(0);
	head.next.next = new SinglyLinkedListNode<Integer>(2);
	head.next.next.next = new SinglyLinkedListNode<Integer>(1);
	removeDuplicates(head);
	removeDuplicatesNoBuffer(head);
    }

    /**
     * Implemented using an additional buffer 
     * O(n)
     */
    private static void removeDuplicates(SinglyLinkedListNode<Integer> head) {
	System.out.println(head);
	Set<Integer> listElements = new HashSet<Integer>();
	SinglyLinkedListNode<Integer> previous = null;
	SinglyLinkedListNode<Integer> currentElement = head;
	while (currentElement != null) {
	    if (!listElements.contains(currentElement.getValue())) {
		listElements.add(currentElement.getValue());
		previous = currentElement;
	    } else
		previous.next = currentElement.next;
	    currentElement = currentElement.next;
	}
	System.out.println(head);
    }

    /**
     * Implemented WITHOUT using an additional buffer
     * We use 2 pointers where we compare every element with every other element in the linked list
     * O(n^2)
     */
    private static void removeDuplicatesNoBuffer(SinglyLinkedListNode<Integer> head) {
	System.out.println(head);
	SinglyLinkedListNode<Integer> currentElement = head;
	while (currentElement != null) {
	    SinglyLinkedListNode<Integer> previous = null;
	    SinglyLinkedListNode<Integer> nextElement = currentElement.next;
	    while (nextElement != null) {
		if (currentElement.getValue() == nextElement.getValue())
		    previous.next = nextElement.next;
		else 
		    previous = nextElement;
		nextElement = nextElement.next;
	    }
	    currentElement = currentElement.next;
	}
	System.out.println(head);
    }
}
