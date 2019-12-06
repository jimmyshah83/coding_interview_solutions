package com.practice.coding.solutions.arrays;

import java.util.Arrays;

/*
 * Cracking the coding interview 16.21
 */
public class SumSwap {

    public static void main(String[] args) {
	doSumSwap(new int[] {4,1,2,1,2}, new int[] {6,3,3});
    }
    
    private static void doSumSwap(int[] a, int[] b) {
	Arrays.sort(a);
	Arrays.sort(b);
	int sumA = calculateSum(a);
	int sumB = calculateSum(b);
	int targetVal = (sumA - sumB) / 2;
	int i = 0, j = 0;
	while (i < a.length && j < b.length) {
	    int diff = a[i] - b[j];
	    if (diff == targetVal) {
//		SWAP the values here
		System.out.print(a[i] + " " + b[j]);
		break;
	    } 
	    if (diff < targetVal) 
		i++;
	    else 
		j++;
	}
    }
    
    private static int calculateSum(int[] a) {
	int sum = 0;
	for (int i = 0; i < a.length; i++) 
	    sum += a[i];
	return sum;
    }
}
