package com.optum.fs.rest.service.util.problems.graphs.directed;

import java.util.LinkedList;
import java.util.List;

public class EdgeWeightedGraph {
	private final int V; // number of vertices
	private int E; // number of edges
	private List<Edge>[] adj; // adjacency lists

	public EdgeWeightedGraph(int V) {
		this.V = V;
		this.E = 0;
		adj = (List<Edge>[]) new List[V];
		for (int v = 0; v < V; v++)
			adj[v] = new LinkedList<Edge>();
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public void addEdge(Edge e) {
		int v = e.either(), w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}

	public Iterable<Edge> adj(int v) {
		return adj[v];
	}

	public Iterable<Edge> edges() {
		List<Edge> b = new LinkedList<Edge>();
		for (int v = 0; v < V; v++)
			for (Edge e : adj[v])
				if (e.other(v) > v)
					b.add(e);
		return b;
	}
}
