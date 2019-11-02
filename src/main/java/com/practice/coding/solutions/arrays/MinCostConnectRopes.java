package com.practice.coding.solutions.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * Given n ropes of different lengths, we need to connect these ropes into one rope. We can connect only 2 ropes at a time. 
 * The cost required to connect 2 ropes is equal to sum of their lengths. The length of this connected rope is also equal to the 
 * sum of their lengths. This process is repeated until n ropes are connected into a single rope. 
 * Find the min possible cost required to connect all ropes.
 *
 * Input: ropes = [8, 4, 6, 12]
 * Output: 58
 * Explanation: The optimal way to connect ropes is as follows
 * 1. Connect the ropes of length 4 and 6 (cost is 10). Ropes after connecting: [8, 10, 12]
 * 2. Connect the ropes of length 8 and 10 (cost is 18). Ropes after connecting: [18, 12]
 * 3. Connect the ropes of length 18 and 12 (cost is 30).
 * Total cost to connect the ropes is 10 + 18 + 30 = 58
 */
public class MinCostConnectRopes {

    public static void main(String[] args) {
	Integer[] ropes = new Integer[] {20, 4, 8, 2};
	System.out.println(minCost(Arrays.asList(ropes)));
    }

    /**
     * Approach: Use a Priority Queue to iterate over the array and maintain total cost
     * 
     * Time complexity: O(nlogn).
     * Space complexity: O(n).
     */
    private static int minCost(List<Integer> ropes) {
	Queue<Integer> pq = new PriorityQueue<>(ropes);
	int totalCost = 0;
	while (pq.size() > 1) {
	    int cost = pq.poll() + pq.poll();
	    pq.add(cost);
	    totalCost += cost;
	}
	return totalCost;
    }
}
