package com.optum.fs.rest.service.util.problems.graphs.directed;

import java.util.Arrays;

public class SumofAllPaths {
    private boolean[] marked;
    private int[] sizeOfChild;

    public int getAns() {
        return ans;
    }

    private int ans;


    public SumofAllPaths(DiGraph graph, int s) {
        marked = new boolean[graph.V()];
        sizeOfChild = new int[graph.V()];
        dfs(graph, s);
        Arrays.fill(marked,false);
        contribution(graph,s);

    }

    private int dfs(DiGraph graph, int v) {
        marked[v] = true;
        sizeOfChild[v] = 1;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                sizeOfChild[v]+=dfs(graph, w);
            }
        }
        return sizeOfChild[v];

    }

    private void contribution(DiGraph graph, int v) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                ans += (sizeOfChild[w] * (graph.V() - sizeOfChild[w]));
                contribution(graph, w);
            }
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }
}
