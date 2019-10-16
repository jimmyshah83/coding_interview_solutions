package com.practice.coding.solutions.dataStructures;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Adjacency list implementation of a Graph using LinkedList
 */
@SuppressWarnings({ "unchecked", "unused" })
class Graph {

    private class Vertex {

	private final int value;

	public Vertex(int value) {
	    this.value = value;
	}

	@Override
	public String toString() {
	    return "Node [value=" + value + "]";
	}
    }

    /**
     * A Graph's edge which would only require the destination as the source would
     * be the array index location
     */
    private class Edge {

	private final Vertex dest;
	private final int weight;

	public Edge(Vertex dest, int weight) {
	    super();
	    this.dest = dest;
	    this.weight = weight;
	}

	@Override
	public String toString() {
	    return "Edge [dest=" + dest + ", weight=" + weight + "]";
	}
    }

    private int numVertices;

    private LinkedList<Edge> adjacencyLists[];

    Graph(int numVertices) {
	this.numVertices = numVertices;
	adjacencyLists = new LinkedList[numVertices];

	for (int i = 0; i < numVertices; i++)
	    adjacencyLists[i] = new LinkedList<Edge>();
    }

    /**
     * Add the new edge in the array index src by creating a new Edge with the
     * destination vertex and the edge's weight
     */
    void addEdge(int src, int dest, int weight) {
	adjacencyLists[src].add(new Edge(new Vertex(dest), weight));
    }

    boolean isConnected(int src, int dest) {
	for (Edge edge : adjacencyLists[src]) {
	    if (edge.dest.value == dest)
		return Boolean.TRUE;
	}
	return Boolean.FALSE;
    }

    /**
     * BFS implementation to traverse a graph on it adjacent list Output:
     * 0,1,2,3,4,5
     * 
     * Cracking the coding interview 4.1
     * 
     * Route Between Nodes: Given a directed graph, design an algorithm to find out
     * whether there is a route between two nodes.
     */
    void breathFirstSearch(int s) {
	// Create a queue for BFS and add the element, to visit its children
	Queue<Integer> queue = new ArrayDeque<Integer>();
	queue.add(s);

	while (queue.size() != 0) {
	    // Dequeue a vertex from queue and print it
	    s = queue.poll();
	    System.out.print(s + " ");

	    // Get all adjacent vertices of the dequeued vertex s
	    // If a adjacent has not been visited, then mark it
	    // visited and enqueue it
	    for (Edge e : adjacencyLists[s]) {
		if (!queue.contains(e.dest.value))
		    queue.add(e.dest.value);
	    }
	}
    }

    public static void main(String args[]) {
	Graph g = new Graph(6);

	g.addEdge(0, 1, 5);
	g.addEdge(0, 2, 10);
	g.addEdge(1, 3, 15);
	g.addEdge(2, 3, 20);
	g.addEdge(2, 4, 25);
	g.addEdge(3, 5, 30);
	System.out.println(g);
	System.out.println("0,1 Connected? " + g.isConnected(0, 1)); // true
	System.out.println("0, 3 Connected? " + g.isConnected(0, 3)); // false
	g.breathFirstSearch(0);
    }

    @Override
    public String toString() {
	return "Graph [numVertices=" + numVertices + ", adjLists=" + Arrays.toString(adjacencyLists) + "]";
    }
}