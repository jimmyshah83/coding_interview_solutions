package com.practice.coding.solutions.arrays;

/**
 * Backbase Codility test 30/07/2019
 * 
 * @author jiviteshshah
 *
 */
public class DayOfTheWeek {

    public static void main(String[] args) {
	System.out.println(solution("Wed", 0));
	System.out.println(solution("Fri", 2));
	System.out.println(solution("Wed", 4));
	System.out.println(solution("Thu", 4));
	System.out.println(solution("Wed", 5));
	System.out.println(solution("Sat", 23));
	System.out.println(solution("Sat", 25));
	System.out.println(solution("Sun", 30));
    }

    /**
     * I have written and tested the code in eclipse with below scenarios
     * solution("Wed", 0) solution("Fri", 2) solution("Wed", 4) solution("Thu", 4)
     * solution("Wed", 5) solution("Sat", 23) solution("Sat", 25) solution("Sun",
     * 30)
     */

    private static String[] s = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" };

    public static String solution(String S, int K) {

	if (K == 0)
	    return S;
	int index = 0;
	for (int i = 0; i < s.length; i++) {
	    if (S.equals(s[i]))
		index = i;
	}
	int temp = index + K;
	if (temp < 7) {
	    return s[temp];
	} else {
	    temp = temp % 7;
	    return s[temp];
	}
    }
}
