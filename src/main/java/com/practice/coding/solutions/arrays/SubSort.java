package com.practice.coding.solutions.arrays;

import java.util.Arrays;

/*
 * Cracking the coding interview 16.6
 */
public class SubSort {

    public static void main(String[] args) {
	subSortFun(new int[] {1,2,4,7,10,11,7,12,6,7,16,18,19});
    }
    
    /*
     * Sort the array and then find values with left and right
     * O(n log n)
     */
    private static void subSortFun(int[] nums) {
	int[] temp = Arrays.copyOf(nums, nums.length);
	Arrays.sort(nums);
	int left = 0; int right = nums.length - 1;
	int leftIndex = Integer.MIN_VALUE, rightIndex = Integer.MIN_VALUE;
	while (left != right) {
	    if (nums[left] != temp[left] && leftIndex == Integer.MIN_VALUE) 
		leftIndex = left;
	    else left++;
	    if (nums[right] != temp[right] && rightIndex == Integer.MIN_VALUE) 
		rightIndex = right;
	    else right--;
	    if (leftIndex != Integer.MIN_VALUE && rightIndex != Integer.MAX_VALUE) 
		break;
	}
	System.out.print(leftIndex + " " + rightIndex);
    }
}
