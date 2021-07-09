package com.optum.fs.rest.service.util.problems.graphs.directed;

import com.optum.fs.rest.service.util.problems.graphs.undirected.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IterativeDFS {
	private boolean[] marked;
	private Stack<Integer> stack;
	private Queue<Integer> q;

	public IterativeDFS(DiGraph g) {
		marked = new boolean[g.V()];
		for (int v = 0; v < g.V(); v++) {
			if (!marked[v]) {
				dfs(g, v);
			}
		}
	}

	public IterativeDFS(Graph g) {
		marked = new boolean[g.V()];
		for (int v = 0; v < g.V(); v++) {
			if (!marked[v]) {
				dfs(g, v);
			}
		}
	}

	private void dfs(DiGraph g, int v) {
		stack = new Stack<Integer>();
		q = new LinkedList<Integer>();
		q.add(v);
		marked[v] = true;
		stack.push(v);
		while (!stack.isEmpty()) {
			for (int w : g.adj(stack.pop())) {
				if (!marked[w]) {
					q.add(w);
					marked[w] = true;
					stack.push(w);
				}
			}
		}

	}

	private void dfs(Graph g, int v) {
		stack = new Stack<Integer>();
		q = new LinkedList<Integer>();
		q.add(v);
		marked[v] = true;
		stack.push(v);
		while (!stack.isEmpty()) {
			for (int w : g.adj(stack.pop())) {
				if (!marked[w]) {
					q.add(w);
					marked[w] = true;
					stack.push(w);
				}
			}
		}

	}

	public Iterable<Integer> order() {
		return q;
	}

	public void show() {
		for (int v : order()) {
			System.out.print(" " + v);
		}
	}

	public static void main(String[] args) {
		DiGraph g = new DiGraph(10);
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
		System.out.println(" Iterative DFS using Stack");
		IterativeDFS idfs = new IterativeDFS(g);
		idfs.show();
	}
}
