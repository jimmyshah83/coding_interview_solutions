package com.practice.coding.solutions.arrays;

/**
 * LEET CODE
 * 
 * Given a sorted array nums, remove the duplicates in-place such that each
 * element appear only once and return the new length.
 * 
 * @author jishah
 *
 */
public class RemoveDuplicatesInPlace {

	public static void main(String[] args) {
		int nums[] = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		int length = removeDuplicates(nums);
		for (int i = 0; i < length; i++)
			System.out.println(nums[i]);
	}

	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0)
			return 0;
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
	}
}
