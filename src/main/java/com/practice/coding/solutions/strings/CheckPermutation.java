package com.practice.coding.solutions.strings;

import java.util.Arrays;

/**
 * CRACKING the coding INTERVIEW 1.2
 * 
 * Check Permutation: Given two strings, write a method to decide if one is a
 * permutation of the other.
 * 
 * The implemented solution could be ideal as it is clean Solved by Sorting
 * using O(n log n)
 * 
 * NOTE: Solution #2: Check if the two strings have identical character counts.
 * We can also use the definition of a permutation�two words with the same
 * character counts�to implement t his algorithm. We simply iterate through this
 * code, counting how many times each character appears. Solved in O(n)
 * 
 * @author jishah
 *
 */
public class CheckPermutation {

    public static void main(String[] args) {
	String s1 = "ABC";
	String s2 = "BCC";
	System.out.println(checkPerm(s1.toLowerCase(), s2.toLowerCase()));
    }

    /**
     * The time complexity of Quicksort is O(n log n) in the best case, O(n log n)
     * in the average case, and O(n^2) in the worst case. But because it has the
     * best performance in the average case for most inputs, Quicksort is generally
     * considered the �fastest� sorting algorithm.
     * 
     * Arrays.sort(int[]): One can use primitives to sort which performs a quick
     * sort internally Arrays.sort(Object[]): Can sort objects but the object should
     * have comparator implemented and internally it does TimSort which is a
     * combination of Quick sort and Merge Sort with Avg case time complexity of O(n
     * log n). However, with Object[], we would have to add additional calls to the
     * stack for calling the compareTo method and hence, primitive sorting is faster
     * 
     * @param s String to be sorted
     */
    private static boolean checkPerm(String s1, String s2) {
	if (s1.length() != s2.length())
	    return false;
	char[] c1 = s1.toCharArray();
	char[] c2 = s2.toCharArray();
	Arrays.sort(c1);
	Arrays.sort(c2);
	if (!Arrays.equals(c1, c2))
	    return false;
	return true;
    }
}
