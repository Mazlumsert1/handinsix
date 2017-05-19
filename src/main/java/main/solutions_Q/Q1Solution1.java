package main.solutions_Q;

import main.graph.Edge;
import main.graph.Graph;
import main.graph.Node;
import main.graph.CycleDetection;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Q1Solution1 {
	public static void main(String[] args) {

		Graph graph = Q1Solution1.generateDirectedGraph();

		CycleDetection df = new CycleDetection();

		Set<Node> cycleSet = df.hasCycle(graph);

		for (Node node: cycleSet) {
			System.out.println(node.getId());
		}

	}

	public static Graph generateDirectedGraph() {
		Node node1 = new Node(1, new ArrayList<Edge>());
		Node node2 = new Node(2, new ArrayList<Edge>());
		Node node3 = new Node(3, new ArrayList<Edge>());
		Node node4 = new Node(4, new ArrayList<Edge>());
		Node node5 = new Node(5, new ArrayList<Edge>());
		Node node6 = new Node(6, new ArrayList<Edge>());
		Node node7 = new Node(7, new ArrayList<Edge>());
		Node node8 = new Node(8, new ArrayList<Edge>());
		Node node9 = new Node(9, new ArrayList<Edge>());


		node1.addEdgeTo(3, node2);
		node1.addEdgeTo(5, node7);
		node1.addEdgeTo(9, node8);
		node2.addEdgeTo(4, node3);
		node3.addEdgeTo(2, node2);
		node3.addEdgeTo(1, node4);
		node4.addEdgeTo(7, node5);
		node5.addEdgeTo(9, node6);
		node6.addEdgeTo(3, node3);
		node8.addEdgeTo(7, node9);

		List<Node> nodeList = new ArrayList<Node>();

		nodeList.add(node1);
		nodeList.add(node2);
		nodeList.add(node3);
		nodeList.add(node4);
		nodeList.add(node5);
		nodeList.add(node6);
		nodeList.add(node7);
		nodeList.add(node8);
		nodeList.add(node9);

		return new Graph(nodeList);
	}
}
