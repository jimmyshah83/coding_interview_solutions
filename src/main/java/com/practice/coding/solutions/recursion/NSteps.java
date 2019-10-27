package com.practice.coding.solutions.recursion;

/**
 * Triple Step: Count step 1, 2 or 3
 * @author jiviteshshah
 *
 */
public class NSteps {

    public static void main(String[] args) {
	System.out.println(countWays(3));
    }
    
    private static int countWays(int n) {
	if (n < 0) 
	    return 0;
	else if (n == 0)
	    return 1;
	else
	    return countWays(n-1) + countWays(n-2) + countWays(n-3);
    }
}
