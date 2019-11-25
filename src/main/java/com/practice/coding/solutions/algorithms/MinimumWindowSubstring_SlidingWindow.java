package com.practice.coding.solutions.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode Minimum Window Substring: Given a string S and a string T, find the
 * minimum window in S which will contain all the characters in T in complexity
 * O(n).
 * 
 * Input: S = "ADOBECODEBANC", T = "ABCD" Output: "ADOBEC"
 *
 */
public class MinimumWindowSubstring_SlidingWindow {

    public static void main(String[] args) {
	String s = "ADOBECODEBANC";
	String t = "ABCD";
	System.out.println(getMinWindow(s, t));
    }

    private static String getMinWindow(String s, String t) {
	if (s.length() == 0 || t.length() == 0)
	    return "";

//	Build a map of all the characters and its count in t
	Map<Character, Integer> tCharCounts = new HashMap<Character, Integer>();
	for (char c : t.toCharArray())
	    tCharCounts.put(c, tCharCounts.getOrDefault(c, 0) + 1);

//	Initialize variables. 
	int left = 0, right = 0, windowSize = Integer.MAX_VALUE;
	String answer = "";
	
//	Found would be used to keep track of all the found characters in s that are in t
	int found = tCharCounts.size();
	
	while (right < s.length()) {
	    
//	    Increase window size from right
	    char c = s.charAt(right);
	    if (tCharCounts.containsKey(c) && tCharCounts.get(c) > 0) {
		found--;
		tCharCounts.put(c, tCharCounts.get(c)-1);
	    }
	    
//	    Shrink from the left
	    while (found == 0) {
		
		if (windowSize > right-left+1) {
		    windowSize = right-left+1;
		    answer = s.substring(left, right+1);
		}
		
		char c1 = s.charAt(left);
		if (tCharCounts.containsKey(c1)) {
		    found++;
		    tCharCounts.put(c1, tCharCounts.get(c1)+1);
		}
		left++;
	    }
	    right++;
	}
	
	return answer;
    }
}
