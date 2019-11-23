package com.practice.coding.solutions.dataStructures;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GraphArrayList {

    static class Node {
	int value;
	List<Node> neighbours;
	boolean isVisited;

	public Node(int value) {
	    this.value = value;
	    neighbours = new ArrayList<Node>();
	    this.isVisited = false;
	}

	public void addNeighbours(Node node) {
	    neighbours.add(node);
	}
    }

    private List<List<Node>> graph;

    public GraphArrayList() {
	graph = new ArrayList<List<Node>>();
    }

    public boolean isConnected(int source, int destination) {
	for (List<Node> nodes : graph) {
	    for (Node node : nodes) {
		if (source == node.value) {
		    for (Node n : node.neighbours) {
			if (n.value == destination)
			    return true;
		    }
		}
	    }
	}
	return false;
    }

    public void depthFirstSearch(int startVal) {
	Stack<Integer> stack = new Stack<Integer>();
	stack.add(startVal);
	while (!stack.isEmpty()) {
	    int value = stack.pop();
	    graph.forEach(nodes -> {
		nodes.stream().filter(node -> node.value == value).findFirst().ifPresent(node -> {
		    System.out.print(value + " ");
		    node.isVisited = true;
		    node.neighbours.stream().filter(n -> !n.isVisited && !stack.contains(n.value)).forEach(n -> stack.add(n.value));
		});
	    });
	}
    }

    public void breathFirstSearch(int startVal) {
	Queue<Integer> queue = new ArrayDeque<Integer>();
	queue.add(startVal);
	while (!queue.isEmpty()) {
	    int value = queue.poll();
	    graph.forEach(nodes -> {
		nodes.stream().filter(node -> node.value == value).findFirst().ifPresent(node -> {
		    System.out.print(value + " ");
		    node.isVisited = true;
		    node.neighbours.stream().filter(n -> !n.isVisited && !queue.contains(n.value)).forEach(n -> queue.add(n.value));
		});
	    });
	}
    }

    public static void main(String[] args) {
	GraphArrayList graphArrayList = new GraphArrayList();
	Node node40 = new Node(40);
	Node node20 = new Node(20);
	Node node50 = new Node(50);
	Node node70 = new Node(70);
	Node node60 = new Node(60);
	Node node30 = new Node(30);
	Node node10 = new Node(10);

	node40.addNeighbours(node20);
	node40.addNeighbours(node10);
	node20.addNeighbours(node50);
	node20.addNeighbours(node30);
	node20.addNeighbours(node60);
	node20.addNeighbours(node10);
	node30.addNeighbours(node60);
	node50.addNeighbours(node70);
	node60.addNeighbours(node70);

	List<Node> list = new ArrayList<GraphArrayList.Node>();
	list.add(node40);
	list.add(node20);
	list.add(node50);
	list.add(node70);
	list.add(node60);
	list.add(node30);
	list.add(node10);

	graphArrayList.graph.add(list);

	System.out.println(graphArrayList.isConnected(40, 10)); // True
	System.out.println(graphArrayList.isConnected(20, 60)); // True
	System.out.println(graphArrayList.isConnected(10, 20)); // False

	graphArrayList.depthFirstSearch(40);
	//graphArrayList.breathFirstSearch(40);
    }
}
