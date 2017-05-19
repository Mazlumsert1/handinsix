package main.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumSpanningTree {
    public List<Edge> getMinimumSpanningThree(Graph graph) {
        List<Edge> allEdges = new ArrayList<Edge>();
        for (Node node : graph.getNodes()) {
            for (Edge edge : node.getEdges()) {
                allEdges.add(edge);
            }
        }
        EdgeComparator comparator = new EdgeComparator();

        Collections.sort(allEdges, comparator);
        DisjointSet disjointSet = new DisjointSet();

        for (Node node : graph.getNodes()) {
            disjointSet.makeSet(node.getId());
        }

        List<Edge> resultEdges = new ArrayList<Edge>();

        for (Edge edge : allEdges) {
            long firstroot = disjointSet.findASet(edge.getFrom().getId());
            long secondroot = disjointSet.findASet(edge.getTo().getId());

            if(firstroot == secondroot) {
                continue;
            } else {
                resultEdges.add(edge);
                disjointSet.union(edge.getFrom().getId(), edge.getTo().getId());
            }
        }
        return resultEdges;
    }

}
