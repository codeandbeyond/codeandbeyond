package com.optum.fs.rest.service.util.problems.graphs.directed;

public class DirectedEdge implements Comparable<DirectedEdge> {
	private final int v; // one vertex
	private final int w; // the other vertex
	private final double weight; // edge weight

	public DirectedEdge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	public double weight() {
		return weight;
	}

	public int from() {
		return this.v;
	}

	public int to(int vertex) {
		if (vertex == v)
			return w;
		else if (vertex == w)
			return v;
		else
			throw new RuntimeException("Inconsistent edge");
	}

	public int compareTo(DirectedEdge that) {
		if (this.weight() < that.weight())
			return -1;
		else if (this.weight() > that.weight())
			return +1;
		else
			return 0;
	}

	public String toString() {
		return String.format("%d-%d %.2f", v, w, weight);
	}
}