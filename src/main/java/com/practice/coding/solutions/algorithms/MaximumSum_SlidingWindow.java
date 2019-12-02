package com.practice.coding.solutions.algorithms;

/*
 * Given an array of integers of size ‘n’.
 * Our aim is to calculate the maximum sum of ‘k’  
 * consecutive elements in the array.
 * 
 * Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}
 * k = 4
 * Output : 39
 */
public class MaximumSum_SlidingWindow {

    public static void main(String[] args) {
	System.out.println(maxSum(new int[] { 1, 4, 2, 10, 23, 3, 1, 0, 20 }, 4));
	System.out.println(maxSum(new int[] { 100, 200, 300, 400 }, 2));
    }

    private static int maxSum(int[] a, int k) {
	if (k > a.length) 
	    return Integer.MIN_VALUE;
	
	int left = 0, right = 0, finalSum = 0, windowSum = 0;
	
	while (right < a.length) {
	    if (windowSum + a[right] > windowSum)
		windowSum += a[right];
	    if (k == right - left) {
		windowSum -= a[left];
		left++;
	    }
	    finalSum = Math.max(finalSum, windowSum);
	    right++;
	}
	return finalSum;
    }
}
