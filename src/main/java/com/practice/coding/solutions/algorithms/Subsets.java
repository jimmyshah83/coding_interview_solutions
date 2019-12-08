package com.practice.coding.solutions.algorithms;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 2 ^ n subsets for any array
 */
public class Subsets {

    public static void main(String[] args) {
	findSubsets(new int[] { 1, 2, 3 });
    }

    private static ArrayList<ArrayList<Integer>> findSubsets(int[] S) {
	if (S == null)
	    return null;
	Arrays.sort(S);
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	for (int i = 0; i < S.length; i++) {
	    ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
	    // get sets that are already in result
	    for (ArrayList<Integer> a : result) {
		temp.add(new ArrayList<Integer>(a));
	    }
	    // add S[i] to existing sets
	    for (ArrayList<Integer> a : temp) {
		a.add(S[i]);
	    }
	    // add S[i] only as a set
	    ArrayList<Integer> single = new ArrayList<Integer>();
	    single.add(S[i]);
	    temp.add(single);
	    result.addAll(temp);
	}

	// add empty set
	result.add(new ArrayList<Integer>());

	return result;
    }
}
