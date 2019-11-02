package com.practice.coding.solutions.arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode
 * 
 * Given a 2D grid, each cell is either a Zombie 1 or a human 0. Zombies can
 * turn adjacent (up/down/left/right) human beings into Zombies every hour. Find
 * out how many hours does it take to infect all humans?
 * 
 * Similar problem: Treasure Island
 * https://leetcode.com/discuss/interview-question/347457 Solution:
 * https://leetcode.com/playground/uQoVfEmr
 */
public class ZombieInMatrix {

    private static final int ZOMBIE = 1;
    private static final int[][] DIRS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public static void main(String[] args) {
	List<List<Integer>> grid = new ArrayList<List<Integer>>();
	List<Integer> row1 = Arrays.asList(new Integer[] { 0, 1, 1, 0, 1 });
	List<Integer> row2 = Arrays.asList(new Integer[] { 0, 1, 0, 1, 0 });
	List<Integer> row3 = Arrays.asList(new Integer[] { 0, 0, 0, 0, 1 });
	List<Integer> row4 = Arrays.asList(new Integer[] { 0, 1, 0, 0, 0 });
	grid.add(row1);
	grid.add(row2);
	grid.add(row3);
	grid.add(row4);
	ZombieInMatrix zombieInMatrix = new ZombieInMatrix();
	System.out.println(zombieInMatrix.minHours(grid));
    }

    public int minHours(List<List<Integer>> grid) {
//		Fetch all Zombies and get the total number of people in the matrix
	int people = 0;
	Queue<Point> zombies = new ArrayDeque<>();
	for (int r = 0; r < grid.size(); r++) {
	    for (int c = 0; c < grid.get(0).size(); c++) {
		if (grid.get(r).get(c) == ZOMBIE)
		    zombies.add(new Point(r, c));
		else
		    people++;
	    }
	}

	if (people == 0)
	    return 0;

//		Using BFS; systematically convert all humans to zombies and add them to Queue
	for (int hours = 1; !zombies.isEmpty(); hours++) {
	    for (int sz = zombies.size(); sz > 0; sz--) {
		Point zombie = zombies.poll();

		for (int[] dir : DIRS) {
		    int r = zombie.r + dir[0];
		    int c = zombie.c + dir[1];

		    if (isHuman(grid, r, c)) {
			people--;
			if (people == 0)
			    return hours;
			grid.get(r).set(c, ZOMBIE);
			zombies.add(new Point(r, c));
		    }
		}
	    }
	}
	return -1;
    }

    private boolean isHuman(List<List<Integer>> grid, int r, int c) {
	return r >= 0 && r < grid.size() && c >= 0 && c < grid.get(0).size() && grid.get(r).get(c) != ZOMBIE;
    }

    private static class Point {
	int r, c;

	Point(int r, int c) {
	    this.r = r;
	    this.c = c;
	}
    }
}
