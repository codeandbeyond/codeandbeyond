package com.optum.fs.rest.service.util.problems.graphs.undirected;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstSearch {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;
    private int count;

    BreadthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        count = 0;
        bfs(G, s);
    }

    private void bfs(Graph g, int s) {
        Queue<Integer> queue = new ArrayDeque<Integer>();
        marked[s] = true;
        queue.add(s);
        count++;
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int w : g.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.add(w);
                }
            }
        }
    }

    private boolean marked(int w) {
        return marked[w];
    }

    boolean hasPathTo(int v) {
        return marked[v];

    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
    public static void main(String[] args) {
        int source=0;
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
        BreadthFirstSearch paths=new BreadthFirstSearch(g,source);
        System.out.println(" is there a path to 9 "+paths.hasPathTo(9));
        for(int w:paths.pathTo(9)){
            if(w==9)
                System.out.print(w);
            else
                System.out.print(" - "+w);
        }
    }
}
