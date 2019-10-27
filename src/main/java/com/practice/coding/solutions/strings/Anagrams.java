package com.practice.coding.solutions.strings;

/**
 * Check is S2 is anagram of S1. 
 * Can be done by sorting the 2 Strings. 
 */
import java.util.Arrays;

public class Anagrams {

    public static void main(String[] args) {
	char[] a = "abc".toCharArray();
	char[] b =  "cab".toCharArray();
	
	 Arrays.sort(a);
	 Arrays.sort(b);
	 
	for (int i = 0; i < a.length; i++) {
	    if (a[i] != b[i]) {
		System.out.println("False");
		break;
	    }
	}
	System.out.println("True");
    }
}
