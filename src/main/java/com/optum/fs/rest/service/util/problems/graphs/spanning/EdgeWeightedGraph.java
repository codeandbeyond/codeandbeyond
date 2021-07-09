package com.optum.fs.rest.service.util.problems.graphs.spanning;

import com.optum.fs.rest.service.util.problems.graphs.directed.DirectedEdge;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedGraph {
    private final int V;
    private int E;
    private List<DirectedEdge>[] adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (List<DirectedEdge>[]) new List[V];
        for (int v = 0; v < V; v++)
            adj[v] = new ArrayList<DirectedEdge>();
    }

    // See Exercise 4.3.9.
    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(DirectedEdge e) {

        int v = e.from(), w = e.to(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<DirectedEdge> edges() {
        List<DirectedEdge> b = new ArrayList<DirectedEdge>();
        for (int v = 0; v < V; v++)
            for (DirectedEdge e : adj[v])
                if (e.from() > v) b.add(e);
        return b;
    }
    // See page 609.
}

