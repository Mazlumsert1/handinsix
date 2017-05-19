package main.graph;

import java.util.*;

public class TopologicalSort {

	private Set<Node> OrderedSet = new HashSet<Node>();

	public Stack<Node> topSort(Graph graph) {
		Stack<Node> stack = new Stack<Node>();
		Set<Node> visited = new HashSet();
		for (Node node: graph.getNodes()) {
			if(visited.contains(node)) {
				continue;
			} else {
				topSortUtil(node, stack, visited);
			}
		}
		return stack;
	}

	private void topSortUtil(Node node, Stack<Node> stack, Set<Node> visited) {
		visited.add(node);
		for (Node child: node.getAdjacent()) {
			if(visited.contains(child)) {
				continue;
			} else {
				topSortUtil(child, stack, visited);
			}
		}
		stack.push(node);
	}

}
