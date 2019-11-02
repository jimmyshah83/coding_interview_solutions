package com.practice.coding.solutions.linkedLists;

import com.practice.coding.solutions.dataStructures.SinglyLinkedListNode;

/**
 * Leet Code
 * 
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * Input: 1->2->4, 1->3->4 Output: 1->1->2->3->4->4
 */
public class MergeSortedLists {

    public static void main(String[] args) {
	SinglyLinkedListNode<Integer> headA = new SinglyLinkedListNode<Integer>(1);
	headA.next = new SinglyLinkedListNode<Integer>(2);
	headA.next.next = new SinglyLinkedListNode<Integer>(3);

	SinglyLinkedListNode<Integer> headB = new SinglyLinkedListNode<Integer>(1);
	headB.next = new SinglyLinkedListNode<Integer>(3);
	headB.next.next = new SinglyLinkedListNode<Integer>(4);

	System.out.println(mergeLists(headA, headB));
    }

    private static SinglyLinkedListNode<Integer> mergeLists(SinglyLinkedListNode<Integer> headA,
	    SinglyLinkedListNode<Integer> headB) {
	/*
	 * a dummy first node to hang the result on
	 */
	SinglyLinkedListNode<Integer> dummyNode = new SinglyLinkedListNode<Integer>(0);

	/*
	 * tail points to the last result node
	 */
	SinglyLinkedListNode<Integer> tail = dummyNode;
	while (true) {

	    /*
	     * if either list runs out, use the other list
	     */
	    if (headA == null) {
		tail.next = headB;
		break;
	    }
	    if (headB == null) {
		tail.next = headA;
		break;
	    }

	    /*
	     * Compare the data of the two lists whichever lists' data is smaller, append it
	     * into tail and advance the head to the next Node
	     */
	    if (headA.getValue() <= headB.getValue()) {
		tail.next = headA;
		headA = headA.next;
	    } else {
		tail.next = headB;
		headB = headB.next;
	    }

	    /* Advance the tail */
	    tail = tail.next;
	}
	return dummyNode.next;
    }
}
