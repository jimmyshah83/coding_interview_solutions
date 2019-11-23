package com.practice.coding.solutions.algorithms;

/**
 * Find the largest possible GCD for a give array of positive integers
 */
public class GCD {

    public static void main(String[] args) {
	System.out.println(generalizedGCD(5, new int[] { 2, 3, 4, 5, 6 }));
    }

    /**
     * Approach: for each value, find the GCD for every other value and return the
     * max GCD found
     */
    public static int generalizedGCD(int num, int[] arr) {
	if (num == 0)
	    return 0;
	int gcd = 0;
	for (int x = 0; x < num; x++) {
	    for (int j = x + 1; j < num; j++) {
		int n1 = arr[x];
		int n2 = arr[j];
		for (int i = 1; i <= n1 && i <= n2; ++i) {
		    if (n1 % i == 0 && n2 % i == 0 && gcd < i)
			gcd = i;
		}
	    }
	}
	return gcd;
    }
}
