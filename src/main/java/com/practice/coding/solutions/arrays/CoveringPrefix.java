package com.practice.coding.solutions.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Codility: Covering Prefix
 * 
 * A non-empty zero-indexed array A consisting of N integers is given. The first
 * covering prefix of array A is the smallest integer P such that 0 ≤ P < N and
 * such that every value that occurs in array A also occurs in sequence A[0],
 * A[1], ..., A[P].
 * 
 * For example, the first covering prefix of the following 5−element array A:
 * A[0] = 2  A[1] = 2  A[2] = 1 A[3] = 0  A[4] = 1
 * 
 * is 3, because sequence [ A[0], A[1], A[2], A[3] ] equal to [2, 2, 1, 0], contains all values that occur in array A.
 */
public class CoveringPrefix {

    public static void main(String[] args) {
	int[] A = { 2, 2, 1, 0, 1 };
	System.out.println(soluton(A));
    }

    public static int soluton(int[] A) {
	Map<Integer, Integer> indexes = new HashMap<Integer, Integer>();
	// start from the back
	for (int i = A.length - 1; i >= 0; i--) {
	    indexes.put(A[i], i);
	}
	// now find the highest value in the map
	int highestIndex = 0;
	for (Integer i : indexes.values()) {
	    if (highestIndex < i.intValue())
		highestIndex = i.intValue();
	}
	return highestIndex;
    }
}
