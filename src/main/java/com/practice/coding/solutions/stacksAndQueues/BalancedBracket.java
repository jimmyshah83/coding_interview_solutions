package com.practice.coding.solutions.stacksAndQueues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Check if the bucket is balanced. I/P: {([])} O/P" True This is done using 2
 * Stacks or ArrayDeque
 * 
 * @author jiviteshshah
 *
 */
public class BalancedBracket {

    public static String BRACKET = "{[(])}";
    public static Stack<Character> S = new Stack<Character>();

    public static Map<Character, Character> BRACKET_PAIRS = new HashMap<Character, Character>();

    static {
	BRACKET_PAIRS.put('(', ')');
	BRACKET_PAIRS.put('[', ']');
	BRACKET_PAIRS.put('{', '}');
    }

    public static void main(String[] args) {

	for (char c : BRACKET.toCharArray()) {

	    if (BRACKET_PAIRS.containsKey(c)) {
		S.push(c);
	    }

	    else {
		char topStackVal = S.pop();
		if (BRACKET_PAIRS.get(topStackVal) != c) {
		    System.out.println("NO");
		    break;
		}
	    }
	}

    }
}
