package com.practice.coding.solutions.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * LEET CODE
 * 
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * @author jishah
 *
 */
public class TwoSum {

    private static final Map<Integer, Integer> matchMap = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
	int[] nums = new int[] { 7, 2, 11, 15 };
	twoSum(nums, 9);
    }

    public static void twoSum(int[] nums, int target) {
	for (int i = 0; i < nums.length; i++) {
	    int complement = target - nums[i];
	    if (matchMap.containsKey(complement)) {
		System.out.print(matchMap.get(complement) + " " + i );
		return;
	    }
	    matchMap.put(nums[i], i);
	}
    }
}
