package com.optum.fs.rest.service.util.problems.graphs.undirected;

import com.optum.fs.rest.service.util.problems.graphs.directed.GraphCycle;

import java.util.ArrayList;
import java.util.List;

public class GraphMain {
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
		CC cc = new CC(g);
		int M = cc.count();
		System.out.println(M + " components");
		List<Integer>[] components;
		components = (List<Integer>[]) new ArrayList[M];
		for (int i = 0; i < M; i++)
			components[i] = new ArrayList<Integer>();
		for (int v = 0; v < g.V(); v++)
			components[cc.id(v)].add(v);
		for (int i = 0; i < M; i++) {
			for (int v : components[i])
				System.out.print(v + " ");
			System.out.println();
		}
		GraphCycle cycle = new GraphCycle(g);
		BiParitite bpt = new BiParitite(g);
		System.out.println(bpt.isTwoColourable());
		System.out.println(cycle.isHasCycle());
		MotherVertex mv = new MotherVertex(g);
		System.out.println("IS There a Mother Vertex " + mv.isMotherVertex());
		System.out.println(" Mother Vertex "
				+ (mv.isMotherVertex() == true ? mv.getMothVertex()
						: "Doesn't exist"));
	}
}
