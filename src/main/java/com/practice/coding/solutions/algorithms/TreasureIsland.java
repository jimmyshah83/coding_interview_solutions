package com.practice.coding.solutions.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreasureIsland {

    private static int r;
    private static int c;

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

	System.out.println("Number of islands is " + numIslands(g, 5, 4));
    }

    private static void findNeigbors(List<List<Integer>> grid, boolean[][] visited, int row, int col) {
	if (row < 0 || row >= r || col < 0 || col >= c || visited[row][col] || grid.get(row).get(col) != 1)
	    return;
	visited[row][col] = true;
	findNeigbors(grid, visited, row + 1, col);
	findNeigbors(grid, visited, row - 1, col);
	findNeigbors(grid, visited, row, col + 1);
	findNeigbors(grid, visited, row, col - 1);

    }

    public static int numIslands(List<List<Integer>> grid, int row, int col) {
	r = row;
	if (row == 0)
	    return 0;
	c = col;
	boolean[][] visited = new boolean[r][c];
	int landCount = 0;
	for (int i = 0; i < grid.size(); i++) {
	    for (int j = 0; j < grid.get(i).size(); j++) {
		if (!visited[i][j] && grid.get(i).get(j) == 1) {
		    findNeigbors(grid, visited, i, j);
		    ++landCount;
		}
	    }
	}
	return landCount;
    }
}
