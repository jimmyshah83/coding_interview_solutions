package com.practice.coding.solutions.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFS_AdjacencyMatrix_NumberOfIslands {

    public static void main(String[] args) {

	List<List<Integer>> g = new ArrayList<List<Integer>>();
	List<Integer> row1 = Arrays.asList(new Integer[] { 1, 1, 0, 0 });
	List<Integer> row2 = Arrays.asList(new Integer[] { 0, 0, 1, 0 });
	List<Integer> row3 = Arrays.asList(new Integer[] { 0, 0, 0, 0 });
	List<Integer> row4 = Arrays.asList(new Integer[] { 1, 0, 1, 1 });
	List<Integer> row5 = Arrays.asList(new Integer[] { 1, 1, 1, 1 });
	g.add(row1);
	g.add(row2);
	g.add(row3);
	g.add(row4);
	g.add(row5);

	System.out.println("Number of islands is " + numIslands(g));
    }

    private static void dfs(List<List<Integer>> grid, int row, int col, boolean isVisited[][]) {
	if (row < 0 || col < 0 || row >= grid.size() || col >= grid.get(0).size() || isVisited[row][col] || grid.get(row).get(col) != 1)
	    return;
	isVisited[row][col] = true;
	dfs(grid, row-1, col, isVisited);
	dfs(grid, row, col-1, isVisited);
	dfs(grid, row+1, col, isVisited);
	dfs(grid, row, col+1, isVisited);
    }

    public static int numIslands(List<List<Integer>> grid) {
	int numIslands = 0;
	boolean isVisited[][] = new boolean[grid.size()][grid.get(0).size()];
	for (int row = 0; row < grid.size(); row++) {
	    for (int col = 0; col < grid.get(0).size(); col++) {
		if (!isVisited[row][col] && grid.get(row).get(col) == 1) {
		    dfs(grid, row, col, isVisited);
		    numIslands++;
		}
	    }
	}
	return numIslands;
    }
}
