package com.practice.coding.solutions.algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges_BFS {

    public int orangesRotting(int[][] grid) {
	if (grid.length == 0 || grid[0].length == 0)
	    return 0;
	int m = grid.length, n = grid[0].length;
	int count = 0;
	Queue<int[]> que = new LinkedList<>();
	for (int i = 0; i < m; i++) {
	    for (int j = 0; j < n; j++) {
		if (grid[i][j] == 1)
		    count++;
		if (grid[i][j] == 2)
		    que.offer(new int[] { i, j });
	    }
	}
	int res = 0;
	int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	while (!que.isEmpty() && count > 0) {
	    for (int size = que.size(); size > 0; size--) {
		int[] pos = que.poll();
		for (int[] d : dirs) {
		    int x = pos[0] + d[0], y = pos[1] + d[1];
		    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
			grid[x][y] = 2;
			count--;
			que.offer(new int[] { x, y });
		    }
		}
	    }
	    res++;
	}
	return count == 0 ? res : -1;
    }
}
