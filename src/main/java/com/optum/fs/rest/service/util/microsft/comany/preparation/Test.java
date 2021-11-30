package com.optum.fs.rest.service.util.microsft.comany.preparation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test
{

    static final int NIL =-1;
    static List<Integer> count=new ArrayList<Integer>();

    class Graph{
        int V;
        LinkedList<Integer> adj[];
        int time=0;

        Graph(int v){
            V=v;
            adj= (LinkedList<Integer>[])new LinkedList[v];
            for(int i=0;i<v;i++){
                adj[i]=new LinkedList<Integer>();
            }

        }
        void addEdge(Integer v,Integer w){
            adj[v].add(w);
            adj[w].add(v);
        }
        void bridgeUtil(int u,boolean visited[],int disc[],int low[],int parent[]){

            visited[u]=true;
            disc[u]=low[u]=++time;
            Iterator<Integer> i= adj[u].iterator();
            while(i.hasNext()){
                int v=i.next();
                if(!visited[v]){
                    parent[v]=u;
                    bridgeUtil(v,visited,disc,low,parent);
                    low[u] = Math.min(low[u],low[v]);
                    if(low[v]>disc[u]){
                        count.add(u);
                    }
                }else if(v!=parent[u]){
                    low[u]=Math.min(low[u],disc[v]);
                }

            }
        }
        void bridge(){
            boolean visited[]=new boolean[V];
            int disc[]=new int[V];
            int low []=new int[V];
            int parent[]=new int[V];
            for(int i=0;i<V;i++){
                parent[i]=NIL;
                visited[i]=false;

            }
            for(int i=0;i<V;i++){
                if(visited[i]==false){
                    bridgeUtil(i,visited,disc,low,parent);
                }

            }
        }

    }
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<Integer> criticalRouters(int numRouters, int numLinks,
                                  ArrayList<ArrayList<Integer>> links)
    {
        Graph graph=new Graph(numRouters);
        for(int i=0;i<links.size();i++){
            ArrayList<Integer> nodes=links.get(i);
            Integer u=nodes.get(0);
            Integer v=nodes.get(1);
            graph.addEdge(u,v);

        }
        graph.bridge();
        return count;
    }

    // METHOD SIGNATURE ENDS
}