package com.practice.coding.solutions.linkedLists;

import com.practice.coding.solutions.dataStructures.SinglyLinkedListNode;

/**
 * Cracking the coding interview 2.6
 * 
 * Palindrome: Implement a function to check if a linked list is a palindrome
 * Reverse and compare
 *
 */
public class LinkedListPalindrome {

    public static void main(String[] args) {
	SinglyLinkedListNode<Integer> head = new SinglyLinkedListNode<Integer>(1);
	head.next = new SinglyLinkedListNode<Integer>(2);
	head.next.next = new SinglyLinkedListNode<Integer>(2);
	head.next.next.next = new SinglyLinkedListNode<Integer>(1);
	System.out.println(isPalindrome(head));
    }
    
    private static boolean isPalindrome(SinglyLinkedListNode<Integer> head) {
	SinglyLinkedListNode<Integer> headRev = reverseList(clone(head));
	while (head != null) {
	    if (head.getValue() != headRev.getValue()) 
		return Boolean.FALSE;
	    head = head.next;
	    headRev = headRev.next;
	}
	return Boolean.TRUE;
    }
    
    private static SinglyLinkedListNode<Integer> reverseList(SinglyLinkedListNode<Integer> head) {
	SinglyLinkedListNode<Integer> current = head;
	SinglyLinkedListNode<Integer> next = null;
	SinglyLinkedListNode<Integer> prev = null;
	while (current != null) {
	    next = current.next;
	    current.next = prev;
	    prev = current;
	    current = next;
	}
	return prev;
    }
    
    private static SinglyLinkedListNode<Integer> clone(SinglyLinkedListNode<Integer> head) {
	SinglyLinkedListNode<Integer> tmp = head;
	SinglyLinkedListNode<Integer> temp = new SinglyLinkedListNode<Integer>(0);
	SinglyLinkedListNode<Integer> ptr = temp;
	while(tmp != null) {
	    ptr.next = new SinglyLinkedListNode<Integer>(tmp.getValue());
	    ptr = ptr.next;
	    tmp = tmp.next;
	}
	return temp.next;
    }
}
