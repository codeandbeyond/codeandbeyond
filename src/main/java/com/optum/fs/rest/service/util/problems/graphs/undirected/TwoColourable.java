package com.optum.fs.rest.service.util.problems.graphs.undirected;

public class TwoColourable {
    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable;


    TwoColourable(Graph g) {
        marked = new boolean[g.V()];
        color = new boolean[g.V()];
        for (int i = 0; i < g.V(); i++) {
            if (!marked[i]) {
                dfs(g, i);
            }
        }
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        color[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                color[w] = !color[v];
                dfs(g, w);
            } else if (color[w] == color[v]) {
                isTwoColorable = false;
            }
        }
    }

    private boolean isTwoColrable() {
        return isTwoColorable;
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        TwoColourable colourable = new TwoColourable(g);
        System.out.println(" Is the Graph two colorable " + colourable.isTwoColrable());
    }
}
