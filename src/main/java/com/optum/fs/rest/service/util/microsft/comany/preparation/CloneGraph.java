package com.optum.fs.rest.service.util.microsft.comany.preparation;

import java.util.*;

class Node {
    int val;
    List<Node> neighbors;

    public Node() {
        this.neighbors = new ArrayList<>();
    }

    public Node(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();

    }

    public <E> Node(int val, ArrayList<E> es) {
        this.val = val;
        this.neighbors = new ArrayList<>();

    }
}

public class CloneGraph {


    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        if (node == null) return node;
        if (!map.containsKey(node)) {
            map.put(node, new Node(node.val, new ArrayList<>()));
        }
        queue.add(node);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            for (Node neighbour : temp.neighbors) {
                if (!map.containsKey(neighbour)) {
                    map.put(neighbour, new Node(neighbour.val, new ArrayList<>()));
                }
                queue.add(neighbour);
                map.get(temp).neighbors.add(map.get(neighbour));
            }
        }

        return map.get(node);

    }

}
