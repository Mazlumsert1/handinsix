package main.graph;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {
    private Map<Long, Node> map = new HashMap<Long, Node>();

    class Node {
        long data;
        Node parent;
        int rank;
    }


    public void makeSet(long data) {
        Node node = new Node();
        node.data = data;
        node.parent = node;
        node.rank = 0;
        map.put(data, node);
    }


    public boolean union(long data1, long data2) {
        Node node1 = map.get(data1);
        Node node2 = map.get(data2);

        Node parent1 = findASet(node1);
        Node parent2 = findASet(node2);


        if (parent1.data == parent2.data) {
            return false;
        }


        if (parent1.rank >= parent2.rank) {
            parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
            parent2.parent = parent1;
        } else {
            parent1.parent = parent2;
        }
        return true;
    }


    public long findASet(long data) {
        return findASet(map.get(data)).data;
    }


    private Node findASet(Node node) {
        Node parent = node.parent;
        if (parent == node) {
            return parent;
        }
        node.parent = findASet(node.parent);
        return node.parent;
    }
}
