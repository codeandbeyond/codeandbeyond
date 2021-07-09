package com.optum.fs.rest.service.util.problems.graphs.leetcode;

public class RedundantConnectionUnionFind {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{1,2},{1,3},{2,3}};
        RedundantConnectionUnionFind redundantConnectionUnionFind = new RedundantConnectionUnionFind();
        int[]edge = redundantConnectionUnionFind.findRedundantConnection(edges);
        System.out.println(edge[0]+"-->"+edge[1]);
    }
    int[] id;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        id = new int[n+1];

        for(int i=0;i<n;i++){
            id[i] = i;
        }

        for(int[] edge:edges){
            if(!union(edge[0],edge[1])) return edge;
        }

        return new int[]{-1,-1};

    }

    public boolean union(int x, int y){
        int p = find(x);
        int q = find(y);
        if(p==q) return false;

        id[p] = q;
        return true;
    }

    public int find(int x){
        while(x!=id[x]){
            x= id[x];
        }

        return x;
    }
}
