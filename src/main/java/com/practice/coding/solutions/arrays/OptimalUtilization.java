package com.practice.coding.solutions.arrays;

/**
 * Leet Code
 * 
 * Given 2 lists a and b. Each element is a pair of integers where the first
 * integer represents the unique id and the second integer represents a value.
 * Your task is to find an element from a and an element form b such that the
 * sum of their values is less or equal to target and as close to target as
 * possible. Return a list of ids of selected elements. If no pair is possible,
 * return an empty list.
 * 
 * Input: a = [[1, 2], [2, 4], [3, 6]] b = [[1, 2]] target = 7
 * 
 * Output: [[2, 1]]
 * 
 * Explanation: There are only three combinations [1, 1], [2, 1], and [3, 1],
 * which have a total sum of 4, 6 and 8, respectively. Since 6 is the largest
 * sum that does not exceed 7, [2, 1] is the optimal pair.
 *
 */
public class OptimalUtilization {

    public static void main(String[] args) {
	int[][] a = { { 1, 2 }, { 2, 4 }, { 3, 6 } };
	int[][] b = { { 1, 2 } };
	getPair(a, b, 7);
    }

    /**
     * Approach: Brute Force
     * For each value in a, calculate the difference in b to get the best
     * result 
     * Time complexity: O(n*m^2)
     */
    public static int[][] getPair(int[][] a, int[][] b, int sum) {
	int[][] closestSum = { { 0, 0 } };
	int diff = Integer.MAX_VALUE;
	for (int row = 0; row < a.length; row++) {
	    for (int col = 1; col < a[row].length; col++) {
		for (int rowB = 0; rowB < b.length; rowB++) {
		    for (int colB = 1; colB < b[rowB].length; colB++) {
			int s = a[row][col] + b[rowB][colB];
			if (s < sum && sum - s < diff) {
			    diff = sum - s;
			    closestSum[0][0] = a[row][col - 1];
			    closestSum[0][1] = b[rowB][colB - 1];
			}
		    }
		}
	    }
	}
	return closestSum;
    }
}
