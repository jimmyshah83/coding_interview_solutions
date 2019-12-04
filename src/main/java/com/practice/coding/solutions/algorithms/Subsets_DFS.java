package com.practice.coding.solutions.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Subsets_DFS {
    
    public static void main(String[] args) {
	subsets(new int[] {1,2,3});
    }

    private static List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(S, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private static void dfs(int[] s, int index, List<Integer> path, List<List<Integer>> result){
        result.add(new ArrayList<Integer>(path));

        for(int i = index; i < s.length; i++){
            path.add(s[i]);
            dfs(s, i+1, path, result);
            path.remove(path.size()-1);
        }
    }
}
