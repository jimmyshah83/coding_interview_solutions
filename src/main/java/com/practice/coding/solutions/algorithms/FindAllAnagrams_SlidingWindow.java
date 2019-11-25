package com.practice.coding.solutions.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagrams_SlidingWindow {

    public static void main(String[] args) {
	//List<Integer> result = findAnagrams("cbaebabacd", "abc");
	List<Integer> result = findAnagrams("abaacbabc", "abc");
	for (int i : result)
	    System.out.print(i + ",");
    }

    public static List<Integer> findAnagrams(String s, String t) {
	List<Integer> result = new ArrayList<Integer>();

	if (s.length() == 0 || t.length() == 0)
	    return result;

	Map<Character, Integer> tWordCount = new HashMap<Character, Integer>();
	for (char c : t.toCharArray()) {
	    tWordCount.put(c, tWordCount.getOrDefault(c, 0) + 1);
	}

	int left = 0, right = 0, windowSize = t.length(), found = 0;
	Map<Character, Integer> windowCharCounts = new HashMap<Character, Integer>();
	
	while (right < s.length()) {
	    char c = s.charAt(right);
	    if (tWordCount.containsKey(c)) {
		found++;
		windowCharCounts.put(c, windowCharCounts.getOrDefault(c, 0) + 1);
	    }
//	    Shrink left
	    if (windowSize == right-left+1) {
//		add the result
		if (found == windowSize && tWordCount.equals(windowCharCounts)) 
		    result.add(left);
		
		char c1 = s.charAt(left);
		if (windowCharCounts.containsKey(c1) && windowCharCounts.get(c1) > 0) {
		    found--;
		    windowCharCounts.put(c1, windowCharCounts.get(c1) - 1);
		}
		left++;
	    }
	    right++;
	}

	return result;
    }
}
