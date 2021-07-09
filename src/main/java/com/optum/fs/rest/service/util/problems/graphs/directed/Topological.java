package com.optum.fs.rest.service.util.problems.graphs.directed;

import com.optum.fs.rest.service.util.problems.graphs.spanning.EdgeWeightedGraph;

import java.io.IOException;

public class Topological {
    private Iterable<Integer> order;
    public Topological(DiGraph G)
    {
// topological order
        DirectedAcyclicGraph cyclefinder = new DirectedAcyclicGraph(G);
        if (!cyclefinder.hasCycle())
        {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    public Topological(EdgeWeightedGraph g) {
        DirectedAcyclicGraph cyclefinder = new DirectedAcyclicGraph(g);
        if (!cyclefinder.hasCycle())
        {
            DepthFirstOrder dfs = new DepthFirstOrder(g);
            order = dfs.reversePost();
        }
    }

    public Iterable<Integer> order()
    {  return order;  }
    public boolean isDAG()
    {  return order == null;  }
    public static void main(String[] args) throws IOException {
        DiGraph g = new DiGraph(10);
        g.addEdge(0, 2);
        g.addEdge(3, 5);
        g.addEdge(0, 3);
        g.addEdge(4, 2);
        g.addEdge(5, 4);
        g.addEdge(6, 7);
        g.addEdge(7, 8);
        g.addEdge(8, 9);
        g.addEdge(0, 1);
        String filename = "jobs.txt";
        String separator = "/";
        SymbolDiGraph sg = new SymbolDiGraph(filename, separator);
        Topological top = new Topological(g);
        for (int v : top.order())
            System.out.print(" "+v);
    }

    public boolean hasOrder() {
        return order!=null;
    }
}
