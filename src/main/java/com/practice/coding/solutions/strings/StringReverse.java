package com.practice.coding.solutions.strings;

/**
 * Program to revere a given String. Example abc to cba.
 * 
 * @author jiviteshshah
 *
 */
public class StringReverse {

    public static void main(String[] args) {
	String s = "abc";
	char[] c = s.toCharArray();
	reverse(c);
    }

    private static void reverse(char[] c) {
	char[] retVal = new char[c.length];
	int index = 0;
	for (int i = c.length - 1; i >= 0; i--) {
	    retVal[index] = c[i];
	    index++;
	}
    }
}
