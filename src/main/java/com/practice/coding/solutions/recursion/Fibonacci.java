package com.practice.coding.solutions.recursion;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int n = scan.nextInt();
	scan.close();
	System.out.println(fibonacci(n));
    }

    static int fibonacci(int n) {
	if (n <= 1)
	    return n;
	return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
