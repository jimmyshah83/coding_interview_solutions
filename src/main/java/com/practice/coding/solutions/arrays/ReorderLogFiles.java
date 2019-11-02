package com.practice.coding.solutions.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * LeetCode You have an array of logs. Each log is a space delimited string of
 * words.
 * 
 * For each log, the first word in each log is an alphanumeric identifier. Then,
 * either:
 * 
 * Each word after the identifier will consist only of lower case letters, or;
 * Each word after the identifier will consist only of digits. We will call
 * these two varieties of logs letter-logs and digit-logs. It is guaranteed that
 * each log has at least one word after its identifier.
 * 
 * Reorder the logs so that all of the letter-logs come before any digit-log.
 * The letter-logs are ordered lexicographically ignoring identifier, with the
 * identifier used in case of ties. The digit-logs should be put in their
 * original order.
 * 
 * Return the final order of the logs.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit
 * dig","let3 art zero"] Output: ["let1 art can","let3 art zero","let2 own kit
 * dig","dig1 8 1 5 1","dig2 3 6"]
 *
 */
public class ReorderLogFiles {

	public static void main(String[] args) {
		String[] logs = new String[] {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
		System.out.println(reorderLogFiles(logs));
	}

	/**
	 * Approach: Split the logs based on sorted letter log and digit list
	 */
	public static String[] reorderLogFiles(String[] logs) {
		Set<String> letterLog = new TreeSet<String>();
		List<String> digitLog = new ArrayList<String>();
		for (String log : logs) {
			boolean isDigitLog = false;
			for (String str : log.split(" ")) {
				if (str.matches("[0-9]+")) {
					isDigitLog = true;
					digitLog.add(log);
					break;
				}
			} 
			if (!isDigitLog) 
				letterLog.add(log);
		}
		String[] retVal = new String[logs.length];
		int counter = 0;
		for (String s : letterLog) {
			retVal[counter] = s;
			counter++;
		}
		for (String s : digitLog) {
			retVal[counter] = s;
			counter++;
		}
		return retVal;
	}
}
