package com.practice.coding.solutions.linkedLists;

import com.practice.coding.solutions.dataStructures.SinglyLinkedListNode;

/**
 * Cracking the coding interview 2.2
 * 
 * Return Kth to Last: implement an algorithm to find the kth to last element of a singly linked list.
 */
public class KthToLast {

    public static void main(String[] args) {
	SinglyLinkedListNode<Integer> head = new SinglyLinkedListNode<Integer>(2);
	head.next = new SinglyLinkedListNode<Integer>(0);
	head.next.next = new SinglyLinkedListNode<Integer>(2);
	head.next.next.next = new SinglyLinkedListNode<Integer>(1);
	System.out.println(kthToLast(head, 0));
    }
    
    private static SinglyLinkedListNode<Integer> kthToLast(SinglyLinkedListNode<Integer> head, int k) {
	System.out.println(head);
	while(head != null) {
	    if (head.getValue() != k)
		head = head.next;
	    else
		break;
	}
	return head;
    }
}
