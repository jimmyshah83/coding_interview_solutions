package com.practice.coding.solutions.arrays;

/**
 * LEET CODE
 * 
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * 10/26: A better way to do this would be to use a a Queue to add non-zero elements if 
 * space is not an issue
 * 
 * @author jishah
 *
 */
public class MoveZeros {

    public static void main(String[] args) {
	int nums[] = new int[] { 0, 1, 0, 3, 12 };
	moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {
	int temp = 0;
	for (int i = 0; i < nums.length; i++) {
	    if (nums[i] == 0) {
		for (int j = i + 1; j < nums.length; j++) {
		    if (nums[j] != 0) {
			temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			break;
		    }
		}
	    }
	}
    }
}
