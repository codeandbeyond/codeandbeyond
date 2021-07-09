package com.optum.fs.rest.service.util.problems.graphs.directed;

public class DiGraphMain {
	public static void main(String[] args) {
		DiGraph g = new DiGraph(10);
		g.addEdge(0, 2);
		g.addEdge(3, 5);
		g.addEdge(0, 3);
		g.addEdge(4, 2);
		g.addEdge(5, 4);
		g.addEdge(6, 7);
		g.addEdge(7, 8);
		g.addEdge(8, 9);
		g.addEdge(0, 1);
		DirectedDfs dfs = new DirectedDfs(g,0);
		SumofAllPaths sumofAllPaths = new SumofAllPaths(g,0);
        System.out.println(sumofAllPaths.getAns());
		for(int i=0;i<g.V();i++){
		    if(dfs.marked(i)){
                System.out.print(" "+i);
            }
        }
        System.out.println(" ");
		for (int v = 0; v < g.V(); v++) {
			System.out.println(v + " " + g.adj(v));
		}

        DirectedAcyclicGraph dag =new DirectedAcyclicGraph(g);
        System.out.println(" Is there a cycle in the Graph : "+dag.hasCycle());
        for (int w:dag.cycle()){
            System.out.print(" "+w);
        }
	}
}
