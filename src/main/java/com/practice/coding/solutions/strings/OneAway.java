package com.practice.coding.solutions.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * CRACKING the coding INTERVIEW 1.5
 * 
 * There are three types of edits that can be performed on strings: insert a character, 
 * remove a character, or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.
 * 
 * @author jishah
 *
 */
public class OneAway {
	
	public static void main(String[] args) {
		System.out.println(checkOneAway("pale", "pales")); // true
		System.out.println(checkOneAway("pales", "pale")); // true
		System.out.println(checkOneAway("pale", "bale")); // true
		System.out.println(checkOneAway("pale", "pile")); // true
		System.out.println(checkOneAway("pale", "psale")); // true
		System.out.println(checkOneAway("pale", "pie")); // true
		
		System.out.println(checkOneAway("pale", "paless")); // false
		System.out.println(checkOneAway("paless", "pale")); // false
	}
	
	/**
	 * We know that if there is a insert or delete, one String is 1 element greater or smaller than other 
	 * Also, we add elements of 1 string to set and let then using the above assumption, compare other string
	 * characters with the ones in set to see if the difference is 0 OR 1
	 * 
	 * Time complexity O (n) 
	 * Space Complexity O (n)
	 */
	private static boolean checkOneAway(String s1, String s2) {
		int diffCount = 0;
		if (s1.length() == s2.length() || (Math.abs(s1.length()-s2.length()) <= 1)) {
			char[] c1 = s1.toCharArray();
			Set<Character> elements = new HashSet<Character>();
			for (int i = 0; i < s1.length(); i++) {
				elements.add(c1[i]);
			}
			char[] c2 = s2.toCharArray();
			for (int i = 0; i < s2.length(); i++) {
				if (!elements.contains(c2[i]))
					++diffCount;
			}
		} else 
			diffCount = Integer.MAX_VALUE;
		if (diffCount <= 1)
			return Boolean.TRUE;
		return Boolean.FALSE;
	}
}
