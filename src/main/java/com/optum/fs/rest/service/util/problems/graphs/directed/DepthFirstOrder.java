package com.optum.fs.rest.service.util.problems.graphs.directed;

import com.optum.fs.rest.service.util.problems.graphs.spanning.EdgeWeightedGraph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;

    DepthFirstOrder(DiGraph g) {
        marked = new boolean[g.V()];
        pre = new ArrayDeque<Integer>();
        post = new ArrayDeque<Integer>();
        reversePost = new Stack<Integer>();
        for (int i = 0; i < g.V(); i++) {
            if (!marked[i]) {
                dfs(g, i);
            }
        }
    }

    public DepthFirstOrder(EdgeWeightedGraph g) {
        marked = new boolean[g.V()];
        pre = new ArrayDeque<Integer>();
        post = new ArrayDeque<Integer>();
        reversePost = new Stack<Integer>();
        for (int i = 0; i < g.V(); i++) {
            if (!marked[i]) {
                dfs(g, i);
            }
        }
    }

    private void dfs(DiGraph g, int v) {
        marked[v] = true;
        pre.add(v);
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
        post.add(v);
        reversePost.push(v);
    }
    private void dfs(EdgeWeightedGraph g, int v) {
        marked[v] = true;
        pre.add(v);
        for (DirectedEdge e : g.adj(v)) {
            int w=e.to(v);
            if (!marked[w]) {
                dfs(g, w);
            }
        }
        post.add(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }
}
