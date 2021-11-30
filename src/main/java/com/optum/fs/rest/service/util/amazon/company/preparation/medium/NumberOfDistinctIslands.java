package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

import com.optum.fs.rest.service.util.leetcode.NumberOfIsland;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]!=0){
                    StringBuilder sb = new StringBuilder();
                    dfs(grid,i,j,sb,"o");
                    grid[i][j] = 0;
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    public void dfs(int[][] grid, int i, int j, StringBuilder sb, String dir){
        if(i < 0 || i == grid.length || j < 0 || j== grid[i].length || grid[i][j] == 0){
            return;
        }

        grid[i][j] = 0;
        sb.append(dir);
        dfs(grid,i+1,j,sb,"u");
        dfs(grid,i-1,j,sb,"d");
        dfs(grid,i,j+1,sb,"r");
        dfs(grid,i,j-1,sb,"l");
        sb.append("b");
    }
    public static void main(String[] args) {
        int M[][] = {   { 0, 0, 1, 1, 0 },
                        { 1, 0, 1, 1, 0 },
                        { 0, 1, 0, 0, 0 },
                        { 0, 0, 0, 0, 1 } };
        NumberOfDistinctIslands numberOfIsland= new NumberOfDistinctIslands();
        System.out.println(numberOfIsland.numDistinctIslands(M));
    }
}
