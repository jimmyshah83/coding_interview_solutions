package com.practice.coding.solutions.recursion;

import java.util.Scanner;

/**
 * Fibonacci series done using Recursion and dynamic programming
 */
public class Fibonacci {

    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int n = scan.nextInt();
	scan.close();
	System.out.println(fibonacci(n));
	System.out.println(dynamicFibonacci(n));
    }

    private static int fibonacci(int n) {
	if (n <= 1)
	    return n;
	return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private static int fibresult[] = new int[10];
    private static int dynamicFibonacci(int n) {
	fibresult[0] = 1;
        fibresult[1] = 1;
        for (int i = 2; i < n; i++)
           fibresult[i] = fibresult[i-1] + fibresult[i-2];
        return fibresult[n-1];
    }
}