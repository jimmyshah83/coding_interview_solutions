package com.practice.coding.solutions.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary array of size n. A true (or 1) value in the array means active and false (or 0) means inactive. Given a number k, the task is to find count of active and inactive cells after k days. 
 * After every day, status of i’th cell becomes active if left and right cells are not same and inactive if left and right cell are same (both 0 or both 1). 
 * Since there are no cells before leftmost and after rightmost cells, the value cells before leftmost and after rightmost cells is always considered as 0 (or inactive).
 */
public class AdjacentCells {

	public static void main(String[] args) {
		System.out.println(cellCompete(new int[] { 0,1,1,0,0,1,0,1}, 2));
	}

	/**
	 * Approach: For each day, do a deep copy of the current states and compare each one with the previous and next
	 */
	public static List<Integer> cellCompete(int[] states, int days) {
		List<Integer> retVal = new ArrayList<Integer>();
		for (int i = 1; i <= days; i++) {
			int prevState = 0;
			int nextState = 0;
			int[] temp = new int[states.length];
			System.arraycopy(states, 0, temp, 0, states.length);
			for(int j = 0; j < states.length; j++) {
				if (j != 0)
					prevState = states[j-1];
				try {
					nextState = states[j+1];
				} catch (ArrayIndexOutOfBoundsException e) {
					nextState = 0;
				}
				
				if ((prevState == 0 && nextState == 0) || (prevState == 1 && nextState == 1))
					temp[j] = 0;
				else
					temp[j] = 1;
			}
			states = temp;
		}
		for (int i = 0; i < states.length; i++)
			retVal.add(states[i]);
		return retVal;
	}
}
