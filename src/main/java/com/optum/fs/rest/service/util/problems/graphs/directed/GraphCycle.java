package com.optum.fs.rest.service.util.problems.graphs.directed;

import com.optum.fs.rest.service.util.problems.graphs.undirected.Graph;

public class GraphCycle {
	public boolean marked[];
	public boolean hasCycle;

	public GraphCycle(Graph G) {
		marked = new boolean[G.V()];
		for (int i = 0; i < G.V(); i++) {
			if (!marked[i]) {
				dfs(G, i, i);
			}
		}
	}

	private void dfs(Graph g, int v, int u) {
		marked[v] = true;
		for (int w : g.adj(v)) {
			if (!marked[w]) {
				dfs(g, w, v);
			} else if (w != u) {
				hasCycle = true;
			}
		}
		// TODO Auto-generated method stub

	}

	public boolean isHasCycle() {
		return hasCycle;
	}
}
