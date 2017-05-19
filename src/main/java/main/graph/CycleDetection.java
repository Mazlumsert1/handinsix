package main.graph;

import java.util.*;

public class CycleDetection {

	private Map<Node, Node> parent = new HashMap();
	private Set<Node> cycleNode = new HashSet();

	public Set<Node> hasCycle(Graph graph) {
		Set<Node> whiteSet = new HashSet<Node>();
		Set<Node> greySet = new HashSet<Node>();
		Set<Node> blackSet = new HashSet<Node>();


		for (Node node : graph.getNodes()) {
			whiteSet.add(node);
		}

		while(whiteSet.size() > 0) {
			Node current = whiteSet.iterator().next();
			if (dfs(current, whiteSet, greySet, blackSet)) {
				return cycleNode;
			}
		}
		return null;
	}

	private boolean dfs(Node current, Set<Node> whiteSet, Set<Node> greySet, Set<Node> blackSet) {
		moveNode(current, whiteSet, greySet);
		for (Node neighbor: current.getAdjacent()) {
			parent.put(neighbor, current);
			if(blackSet.contains(neighbor)) {
				continue;
			}
			if(greySet.contains(neighbor)) {
				cycleNode.add(neighbor);
				while (current != neighbor) {
					cycleNode.add(current);
					current = parent.get(current);

				}
				return true;
			}
			if(dfs(neighbor, whiteSet, greySet, blackSet)) {
				return true;
			}
		}
		moveNode(current, greySet, blackSet);
		return false;
	}

	private void moveNode(Node node, Set<Node> fromSet, Set<Node> toSet) {
		fromSet.remove(node);
		toSet.add(node);
	}

}
