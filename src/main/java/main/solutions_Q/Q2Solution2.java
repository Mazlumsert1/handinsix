package main.solutions_Q;

import main.graph.Edge;
import main.graph.Graph;
import main.graph.Node;
import main.graph.TopologicalSort;

import java.util.*;

public class Q2Solutionode {
	public static void main(String[] args) {
		Graph graph = Q2Solutionode.GenereateDirectedcyclicGraph();
		TopologicalSort ts = new TopologicalSort();
		Stack<Node> stack = ts.topSort(graph);
		while(!stack.isEmpty()) {
			System.out.println(stack.pop().getId());
		}
	}

	public static Graph GenereateDirectedcyclicGraph() {
		Node node1 = new Node(1, new ArrayList<Edge>());
		Node node2 = new Node(2, new ArrayList<Edge>());
		Node node3 = new Node(3, new ArrayList<Edge>());
		Node node4 = new Node(4, new ArrayList<Edge>());
		Node node5 = new Node(5, new ArrayList<Edge>());
		Node node6 = new Node(6, new ArrayList<Edge>());
		Node node7 = new Node(7, new ArrayList<Edge>());

		node1.addEdgeTo(1, node2);
		node1.addEdgeTo(1, node3);
		node2.addEdgeTo(1, node4);
		node3.addEdgeTo(1, node4);
		node3.addEdgeTo(1, node5);
		node4.addEdgeTo(1, node7);
		node5.addEdgeTo(1, node6);
		node6.addEdgeTo(1, node4);



		List<Node> listNode = new ArrayList<Node>();

		listNode.add(node1);
		listNode.add(node2);
		listNode.add(node3);
		listNode.add(node4);
		listNode.add(node5);
		listNode.add(node6);
		listNode.add(node7);

		return new Graph(listNode);
	}
}
