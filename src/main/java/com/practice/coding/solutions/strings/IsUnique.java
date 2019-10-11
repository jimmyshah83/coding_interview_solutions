package com.practice.coding.solutions.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * CRACKING the coding INTERVIEW 1.1
 * 
 * Implement an algorithm to determine if a string has all unique characters. 
 * 
 * What if you cannot use additional data structures?
 * A> The best option is to compare every char in the string with all other characters, giving O(n^2) time
 * 
 * @author jishah
 */
public class IsUnique {

	public static void main(String[] args) {
		String str = "abcd";
		System.out.println(hasUnique(str)); 
	}
	
	private static boolean hasUnique(String str) {
		Set<Character> charSet = new HashSet<Character>();
		for (char c : str.toCharArray()) {
			if (charSet.contains(c)) 
				return true;
			charSet.add(c);
		}		
		return false;
	}
}
