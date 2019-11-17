package com.practice.coding.solutions.dataStructures;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Graph implementation using Adjacency LinkedList
 * Storage O(V + E): where V is the number of vertices and E is the number of Edges in the graph
 *
 */
public class GraphLinkedList {

    private class Vertex {
	int value;

	public Vertex(int value) {
	    this.value = value;
	}

	@Override
	public String toString() {
	    return "Vertex [value=" + value + "]";
	}
    }

    private class Edge {
	Vertex destination;

	public Edge(Vertex vertex) {
	    this.destination = vertex;
	}

	@Override
	public String toString() {
	    return "Edge [destination=" + destination + "]";
	}

    }

    /*
     * neighbors of a Vertex
     */
    LinkedList<Edge> adjacencyList[];

    @SuppressWarnings("unchecked")
    public GraphLinkedList(int numberOfVertices) {
	this.adjacencyList = new LinkedList[numberOfVertices];
	for (int i = 0; i < numberOfVertices; i++)
	    this.adjacencyList[i] = new LinkedList<Edge>();
    }

    /*
     * O(1): to add an edge in the graph
     */
    public void addEdge(int source, int destination) {
	adjacencyList[source].add(new Edge(new Vertex(destination)));
    }

    /*
     * O(1): to identify if V vertices are connected
     */
    public boolean isConnected(int source, int destination) {
	return adjacencyList[source].stream().filter(edge -> edge.destination.value == destination).findFirst().isPresent();
    }
    
    /*
     * DFS using stack: Use when you want to visit all the elements in the Graph but not so much when you want to find the shortest path.
     * 
     * O(V+E): Number of vertices + number of edges in a graph
     */
    public void depthFirstSearch(int startVal) {
	boolean isVisited[] = new boolean[adjacencyList.length];
	Stack<Integer> stack = new Stack<Integer>();
	stack.add(startVal);
	while (!stack.isEmpty()) {
	    int value = stack.pop();
	    if (!isVisited[value]) {
		System.out.print(value + " ");
		isVisited[value] = true;
	    }
	    adjacencyList[value].stream().filter(e -> !isVisited[e.destination.value]).forEach(e -> stack.add(e.destination.value));
	}
    }
    
    /*
     * BFS using Queue: Use when you want to find the shorted path between 2 nodes
     * O(V+E): Number of vertices + number of edges in a graph
     */
    public void breathFirstSearch(int startVal) {
	boolean isVisited[] = new boolean[adjacencyList.length];
	Queue<Integer> queue = new ArrayDeque<Integer>();
	queue.add(startVal);
	while(!queue.isEmpty()) {
	    int value = queue.poll();
	    if (!isVisited[value]) {
		System.out.print(value + " ");
		isVisited[value] = true;
	    }
	    adjacencyList[value].stream().filter(e -> !isVisited[e.destination.value]).forEach(e -> queue.add(e.destination.value));
	}
    }

    public static void main(String[] args) {
	GraphLinkedList graphLinkedList = new GraphLinkedList(7);
	graphLinkedList.addEdge(0, 1);
	graphLinkedList.addEdge(0, 2);
	graphLinkedList.addEdge(1, 2);
	graphLinkedList.addEdge(1, 3);
	graphLinkedList.addEdge(1, 4);
	graphLinkedList.addEdge(3, 4);
	graphLinkedList.addEdge(4, 5);
	graphLinkedList.addEdge(5, 6);

	System.out.println(graphLinkedList.isConnected(0, 1)); // True
	System.out.println(graphLinkedList.isConnected(1, 2)); // True
	System.out.println(graphLinkedList.isConnected(4, 3)); // False
	
	graphLinkedList.depthFirstSearch(0);
	System.out.println();
	graphLinkedList.breathFirstSearch(0);
    }
}
