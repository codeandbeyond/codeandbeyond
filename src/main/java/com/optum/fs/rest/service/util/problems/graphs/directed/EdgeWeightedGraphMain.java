package com.optum.fs.rest.service.util.problems.graphs.directed;

import java.util.Collections;
import java.util.List;

public class EdgeWeightedGraphMain {
	public static void main(String[] args) {
		Edge edge = new Edge(0, 1, 10);
		Edge edge1 = new Edge(1, 2, 5);
		Edge edge2 = new Edge(2, 3, 7);
		Edge edge3 = new Edge(3, 5, 4);
		Edge edge4 = new Edge(4, 5, 6);
		Edge edge5 = new Edge(7, 8, 10);
		EdgeWeightedGraph ewg = new EdgeWeightedGraph(10);
		ewg.addEdge(edge);
		ewg.addEdge(edge1);
		ewg.addEdge(edge2);
		ewg.addEdge(edge3);
		ewg.addEdge(edge4);
		ewg.addEdge(edge5);
		Collections.sort((List<Edge>) ewg.edges());
		for (Edge w : ewg.edges()) {
			System.out.println(w);
		}
	}
}
