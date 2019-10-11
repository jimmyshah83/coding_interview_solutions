package com.practice.coding.solutions.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * CRACKING the coding INTERVIEW 1.2
 * 
 * Given a string, write a function to check if it is a permutation of a
 * palindrome. A palindrome is a word or phrase that is the same forwards and backwards, A 
 * permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
 * EXAMPLE Input: Tact Coa 
 * Output: True (permutations: " t a co c a t " " a t c o eta" etc.)
 * 
 * @author jishah
 *
 */
public class PalindromePermutation {

	public static void main(String[] args) {
		System.out.println(isPalindromePermutation("atco cta"));
	}
	
	/**
	 * For a string to be a palindrome and permutation: 
	 * 1. It should have all even counts for characters OR
	 * 2. It should be ODD and have all even but 1 ODD character count 
	 */
	private static boolean isPalindromePermutation(String s) {
		char[] c = s.toCharArray();
		Map<Character, Integer> characterCount = new HashMap<Character, Integer>();
		for (int i = 0; i < c.length; i++) {
			if (Character.isWhitespace(c[i]))
				continue;
			if (!characterCount.containsKey(c[i]))
				characterCount.put(c[i], 1);
			else {
				int charCount = characterCount.get(c[i]);
				characterCount.put(c[i], ++charCount);
			}
		}		
		int oddCount = 0;
		for (Entry<Character, Integer> entry : characterCount.entrySet()) {
			if (entry.getValue() %2 == 0)
				continue;
			else
				++oddCount;
		}
		if (oddCount > 1)
			return Boolean.FALSE;
		else
			return Boolean.TRUE;
	}
}
