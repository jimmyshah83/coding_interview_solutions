package com.practice.coding.solutions.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode Minimum Window Substring: Given a string S and a string T, find the
 * minimum window in S which will contain all the characters in T in complexity
 * O(n).
 * 
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 *
 */
public class MinimumWindowSubstring_SlidingWindow {

    public static void main(String[] args) {
	String s = "ADOBECODEBANC";
	String t = "ABC";
	System.out.println(getMinWindow(s, t));
    }

    private static String getMinWindow(String s, String t) {
	Map<Character, Integer> tCount = new HashMap<Character, Integer>();
	for (char c : t.toCharArray())
	    tCount.put(c, tCount.getOrDefault(c, 0) + 1);
	int beginIndex = 0;
	int endIndex = 0;
	int counter = tCount.size();
	int windowLen = Integer.MAX_VALUE;
	String answer = "";
	char[] charS = s.toCharArray();
	while (endIndex<s.length()) {
	    char c = charS[endIndex];
	    if (tCount.containsKey(c) && tCount.get(c) != 0) {
		tCount.put(c, tCount.get(c) - 1);
		if (tCount.get(c) == 0)
		    counter--;
	    }
	    endIndex++;
	    while (counter == 0) {
		if (endIndex - beginIndex < windowLen) {
		    windowLen = endIndex - beginIndex;
		    answer = s.substring(beginIndex, endIndex - beginIndex);
		}

		char startchar = charS[beginIndex];
		if (tCount.containsKey(startchar)) {
		    tCount.put(startchar, tCount.get(startchar) + 1);
		    if (tCount.get(startchar) > 0)
			counter++;
		}
		beginIndex++;
	    }
	}
	return answer;
    }
}
