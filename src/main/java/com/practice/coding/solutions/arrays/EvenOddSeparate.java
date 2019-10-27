package com.practice.coding.solutions.arrays;

/**
 * LeetCode
 * 
 * Separate even and odd numbers to the left and right of the array. 
 * This can be done manually or using an ArrayDeque. 
 */
import java.util.ArrayDeque;
import java.util.Deque;

public class EvenOddSeparate {

    private static Deque<Integer> deque = new ArrayDeque<Integer>();

    public static void main(String[] args) {
	int[] a = new int[] { 1, 15, 20, 25, 30, 3, 7, 0, 12 };
	segregate(a);

	for (int i = 0; i < a.length; i++) {
	    if (a[i] % 2 == 0) {
		deque.offerFirst(a[i]);
	    } else
		deque.offerLast(a[i]);
	}

	deque.forEach(i -> System.out.println(i));
    }

    private static void segregate(int[] a) {
	int swapCount = 0;
	int left = 0;
	int right = a.length - 1;
	while (left < right) {
	    while (a[left] % 2 == 0) {
		left++;
	    }
	    while (a[right] % 2 == 1) {
		right--;
	    }
	    if (left < right) {
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
		swapCount++;
	    }
	}
	System.out.println("--- " + swapCount);
    }
}
