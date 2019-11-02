package com.practice.coding.solutions.arrays;
/**
 * Spiral Matrix II
 * 
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * 
 * Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */
public class SpiralMartix {
    
    public static void main(String[] args) {
	generateMatrix(3);
    }

    private static int[][] generateMatrix(int n) {
	int[][] result = new int[n][n];
	int k = 1;
	int top = 0;
	int bottom = n - 1;
	int left = 0;
	int right = n - 1;

	while (k <= n * n) {
	    for (int i = left; i <= right; i++) {
		result[top][i] = k;
		k++;
	    }
	    top++;

	    for (int i = top; i <= bottom; i++) {
		result[i][right] = k;
		k++;
	    }
	    right--;

	    for (int i = right; i >= left; i--) {
		result[bottom][i] = k;
		k++;
	    }
	    bottom--;

	    for (int i = bottom; i >= top; i--) {
		result[i][left] = k;
		k++;
	    }
	    left++;
	}
	return result;
    }
}
