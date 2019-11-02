package com.practice.coding.solutions.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Subarrays with K Different Integers
 * 
 * Given an array A of positive integers, call a (contiguous, not necessarily
 * distinct) subarray of A good if the number of different integers in that
 * subarray is exactly K.
 * 
 * (For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)
 * 
 * Return the number of good subarrays of A.
 * 
 * Input: A = [1,2,1,2,3], K = 2 Output: 7 
 * Explanation: Subarrays formed with
 * exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2],
 * [1,2,1,2].
 */
public class SlidingWindow {
    
    public static void main(String[] args) {
	System.out.println(subarraysWithKDistinct(new int[] {1,2,3,4,1,1}, 3));
    }
    
    private static int subarraysWithKDistinct(int[] A, int K) {
        return countsOfSubarraysWithKDistinct(A, K) - countsOfSubarraysWithKDistinct(A, K - 1);
    }

    /**
     * Approach:
     * Start with window size of 0 to K and calculate the total window size
     * Do the same for window size of 0 to K-1 and calculate the total window size
     * The difference is the window size the sub array with unique elements
     */
    private static int countsOfSubarraysWithKDistinct(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int windowSize = 0, windowTotal = 0;

        for (int left = 0, right = 0; right < A.length; right++) {
            map.put(A[right], map.getOrDefault(A[right], 0) + 1);
            if (map.get(A[right]) == 1) {
                windowSize++;
            }

            while (windowSize > K) {
                map.put(A[left], map.get(A[left]) - 1);
                if (map.get(A[left]) == 0) {
                    windowSize--;
                }
                left++;
            }
            windowTotal += right - left + 1;
        }
        return windowTotal;
    }
}


