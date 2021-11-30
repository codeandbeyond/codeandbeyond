package com.optum.fs.rest.service.util.problems.graphs.directed;

public class DirectedDfs {
    private boolean[] marked;
    private int[] sizeOfChild;


    public DirectedDfs(DiGraph graph, int s) {
        marked = new boolean[graph.V()];
        sizeOfChild = new int[graph.V()];
        dfs(graph, s);

    }

    private void dfs(DiGraph graph, int v) {
        marked[v] = true;
        sizeOfChild[v] = 1;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }

    }

    public boolean marked(int v) {
        return marked[v];
    }
}
