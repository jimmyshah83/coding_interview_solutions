package com.practice.coding.solutions.linkedLists;

import com.practice.coding.solutions.dataStructures.SinglyLinkedListNode;

/**
 * Cracking the coding interview 2.8
 * Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
 * DEFINITION 
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, 
 * so as to make a loop in the linked list. 
 * EXAMPLE 
 * Input: 1 -> 2 -> 3 -> 4 -> 5 -> 3 [the same C as earlier] 
 * Output: C
 */
public class LoopDetection {

	public static void main(String[] args) {
		SinglyLinkedListNode<Integer> head = new SinglyLinkedListNode<Integer>(1);
		SinglyLinkedListNode<Integer> two = new SinglyLinkedListNode<Integer>(2);
		SinglyLinkedListNode<Integer> three = new SinglyLinkedListNode<Integer>(3);
		SinglyLinkedListNode<Integer> four = new SinglyLinkedListNode<Integer>(4);
		SinglyLinkedListNode<Integer> five = new SinglyLinkedListNode<Integer>(5);
		
		head.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = three;
		
		System.out.println(detectLoop(head));
	}
	
	/**
	 * Simple approach using 2 pointers
	 */
	private static boolean detectLoop(SinglyLinkedListNode<Integer> node) {
		SinglyLinkedListNode<Integer> slow = node;
		SinglyLinkedListNode<Integer> fast = node.next;
		while(slow != null) {
			while(fast != null) {
				if (slow == fast) 
					return Boolean.TRUE;
				fast = fast.next.next;
				slow = slow.next;
			}			
		}
		return Boolean.FALSE;
	}
}
