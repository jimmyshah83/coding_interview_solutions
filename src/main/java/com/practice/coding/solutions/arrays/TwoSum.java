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
	int[] nums = new int[] { 2, 7, 11, 15 };
	int target = 9;
	System.out.println(twoSum(nums, target).toString());
    }

    public static int[] twoSum(int[] nums, int target) {
	for (int i = 0; i < nums.length; i++) {
	    int complement = target - nums[i];
	    if (matchMap.containsKey(complement))
		return new int[] { matchMap.get(complement), i };
	    matchMap.put(nums[i], i);
	}
	return null;
    }
}
