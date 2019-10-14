package com.practice.coding.solutions.strings;

/**
 * Cracking the coding interview 1.9
 * 
 * Assume you have a method isSubstring which checks if one word is a
 * substring of another. Given two strings, s1 and s2, write code to check if s2
 * is a rotation of s1 using only one call to isSubstring
 * (e.g.,"waterbottle"is a rotation o f ' erbottlewat " )
 *
 */
public class StringRotation {

    public static void main(String[] args) {
	System.out.println(isSubString("waterbottle", "erbottlewat"));
    }
    
    private static boolean isSubString(String s1, String s2) {
	return (s1+s2).contains(s1);
    }
}
