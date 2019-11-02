package com.practice.coding.solutions.treesAndGraphs;

import java.util.*;

/**
 * Finding critical components using Tarjan algorithm
 *
 *This is a very hard problem: time needs to be spent in understanding the fundamentals of Tarjan
 */
public class FindingCriticalPoints {

    static int time = 0;

    public static void main(String[] args) {
	int numRouters4 = 7;
	int numLinks4 = 7;
	int[][] links4 = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 2, 3 }, { 2, 5 }, { 5, 6 }, { 3, 4 } };
	System.out.println(getCriticalNodes(links4, numLinks4, numRouters4));
    }

    private static List<Integer> getCriticalNodes(int[][] links, int numLinks, int numRouters) {
	time = 0;
//	Initialize a map to hold all the connections for each link (bi-directional)
	Map<Integer, Set<Integer>> map = new HashMap<>();
	for (int i = 0; i < numRouters; i++) {
	    map.put(i, new HashSet<>());
	}
//	Set links up in map bi-directionally
	for (int[] link : links) {
	    map.get(link[0]).add(link[1]);
	    map.get(link[1]).add(link[0]);
	}
	List<Integer> res = new ArrayList<>();
	int[] low = new int[numRouters];
	int[] ids = new int[numRouters];
	int parent[] = new int[numRouters];
	Arrays.fill(ids, -1);
	Arrays.fill(parent, -1);
	for (int i = 0; i < numRouters; i++) {
	    if (ids[i] == -1)
		dfs(map, low, ids, parent, i, res);
	}
	return res;
    }

    private static void dfs(Map<Integer, Set<Integer>> map, int[] low, int[] ids, int[] parent, int current, List<Integer> res) {
	int children = 0;
	ids[current] = low[current] = ++time;
	for (int neighbour : map.get(current)) {
	    if (ids[neighbour] == -1) {
		children++;
		parent[neighbour] = current;
		dfs(map, low, ids, parent, neighbour, res);
		low[current] = Math.min(low[current], low[neighbour]);
		if ((parent[current] == -1 && children > 1) || (parent[current] != -1 && low[neighbour] >= ids[current]))
		    res.add(current);
	    } else if (neighbour != parent[current])
		low[current] = Math.min(low[current], ids[neighbour]);
	}
    }
}
