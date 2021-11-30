package com.optum.fs.rest.service.util.problems.graphs.undirected;


public class BiParitite {

	public boolean colour[];
	public boolean marked[];
	public boolean isTwoColourable;

	public BiParitite(Graph G) {
		marked = new boolean[G.V()];
		colour = new boolean[G.V()];
		for (int i = 0; i < G.V(); i++) {
			if (!marked[i]) {
				dfs(G, i);
			}
		}
	}

	private void dfs(Graph g, int v) {
		marked[v] = true;
		for (int w : g.adj(v)) {
			if (!marked[w]) {
				colour[w] = !colour[v];
				dfs(g, w);
			} else if (colour[w] == colour[v]) {
				isTwoColourable = false;
			}
		}
		// TODO Auto-generated method stub

	}

	public boolean isTwoColourable() {
		return isTwoColourable;
	}

}
