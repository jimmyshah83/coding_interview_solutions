package com.practice.coding.solutions.strings;

/**
 * CRACKING the coding INTERVIEW 1.6
 * 
 * Implement a method to perform basic string compression using the counts of
 * repeated characters. For example, the string aabcccccaaa would become
 * a2blc5a3. If the "compressed "string would not become smaller than the
 * original string, your method should return the original string. You can
 * assume the string has only uppercase and lowercase letters (a - z),
 *
 */
public class StringCompression {

    public static void main(String[] args) {
	System.out.println(compressStr("aabcccccaaa".toLowerCase())); // a2blc5a3
	System.out.println(compressStr("abc".toLowerCase())); // abc
    }

    /**
     * Simple O(n) approach to iterate over the String's char array and maintain the
     * counter for character
     */
    private static String compressStr(String s) {
	StringBuilder sb = new StringBuilder();
	if (s.length() <= 1)
	    return s;
	char[] c = s.toCharArray();
	char previousChar = '0';
	int counter = 1;
	for (int i = 0; i < s.length(); i++) {
	    if (c[i] != previousChar) {
		if (previousChar != '0')
		    sb.append(counter);
		sb.append(c[i]);
		previousChar = c[i];
		counter = 1;
	    } else
		++counter;
	}
	sb.append(counter);
	if (sb.length() > s.length())
	    return s;
	return sb.toString();
    }
}
