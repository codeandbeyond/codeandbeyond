package com.optum.fs.rest.service.util.problems.graphs.undirected;

public class DepthFirstSearch {

    private boolean[] marked;
    private int count;

    DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        count = 0;
        dfs(G, s);
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        count++;
        for (int w : g.adj(v)) {
            if (!marked(w)) {
                dfs(g, w);
            }
        }
    }

    private boolean marked(int w) {
        return marked[w];
    }

    private int getCount() {
        return count;
    }

    public static void main(String[] args) {

        Graph g = new Graph(10);
        g.addEdge(0, 2);
        g.addEdge(2, 4);
        g.addEdge(0, 3);
        g.addEdge(3, 5);
        g.addEdge(5, 4);
        g.addEdge(5, 6);
        g.addEdge(6, 7);
        g.addEdge(7, 8);
        g.addEdge(8, 9);
        g.addEdge(0, 1);
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(g, 0);
        System.out.println(" "+depthFirstSearch.getCount()+" is Marked 2 "+depthFirstSearch.marked(2));

    }
}
