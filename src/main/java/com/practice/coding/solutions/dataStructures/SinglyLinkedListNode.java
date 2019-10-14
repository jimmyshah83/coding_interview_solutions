package com.practice.coding.solutions.dataStructures;

/**
 * A Node for a singly linked list which would be used to solve linked list related problems
 */
public class SinglyLinkedListNode<T> {

    private final T value;
    public SinglyLinkedListNode<T> next;
    
    public SinglyLinkedListNode(T value) {
	this.value = value;
	this.next = null;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
	return "SinglyLinkedListNode [value=" + value + ", next=" + next + "]";
    }
}
