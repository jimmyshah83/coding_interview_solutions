package com.practice.coding.solutions.linkedLists;

import com.practice.coding.solutions.dataStructures.SinglyLinkedListNode;

/**
 * Cracking the coding interview 2.5
 * 
 * Sum Lists: You have two numbers represented by a linked list, where each node
 * contains a single digit. The digits are stored in reverse order, such that
 * the 1's digit is at the head of the list. Write a function that adds the two
 * numbers and returns the sum as a linked list. EXAMPLE input; ( 7 - > 1 -> 6)
 * + (S -> 9 -> 2). That is, 617 + 295. Output; 2 -> 1 -> 9.That is, 912.
 */
public class SumLists {

    public static void main(String[] args) {
	SinglyLinkedListNode<Integer> head1 = new SinglyLinkedListNode<Integer>(7);
	head1.next = new SinglyLinkedListNode<Integer>(1);
	head1.next.next = new SinglyLinkedListNode<Integer>(6);

	SinglyLinkedListNode<Integer> head2 = new SinglyLinkedListNode<Integer>(5);
	head2.next = new SinglyLinkedListNode<Integer>(9);
	head2.next.next = new SinglyLinkedListNode<Integer>(2);

	SumLists sumLists = new SumLists();
	sumLists.sumTheLists(head1, head2);
    }

    private void sumTheLists(SinglyLinkedListNode<Integer> head1, SinglyLinkedListNode<Integer> head2) {
	SinglyLinkedListNode<Integer> list1 = reverse(head1);
	SinglyLinkedListNode<Integer> list2 = reverse(head2);
	String list1Val = "";
	String list2Val = "";
	while (list1 != null) {
	    list1Val += list1.getValue();
	    list1 = list1.next;
	}
	while (list2 != null) {
	    list2Val += list2.getValue();
	    list2 = list2.next;
	}
	Integer outputVal = Integer.parseInt(list1Val) + Integer.parseInt(list2Val);
	String strOutput = outputVal.toString();
	SinglyLinkedListNode<Integer> finalList = null;
	SinglyLinkedListNode<Integer> lastNode = null;
	for (int i = strOutput.length() - 1; i >= 0; i--) {
	    int tempNum = Character.getNumericValue(strOutput.charAt(i));
	    SinglyLinkedListNode<Integer> newNode = new SinglyLinkedListNode<Integer>(tempNum);
	    if (finalList == null)
		finalList = newNode;
	    else {
		lastNode = finalList;
		while (lastNode.next != null)
		    lastNode = lastNode.next;
		lastNode.next = newNode;
	    }
	}
	System.out.println(finalList);
    }

    private SinglyLinkedListNode<Integer> reverse(SinglyLinkedListNode<Integer> head) {
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
}
