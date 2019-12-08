package com.practice.coding.solutions.algorithms;

/*
 * Cracking the coding interview 16.17
 */
public class ContiguousSum {

    public static void main(String[] args) {
	System.out.println(findContiguousSum(new int[] { 2, -8, 3, -2, 4, -16 }));
    }

    private static int findContiguousSum(int[] a) {
	int size = a.length;
	int maxSum = Integer.MIN_VALUE, windowSum = 0;

	for (int i = 0; i < size; i++) {
	    windowSum = windowSum + a[i];
	    if (maxSum < windowSum)
		maxSum = windowSum;
	    if (windowSum < 0)
		windowSum = 0;
	}
	return maxSum;
    }
}
