package com.practice.coding.solutions.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * HackerRank
 * 
 * Given a String arithmetic expression with numbers, + and -, identify the
 * final value 
 * Consider that an operator is always surrounded by 2 numbers
 */
public class EvaluateArithmeticExpression {

    public static void main(String[] args) {
	System.out.println(evaluate("-1+2-3+10"));
    }

    /*
     * Brute force approach
     */
    public static int evaluate(String expression) {
//		Get all the numbers from String expression using Regex
	String[] numbers = expression.split("[+-/\\\\*]");
//		Fetch all the operators from the string expression
	List<String> operators = new ArrayList<String>();
	for (char c : expression.toCharArray()) {
	    if (String.valueOf(c).equals("+") || String.valueOf(c).equals("-")) {
		operators.add(String.valueOf(c));
	    }
	}
	int result = 0;
	int startIndex = 1;
//		Check if the 1st character is -, if yes, need to set result accordingly
	if (!Character.isDigit(expression.charAt(0)) && String.valueOf(expression.charAt(0)).equals("-")) {
	    operators.remove(0);
	    result -= Integer.parseInt(numbers[1]);
	    startIndex++;
	} else
	    result += Integer.parseInt(numbers[0]);
//		Iterate over the numbers array to calculate the final result
	for (int i = startIndex; i < numbers.length; i++) {
	    String operator = operators.remove(0);
	    switch (operator) {
	    case "+":
		result += Integer.parseInt(numbers[i]);
		break;
	    case "-":
		result -= Integer.parseInt(numbers[i]);
		break;
	    }
	}

	return result;
    }
}
