package com.optum.fs.rest.service.util.problems.graphs.undirected;


import java.util.ArrayList;
import java.util.List;

public class CC {
	private boolean[] marked;
	private int[] id;
	private int count;

	public CC(Graph G) {
		marked = new boolean[G.V()];
		id = new int[G.V()];
		for (int s = 0; s < G.V(); s++)
			if (!marked[s]) {
				dfs(G, s);
				count++;
			}
	}

	private void dfs(Graph G, int v) {
		marked[v] = true;
		id[v] = count;
		for (int w : G.adj(v))
			if (!marked[w])
				dfs(G, w);
	}

	public boolean connected(int v, int w) {
		return id[v] == id[w];
	}

	public int id(int v) {
		return id[v];
	}

	public int count() {
		return count;
	}

	public static void main(String[] args) {
		Graph g = new Graph(10);
		g.addEdge(0, 2);
		g.addEdge(2, 4);
		g.addEdge(0, 3);
		g.addEdge(7, 5);
		g.addEdge(5, 4);
		g.addEdge(5, 6);
		g.addEdge(6, 7);
		g.addEdge(9, 8);
		g.addEdge(8, 9);
		g.addEdge(0, 1);
		CC cc = new CC(g);
		int M = cc.count();
		System.out.println(M + " components");
		List<Integer>[] components;
		components = (List<Integer>[]) new List[M];
		for (int i = 0; i < M; i++)
			components[i] = new ArrayList<Integer>();
		for (int v = 0; v < g.V(); v++)
			components[cc.id(v)].add(v);
		for (int i = 0; i < M; i++)
		{
			for (int v: components[i])
                System.out.print(v + " ");
            System.out.println();
		}
	}
}