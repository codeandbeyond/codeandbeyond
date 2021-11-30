package com.optum.fs.rest.service.util.problems.graphs.undirected;

public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;

    Cycle(Graph g){
        marked = new boolean[g.V()];
        for(int i=0;i<g.V();i++){
            if(!marked[i]){
                dfs(g,i,i);
            }
        }
    }

    private void dfs(Graph g, int v, int u) {
        marked[v] = true;
        if(hasCycle) return;
        for(int w:g.adj(v)){
            if(!marked[w]){
                dfs(g,w,u);
            }else if(w!=u){
                hasCycle=true;
            }
        }
    }
    private  boolean hasCycle(){
        return hasCycle;
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,4);
        g.addEdge(2,3);
        g.addEdge(3,1);
        Cycle hasCycle=new Cycle(g);
        System.out.println(" The Graph has Cycle ? "+hasCycle.hasCycle());
    }
}
