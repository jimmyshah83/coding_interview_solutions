package com.practice.coding.solutions.dataStructures;

/*
 * Graph implementation using Adjacency Matrix
 * Storage O(V^2): where V is the number of vertices in the graph
 */
public class GraphAdjacencyMatrix {

    int[][] adjacencyMatrix;
    
    public GraphAdjacencyMatrix(int numberOfVertices) {
	adjacencyMatrix = new int[numberOfVertices][numberOfVertices];
    }
    
    /*
     * O(1): to add an edge in the graph
     */
    public void addEdge(int source, int destination) {
	adjacencyMatrix[source][destination] = 1;
    }
    
    /*
     * O(1): to identify if w vertices are connected
     */
    public boolean isConnected(int source, int destination) {
	return adjacencyMatrix[source][destination] == 1;
    }
    
    public static void main(String[] args) {
	GraphAdjacencyMatrix adjacencyMatrix = new GraphAdjacencyMatrix(7);
	adjacencyMatrix.addEdge(0, 1);
	adjacencyMatrix.addEdge(0, 2);
	adjacencyMatrix.addEdge(1, 2);
	adjacencyMatrix.addEdge(1, 3);
	adjacencyMatrix.addEdge(1, 4);
	adjacencyMatrix.addEdge(3, 4);
	adjacencyMatrix.addEdge(4, 5);
	adjacencyMatrix.addEdge(5, 6);
	
	System.out.println(adjacencyMatrix.isConnected(0, 1)); // True
	System.out.println(adjacencyMatrix.isConnected(1, 2)); // True
	System.out.println(adjacencyMatrix.isConnected(4, 3)); // False
    }
}
